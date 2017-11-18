package com.fun.bbs.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fun.bbs.dao.entities.User;
import com.fun.bbs.service.UserService;

@ActiveProfiles("development")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class UserTest {
	@Autowired
	private UserService service;
	
	@Test
	public void test1() {
		User user = service.findUserById(1);
		System.out.println(user.getUserName());
	}

}
