package com.fun.bbs;

import java.util.List;

public interface LoginUser {
	/**
	 * 获取用户昵称
	 * @return
	 */
	String getDisplayName();
	
	/**
	 * 获取角色名称
	 * @return
	 */
	List<String> getRoleName();
	
	/**
	 * 获取用户id
	 * @return
	 */
	int getUserId();
	
	/**
	 * 获取用户名
	 * @return
	 */
	String getUsername();
	
	
}
