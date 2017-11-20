package com.fun.bbs.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.fun.bbs.dao.entities.Role;
import com.fun.bbs.dao.entities.RoleExample;
import com.fun.bbs.dao.entities.RoleResouce;
import com.fun.bbs.dao.entities.User;
import com.fun.bbs.dao.entities.UserRole;
import com.fun.bbs.dao.mappers.RoleMapper;
import com.fun.bbs.service.UserService;

@Transactional(readOnly = true)
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findUserByCd(username);
		if (user == null) {
			throw new UsernameNotFoundException("用戶" + username + "不存在");
		}
		List<UserRole> userRoleList = userService.findUserRoleByid(user.getId());
		List<Integer> roleIds = userRoleList.stream().map(x -> x.getRoleId()).collect(Collectors.toList());
		
		RoleExample example = new RoleExample();
		example.createCriteria().andIdIn(roleIds);
		List<Role> roleList = roleMapper.selectByExample(example);
		
		// 授权权限
		Collection<String> authorities = userService.getUserAuthorityById(user.getId());
		Collection<GrantedAuthority> grantedAuthorities = authorities.stream().map(x -> new SimpleGrantedAuthority(x)).collect(Collectors.toSet());
		return new LoginUserImpl(user, roleList, grantedAuthorities);
	}

}
