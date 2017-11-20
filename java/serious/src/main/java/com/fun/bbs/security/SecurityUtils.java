package com.fun.bbs.security;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fun.bbs.LoginUser;



public final class SecurityUtils {
	public static LoginUser getCurrentUser() {
		return extractLoginUser(SecurityContextHolder.getContext().getAuthentication());
	}

	public static LoginUser extractLoginUser(Authentication authentication) {
		Object principal = authentication == null ? null : authentication.getPrincipal();
		if (principal instanceof LoginUser) {
			return (LoginUser) principal;
		}
		return null;
	}
	
	public static LoginUser extractLoginUser(Principal principal) {
		if (principal instanceof Authentication) {
			return (LoginUser)((Authentication)principal).getPrincipal();
		}
		return null;
	}

	public static boolean hasAuthority(String authority) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth == null || !auth.isAuthenticated()) {
			return false;
		}
		LoginUser loginUser = extractLoginUser(auth);
		if (loginUser == null) {
			return false;
		}
		return auth.getAuthorities().stream().anyMatch(x -> x.getAuthority().equals(authority));
	}	
}
