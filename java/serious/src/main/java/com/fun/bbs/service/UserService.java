package com.fun.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fun.bbs.dao.entities.User;
import com.fun.bbs.dao.mappers.UserMapper;

@Transactional(readOnly=true)
@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User findUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
}
