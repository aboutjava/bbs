package com.fun.bbs.mvc;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fun.bbs.LoginUser;
import com.fun.bbs.security.SecurityUtils;
import com.fun.bbs.utils.JsonResultBuilder;

@RequestMapping(value = "/bbs")
@RestController
public class MyController {

	@RequestMapping(value = "/userMenu")
	public Map<String, Object> userMenu(Principal principal) {
		JsonResultBuilder builder = JsonResultBuilder.create(true);
		LoginUser loginUser = SecurityUtils.extractLoginUser(principal);
		List<String> authorities = ((Authentication) principal).getAuthorities().stream().map(x -> x.getAuthority())
				.collect(Collectors.toList());
		builder.addMap("user").set("name", loginUser.getDisplayName()).set("roleName", loginUser.getRoleName())
				.set("userId", loginUser.getUserId()).set("authorities", authorities);
		return builder.toMap();
	}
}
