package ssi.framework.mybatisGenerator;

import com.mysql.jdbc.StringUtils;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * @author hjgen
 */
public class MyCommentGenerator implements CommentGenerator {

    public void addConfigurationProperties(Properties properties) {
//		if (properties.containsKey("generatorComment")) {
//			String name = properties.getProperty("generatorComment");
//			InputStream stream = MyCommentGenerator.class.getResourceAsStream(name);
//			if (stream != null) {
//				try {
//					CommentProvider.initialize(stream);
//					stream.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			} else {
//				System.err.println("generator comment file not found:" + name);
//			}
//		}
    }

    public void addFieldComment(Field field,
                                IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {

        addJavaDocLine(field, getColumnTitle(introspectedColumn));
    }

    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        String comment = CommentProvider.getInstance().getComment(field.getName(), false);
        if (comment == null && field.getName().endsWith("HasSetted")) {
            String fieldName = field.getName().substring(0, field.getName().length() - "HasSetted".length());
            comment = getColumnTitle(fieldName, introspectedTable);
            comment = CommentProvider.format(CommentProvider.getInstance().getComment("field.suffix.HasSetted", true), comment);
        }
        if (comment == null)
            comment = CommentProvider.getInstance().getComment(field.getName(), true);
        addJavaDocLine(field, comment);
    }

    public void addClassComment(InnerClass innerClass,
                                IntrospectedTable introspectedTable) {
        addJavaDocLine(innerClass, CommentProvider.getInstance().getClassComment(innerClass.getType().getShortName(), true));
    }

    public void addClassComment(InnerClass innerClass,
                                IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        addJavaDocLine(innerClass, CommentProvider.getInstance().getClassComment(innerClass.getType().getShortName(), true));
    }

    public void addEnumComment(InnerEnum innerEnum,
                               IntrospectedTable introspectedTable) {
        addJavaDocLine(innerEnum, "enum");
    }

    public void addGetterComment(Method method,
                                 IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {

        addJavaDocLine(method, CommentProvider.format(CommentProvider.getInstance().getComment("method.prefix.get", true),
                getColumnTitle(introspectedColumn)));
    }

    public void addSetterComment(Method method,
                                 IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {
        addJavaDocLine(method, CommentProvider.format(CommentProvider.getInstance().getComment("method.prefix.set", true),
                getColumnTitle(introspectedColumn)));
    }

    public void addGeneralMethodComment(Method method,
                                        IntrospectedTable introspectedTable) {
        if (method.isConstructor())
            addJavaDocLine(method, CommentProvider.format(CommentProvider.getInstance().getComment("method.constructor", true),
                    CommentProvider.getInstance().getClassComment(method.getName(), true)));
        else if (method.getName().endsWith("HasSetted") && method.getName().startsWith("is")) {
            String fieldName = method.getName().substring(2, method.getName().length() - "HasSetted".length());
            String comment = getColumnTitle(fieldName, introspectedTable);
            comment = CommentProvider.format(CommentProvider.getInstance().getComment("method.suffix.HasSetted", true), comment);
            addJavaDocLine(method, comment);
        } else {
            addJavaDocLine(method, getMethodCommentWithTableName(method.getName(), introspectedTable.getFullyQualifiedTableNameAtRuntime()));
        }
    }

    public void addJavaFileComment(CompilationUnit compilationUnit) {
        //compilationUnit.addFileCommentLine("/* " + getDateString() + " */");
    }

    public void addComment(XmlElement xmlElement) {
        //xmlElement.addElement(new TextElement("<!-- " + xmlElement.getName() + " -->"));
    }

    @SuppressWarnings("unchecked")
    public void addRootComment(XmlElement rootElement) {
        if (rootElement.getName().equals("mapper")) {
            String namespace = getAttribute(rootElement, "namespace");
            if (namespace == null)
                return;

            List<String> ss = StringUtils.split(namespace, ".", true);
            namespace = ss.get(ss.size() - 1);
            namespace = CommentProvider.getInstance().getClassComment(namespace, false);
            if (namespace != null)
                rootElement.addElement(new TextElement("<!-- " + namespace + " -->"));
        }
    }

    private String getAttribute(XmlElement xmlElement, String attributeName) {
        List<Attribute> attrs = xmlElement.getAttributes();
        for (Attribute attr : attrs) {
            if (attr.getName().equals(attributeName))
                return attr.getValue();
        }
        return null;
    }

    private String getColumnTitle(IntrospectedColumn introspectedColumn) {
        if (StringUtils.isNullOrEmpty(introspectedColumn.getRemarks())) {
            return CommentProvider.getInstance().getComment(introspectedColumn.getActualColumnName(), true);
        }
        return introspectedColumn.getRemarks();
    }

    private String getColumnTitle(String fieldName, IntrospectedTable introspectedTable) {
        for (IntrospectedColumn column : introspectedTable.getAllColumns()) {
            if (column.getJavaProperty().equals(fieldName))
                return getColumnTitle(column);
        }
        return CommentProvider.getInstance().getComment(fieldName, true);
    }

    private void addJavaDocLine(JavaElement elem, String comment) {
        elem.addJavaDocLine("/** " + comment + " */");
    }

    private String getMethodCommentWithTableName(String methodName, String tableName) {
        HashMap<String, String> prefixComments = CommentProvider.getInstance().getMethodPrefixComments();
        if (prefixComments.containsKey(methodName)) {
            String domainObjectName = DomainObjectNameUtils.getDomainObjectNameByTableName(tableName);
            if (domainObjectName == null) return "";
            return CommentProvider.format(prefixComments.get(methodName),
                    CommentProvider.getInstance().getClassComment(domainObjectName, true));
        }
        return CommentProvider.getInstance().getMethodComment(methodName, true);
    }
}
