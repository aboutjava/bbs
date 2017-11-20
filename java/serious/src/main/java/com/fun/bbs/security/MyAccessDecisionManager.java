package com.fun.bbs.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.expression.WebExpressionVoter;

public class MyAccessDecisionManager extends AffirmativeBased {

	public MyAccessDecisionManager() {
		super(Arrays.asList(new WebExpressionVoter()));
	}
	
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException {
		super.decide(authentication, object, configAttributes);
	}

}
