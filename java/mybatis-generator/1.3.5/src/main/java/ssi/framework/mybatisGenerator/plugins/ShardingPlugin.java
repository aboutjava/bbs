package ssi.framework.mybatisGenerator.plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import ssi.framework.mybatisGenerator.CommentProvider;
import ssi.framework.mybatisGenerator.ShardingTableHelper;

import java.util.List;


public class ShardingPlugin extends PluginAdapter {

    public boolean validate(List<String> warnings) {
        return true;
    }

    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
                                              IntrospectedTable introspectedTable) {
        if (ShardingTableHelper.isShardingTable(introspectedTable.getFullyQualifiedTable().getIntrospectedTableName())) {
            addProperties(topLevelClass, introspectedTable);
        }
        return true;
    }

    private void addProperties(TopLevelClass topLevelClass,
                               IntrospectedTable introspectedTable) {
        AddProperty("tableNo", new FullyQualifiedJavaType("String"), topLevelClass, introspectedTable);
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
        setterMethod.addBodyLine(String.format("this.%s = %s;", propertyName, propertyName));
        context.getCommentGenerator().addGeneralMethodComment(setterMethod, introspectedTable);

        topLevelClass.addField(field);
        topLevelClass.addMethod(getterMethod);
        topLevelClass.addMethod(setterMethod);

        return field;
    }
}
