package ssi.framework.mybatisGenerator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import ssi.framework.mybatisGenerator.CommentProvider;


public class TopLevelClassCommentPlugin extends PluginAdapter {

	public boolean validate(List<String> warnings) {
		return true;
	}
	
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
		addComment(topLevelClass);
        return true;
    }

    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
    	addComment(topLevelClass);
        return true;
    }

    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
    	addComment(topLevelClass);
        return true;
    }
    
    public boolean clientGenerated(Interface interfaze,
            TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
    	interfaze.addJavaDocLine("/** " + CommentProvider.getInstance().getClassComment(interfaze.getType().getShortName(), true) + " */");
        return true;
    }
    
    private void addComment(TopLevelClass topLevelClass) {
    	if (topLevelClass != null) {
    		topLevelClass.addJavaDocLine("/** " + CommentProvider.getInstance().getClassComment(topLevelClass.getType().getShortName(), true) + " */");
    	}
    }
}
