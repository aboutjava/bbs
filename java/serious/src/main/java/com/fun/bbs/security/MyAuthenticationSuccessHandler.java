package com.fun.bbs.security;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.annotation.Transactional;

import com.fun.bbs.LoginUser;
import com.fun.bbs.utils.AjaxUtils;
import com.fun.bbs.utils.JsonResultBuilder;

@Transactional(readOnly = false)
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		JsonResultBuilder builder = JsonResultBuilder.create(true);
		LoginUser loginUser = SecurityUtils.extractLoginUser(authentication);
		List<String> authorities = authentication.getAuthorities().stream().map(x -> x.getAuthority())
				.collect(Collectors.toList());
		builder.addMap("user").set("name", loginUser.getDisplayName()).set("roleName", loginUser.getRoleName())
				.set("userId", loginUser.getUserId()).set("authorities", authorities);

		AjaxUtils.outputJson(response, builder.toMap());
		clearAuthenticationAttributes(request);
	}

	protected final void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session == null) {
			return;
		}

		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

}
