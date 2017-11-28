package com.fun.bbs.dao.entities;

import java.io.Serializable;

public class ReplyDetail extends Reply implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 回复者 */
	private String replier;

	public String getReplier() {
		return replier;
	}

	public void setReplier(String replier) {
		this.replier = replier;
	}

}
