package com.fun.bbs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fun.bbs.dao.entities.Resource;
import com.fun.bbs.dao.entities.ResourceExample;
import com.fun.bbs.dao.entities.RoleResouce;
import com.fun.bbs.dao.entities.RoleResouceExample;
import com.fun.bbs.dao.entities.User;
import com.fun.bbs.dao.entities.UserExample;
import com.fun.bbs.dao.entities.UserRole;
import com.fun.bbs.dao.entities.UserRoleExample;
import com.fun.bbs.dao.mappers.ResourceMapper;
import com.fun.bbs.dao.mappers.RoleResouceMapper;
import com.fun.bbs.dao.mappers.UserMapper;
import com.fun.bbs.dao.mappers.UserRoleMapper;
import com.fun.bbs.utils.ListUtils;

@Transactional(readOnly=true)
@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RoleResouceMapper roleResouceMapper;
	
	@Autowired
	private  ResourceMapper resourceMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	/**
	 * 根据id查詢用戶
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 根据用戶名查用戶
	 * @param cd
	 * @return
	 */
	public User findUserByCd(String cd) {
		UserExample example = new UserExample();
		example.createCriteria().andUserCodeEqualTo(cd);
		return ListUtils.firstOrNull(userMapper.selectByExample(example));
	}
	
	/**
	 * 根据用户id查询用户角色
	 * @param id
	 * @return
	 */
	public List<UserRole> findUserRoleByid(Integer id) {
		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria().andUserIdEqualTo(id);
		return userRoleMapper.selectByExample(userRoleExample);
	}
	
	/**
	 * 根据用戶id查询用户权限
	 * @param id 用户id
	 * @return
	 */
	public List<String> getUserAuthorityById(Integer id) {
		List<UserRole> userRoleList = findUserRoleByid(id);
		List<Integer> roleIds = userRoleList.stream().map(x -> x.getRoleId()).collect(Collectors.toList());
		
		RoleResouceExample example = new RoleResouceExample();
		example.createCriteria().andRoleIdIn(roleIds);
		List<RoleResouce> roleResourceList = roleResouceMapper.selectByExample(example);
		List<Integer> resourceIds = roleResourceList.stream().map(x -> x.getResourceId()).collect(Collectors.toList());
		
		ResourceExample resourceExample = new ResourceExample();
		resourceExample.createCriteria().andIdIn(resourceIds);
		List<Resource> resourceList = resourceMapper.selectByExample(resourceExample);
		return resourceList.stream().map(x -> x.getResourceControl()).collect(Collectors.toList());
	}
}
