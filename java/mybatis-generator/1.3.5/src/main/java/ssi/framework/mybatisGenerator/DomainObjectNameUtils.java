package ssi.framework.mybatisGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.jdbc.StringUtils;

public class DomainObjectNameUtils {
	private static Map<String, String> maps = new HashMap<String, String>();
	
	public static void registryDomainObjectName(String configXml) {
		Pattern p = Pattern.compile("<[^>]*>", Pattern.MULTILINE);
		Pattern tableNamePattern = Pattern.compile("tableName\\s*=\\s*\"([^\"]*)");
		Pattern domainObjectNamePattern = Pattern.compile("domainObjectName\\s*=\\s*\"([^\"]*)");
		Matcher matcher = p.matcher(configXml);
		while(matcher.find()) {
			String s = matcher.group();
			Matcher tableNameMatcher = tableNamePattern.matcher(s);
			if (tableNameMatcher.find()) {
				Matcher domainObjectNameMatcher = domainObjectNamePattern.matcher(s);
				if (domainObjectNameMatcher.find()) {
					maps.put(tableNameMatcher.group(1), domainObjectNameMatcher.group(1));
				} else {
					maps.put(tableNameMatcher.group(1), toClassNameFromTableName(tableNameMatcher.group(1)));
				}
			}
		}
	}
	
	public static Set<String> getTableNames() {
		return maps.keySet();
	}
	
	public static String getDomainObjectNameByTableName(String tableName) {
		return maps.get(tableName);
	}
	
	@SuppressWarnings("unchecked")
	public static String toClassNameFromTableName(String tableName) {
    	List<String> ss =(List<String>) StringUtils.split(tableName, "_", true);
    	StringBuffer sb = new StringBuffer();
    	for(String s : ss) {
    		sb.append(s.substring(0, 1).toUpperCase() + s.substring(1));
    	}
    	return sb.toString();
    }
}
