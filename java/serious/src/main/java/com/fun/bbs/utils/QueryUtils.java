package com.fun.bbs.utils;

import org.springframework.util.StringUtils;

public class QueryUtils {
	
	/**
	 * 包含
	 * @param cond
	 * @return
	 */
	public static String contain(String cond) {
		if (StringUtils.isEmpty(cond)) return null;
		return "%" + cond + "%";
	}
	
	/**
	 * 开头匹配
	 * @param cond
	 * @return
	 */
	public static String startWith(String cond) {
		if (StringUtils.isEmpty(cond)) return null;
		return "%" + cond;
	}
	
	/**
	 * 结尾匹配
	 * @param cond
	 * @return
	 */
	public static String endWith(String cond) {
		if (StringUtils.isEmpty(cond)) return null;
		return "%" + cond;
	}
}
