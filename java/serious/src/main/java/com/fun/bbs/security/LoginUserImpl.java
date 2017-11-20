package com.fun.bbs.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.User;

import com.fun.bbs.LoginUser;
import com.fun.bbs.dao.entities.Role;

public class LoginUserImpl extends User implements LoginUser {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	/**
	 * 昵称
	 */
	private String displayName;
	
	/**
	 * 用户id
	 */
	private final int userId;
	
	/**
	 * 角色名
	 */
	private final List<String> roleName;
	
	public LoginUserImpl(com.fun.bbs.dao.entities.User user, List<Role> roleList, Collection<GrantedAuthority> grantedAuthorities) {
		super(user.getUserCode(), user.getPassword(), true, true, true, true, grantedAuthorities);
		this.displayName = user.getUserName();
		this.userId = user.getId();
		this.roleName = roleList.stream().map(x -> x.getRoleName()).collect(Collectors.toList());
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public List<String> getRoleName() {
		return roleName;
	}

	@Override
	public int getUserId() {
		return userId;
	}

}
