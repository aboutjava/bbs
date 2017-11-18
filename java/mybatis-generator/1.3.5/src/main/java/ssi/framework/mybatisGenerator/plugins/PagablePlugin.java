package ssi.framework.mybatisGenerator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import ssi.framework.mybatisGenerator.CommentProvider;


public class PagablePlugin extends PluginAdapter {

	public boolean validate(List<String> warnings) {
		return true;
	}
	
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
		MakePagable(topLevelClass, introspectedTable);
        return true;
    }
	
	private void MakePagable(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
		AddProperty("skipRowCount", new FullyQualifiedJavaType("Integer"), topLevelClass, introspectedTable);
		Field field = AddProperty("takeRowCount", new FullyQualifiedJavaType("Integer"), topLevelClass, introspectedTable);
		field.setInitializationString("20");
	}
	
	private Field AddProperty(String propertyName, FullyQualifiedJavaType javaType, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		Field field = new Field();
        field.setName(propertyName);
        field.setType(javaType);
        field.setVisibility(JavaVisibility.PRIVATE);
        context.getCommentGenerator().addFieldComment(field, introspectedTable);
        
        Method getterMethod = new Method();
        getterMethod.setName("get" + CommentProvider.toFirstUpperCase(propertyName));
        getterMethod.setReturnType(javaType);
        getterMethod.setVisibility(JavaVisibility.PUBLIC);
        getterMethod.addBodyLine("return this." + propertyName + ";");
        context.getCommentGenerator().addGeneralMethodComment(getterMethod, introspectedTable);
        
        Method setterMethod = new Method();
        setterMethod.setName("set" + CommentProvider.toFirstUpperCase(propertyName));
        setterMethod.setVisibility(JavaVisibility.PUBLIC);
        Parameter parameter = new Parameter(javaType, propertyName);
        setterMethod.addParameter(parameter);
        if("takeRowCount".equals(propertyName)) {
            setterMethod.addBodyLine("if (this.skipRowCount == null) this.skipRowCount = 0;");
        }
        setterMethod.addBodyLine(String.format("this.%s = %s;", propertyName, propertyName));
        context.getCommentGenerator().addGeneralMethodComment(setterMethod, introspectedTable);

        topLevelClass.addField(field);
        topLevelClass.addMethod(getterMethod);
        topLevelClass.addMethod(setterMethod);
        
        return field;
	}
	
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(
            XmlElement element, IntrospectedTable introspectedTable) {
		addPagingCondition(element);
        return true;
    }

    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(
            XmlElement element, IntrospectedTable introspectedTable) {
    	addPagingCondition(element);
        return true;
    }
    
    private void addPagingCondition(XmlElement element) {
    	XmlElement ifElement = new XmlElement("if");
        ifElement.addAttribute(new Attribute("test", "skipRowCount != null")); 
        ifElement.addElement(new TextElement("limit ${skipRowCount},${takeRowCount}"));
        element.addElement(ifElement);
    }
}
