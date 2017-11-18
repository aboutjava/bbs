package ssi.framework.mybatisGenerator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;


public class ModelBaseRecordSerializablePlugin extends PluginAdapter {

	public boolean validate(List<String> warnings) {
		return true;
	}
	
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
		topLevelClass.addImportedType(new FullyQualifiedJavaType("java.io.Serializable"));
		topLevelClass.addSuperInterface(new FullyQualifiedJavaType("java.io.Serializable"));
		topLevelClass.addAnnotation("@SuppressWarnings(\"serial\")");
        return true;
    }
    
}
