package com.fun.bbs.dao.entities;

import java.io.Serializable;
import java.util.Date;

public class PostRecordDetail extends PostRecord implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 发帖作者 */
	private String author;
	
	/** 回复者 */
	private String replier;
	
	/** 回复时间 */
	private Date replyTime;
	
	/** 版块名称 */
	private String section;
	
	/** 修改者  */
	private String editor;


	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getReplier() {
		return replier;
	}

	public void setReplier(String replier) {
		this.replier = replier;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
