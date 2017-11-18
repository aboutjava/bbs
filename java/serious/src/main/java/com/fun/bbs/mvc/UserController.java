package com.fun.bbs.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fun.bbs.dao.entities.User;
import com.fun.bbs.service.UserService;
import com.fun.bbs.utils.JsonResultBuilder;

@RestController
@RequestMapping(value = "bbs/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/getUserInfo", method = RequestMethod.POST)
	Map<String, Object> getUserInfo() {
		JsonResultBuilder builder = JsonResultBuilder.create(true);
		User user = userService.findUserById(1);
		builder.set("user", user);
		return builder.toMap();
	}
}
