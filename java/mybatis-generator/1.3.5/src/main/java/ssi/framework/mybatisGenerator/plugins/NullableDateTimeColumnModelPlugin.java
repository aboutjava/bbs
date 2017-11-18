package ssi.framework.mybatisGenerator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.Plugin;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import ssi.framework.mybatisGenerator.CommentProvider;


/**
 * 可为空的日期时间列，增加 columnNameHasSetted 属性，更新时判断此属性
 */
public class NullableDateTimeColumnModelPlugin extends PluginAdapter {

	public boolean validate(List<String> warnings) {
		return true;
	}
	
	public boolean modelFieldGenerated(Field field,
            TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
            IntrospectedTable introspectedTable,
            Plugin.ModelClassType modelClassType) {		
		
		if(isHandleTarget(introspectedColumn)) {
			MakeNullableDateTimeSettable(field, topLevelClass, introspectedTable, introspectedColumn);
		}
		
        return true;
    }
	
	public boolean modelSetterMethodGenerated(Method method,
            TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
            IntrospectedTable introspectedTable,
            Plugin.ModelClassType modelClassType) {
		
		if(isHandleTarget(introspectedColumn)) {
			String propertyName = getHasSettedFieldName(introspectedColumn.getJavaProperty());
			method.addBodyLine("this." + propertyName + " = true;");
		}
        return true;
    }
	
	private void MakeNullableDateTimeSettable(Field field, TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		String propertyName = getHasSettedFieldName(field.getName());
		FullyQualifiedJavaType javaType = FullyQualifiedJavaType.getBooleanPrimitiveInstance();
		field = new Field();
        field.setName(propertyName);
        field.setType(javaType);
        field.setVisibility(JavaVisibility.PRIVATE);
        context.getCommentGenerator().addFieldComment(field, introspectedTable);
        
        Method getterMethod = new Method();
        getterMethod.setName("is" + CommentProvider.toFirstUpperCase(propertyName));
        getterMethod.setReturnType(javaType);
        getterMethod.setVisibility(JavaVisibility.PUBLIC);
        getterMethod.addBodyLine("return this." + propertyName + ";");
        context.getCommentGenerator().addGeneralMethodComment(getterMethod, introspectedTable);

        topLevelClass.addField(field);
        topLevelClass.addMethod(getterMethod);
	}
	
	private String getHasSettedFieldName(String rawFiledName) {
		return rawFiledName + "HasSetted";
	}
	
	private boolean isHandleTarget(IntrospectedColumn introspectedColumn) {
		return introspectedColumn.isNullable() && (introspectedColumn.isJDBCDateColumn() || introspectedColumn.isJDBCTimeColumn());
	}
}
