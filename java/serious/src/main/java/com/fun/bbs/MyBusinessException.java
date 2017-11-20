package com.fun.bbs;

public class MyBusinessException extends RuntimeException {
	private static final long serialVersionUID = -8789727564614827888L;

	public MyBusinessException(String message) {
		super(message);
	}
}
