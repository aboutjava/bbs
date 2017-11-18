package ssi.framework.mybatisGenerator;

import org.mybatis.generator.api.IntrospectedColumn;

public class MyIntrospectedColumn extends IntrospectedColumn {
	public void setJavaProperty(String javaProperty) {
		if (javaProperty.equals(actualColumnName)) {
			this.javaProperty = formatJavaProperty(javaProperty);
		} else {
			this.javaProperty = javaProperty;
		}
    }
	
	protected String formatJavaProperty(String javaProperty) {
		//全部大写改为小写
		if (javaProperty.toUpperCase().equals(javaProperty)) {
			javaProperty = javaProperty.toLowerCase();
		}
		
		//下划线分隔单词变化
		if (javaProperty.indexOf('_') > 0) {
			StringBuilder sb = new StringBuilder();
			boolean prevCharIsUnderline = false;;
			for (int i = 0; i < javaProperty.length(); i++) {
				char c = javaProperty.charAt(i);
				if (c == '_') {
					if (sb.length() == 0) {
						sb.append( c);
					} else {
						prevCharIsUnderline = true;
					}
				} else if (prevCharIsUnderline) {
					sb.append(Character.toUpperCase( c));
					prevCharIsUnderline = false;
				} else {
					sb.append( c);
				}
			}
			javaProperty = sb.toString();
		}		
		return javaProperty;
	}
}
