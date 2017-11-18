package ssi.framework.mybatisGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;

public class CommentProvider {
	private static CommentProvider instance = null;
	private HashMap<String, String> comments;
	private HashMap<String, String> methodPrefixComments;
	private HashMap<String, String> classSuffixComments;
	
	private CommentProvider(InputStream stream) throws IOException {
		comments = new HashMap<String, String>();
		methodPrefixComments = new HashMap<String, String>();
		classSuffixComments = new HashMap<String, String>();
		
		comments.clear();
		
		InputStream baseStream = this.getClass().getResourceAsStream("/generatorComments.txt");
		if (baseStream != null)
			InitializeInternal(baseStream);
		if (stream != null)
			InitializeInternal(stream);
	}
	
	private void InitializeInternal(InputStream stream) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(stream));
		String line = br.readLine();
		while(line != null) {
			int index = line.indexOf('=');
			if (index > 0) {
				String key = line.substring(0, index).trim();
				String value = line.substring(index + 1).trim();
				
				if (!comments.containsKey(key))
					comments.put(key, value);
				
				if (key.startsWith("method.prefix.")) {
					key = key.substring("method.prefix.".length());
					if (!methodPrefixComments.containsKey(key))
						methodPrefixComments.put(key, value);
				} else if (key.startsWith("class.suffix.")) {
					key = key.substring("class.suffix.".length());
					if (!classSuffixComments.containsKey(key))
						classSuffixComments.put(key, value);
				} 
			}
			line = br.readLine();
		}
		br.close();
	}
	
	public static CommentProvider getInstance() { 
		if (instance == null) {
			try {
				instance = new CommentProvider(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	public static void initialize(InputStream stream) throws IOException {
		try {
			instance = new CommentProvider(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
	private String getMethodCommentIgnorePrefix(String methodName) {
		String comment = getComment("method." + methodName, false);
		if (comment != null)
			return comment;
		return getComment(methodName, false);
	}
	
	public HashMap<String, String> getMethodPrefixComments() {
		return methodPrefixComments;
	}
	
	public String getClassCommentIgnorePrefix(String className) {
		String comment = getComment("class." + className, false);
		if (comment != null)
			return comment;
		return getComment(className, false);
	}
	
	public String getComment(String key, boolean returnKeyWhenNotFound) {
		if (comments.containsKey(key))
			return comments.get(key);
		if (returnKeyWhenNotFound)
			return key;
		return null;
	}
	
	public String getMethodComment(String methodName, boolean returnMethodNameWhenNotFound) {
		String comment = getMethodCommentIgnorePrefix(methodName);
		if (comment != null)
			return comment;
		
		for(String prefix : methodPrefixComments.keySet()) {
			if (methodName.startsWith(prefix)) {
				comment = getClassComment(methodName.substring(prefix.length()), false);
				if (comment == null)
					comment = getMethodCommentIgnorePrefix(toFirstLowerCase(methodName.substring(prefix.length())));
				if (comment != null)
					return format(methodPrefixComments.get(prefix), comment);
			}
		}
		
		if (returnMethodNameWhenNotFound)
			return methodName;
		return null;
	}
	
	public String getClassComment(String className, boolean returnClassNameWhenNotFound) {
		String comment = getClassCommentIgnorePrefix(className);
		if (comment != null)
			return comment;
		
		for(String suffix : classSuffixComments.keySet()) {
			if (className.endsWith(suffix)) {
				comment = getClassCommentIgnorePrefix(className.substring(0, className.length() - suffix.length()));
				if (comment != null)
					return format(classSuffixComments.get(suffix), comment);
			}
		}
		
		if (returnClassNameWhenNotFound)
			return className;
		return null;
	}
	
	public static String toFirstLowerCase(String s) {
		if (s == null || s.length() == 0)
			return s;
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}
	
	public static String toFirstUpperCase(String s) {
		if (s == null || s.length() == 0)
			return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}
	
	public static String format(String format, String arg) {
		return format.replaceAll("#1#", arg);
	}
	
	public void initializeMysqlTableName(java.sql.Connection conn) {
		Set<String> tableNames = DomainObjectNameUtils.getTableNames();
		try {
			for(String tableName : tableNames) {
				java.sql.Statement stmt = conn.createStatement();
				java.sql.ResultSet rs = stmt.executeQuery("SHOW TABLE STATUS LIKE '" + tableName + "'");
				if (rs.next()) {
					String comment = rs.getString("COMMENT");
					if (comment == null) continue;
					comment = comment.trim();
					if (comment.length() > 0) {
						String domainName = DomainObjectNameUtils.getDomainObjectNameByTableName(tableName);
						if (!comments.containsKey(domainName)) {
							comments.put(domainName, comment);
						}
					}
				}
				rs.close();
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
