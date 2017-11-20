package com.fun.bbs.dao.entities;

import java.io.Serializable;
import java.util.Date;

/** 发帖记录表 */
@SuppressWarnings("serial")
public class PostRecord implements Serializable {
    /** id */
    private Integer id;

    /** 发帖者 */
    private Integer authorId;

    /** 帖子标题 */
    private String title;

    /** 浏览数 */
    private Integer visitNum;

    /** 回复数 */
    private Integer replyNum;

    /** 版块 */
    private Integer sectionId;

    /** 创建时刻 */
    private Date createdAt;

    /** 更新时刻 */
    private Date updatedAt;

    /** 帖子内容 */
    private String content;

    /** 取得“id” */
    public Integer getId() {
        return id;
    }

    /** 设置“id” */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 取得“发帖者” */
    public Integer getAuthorId() {
        return authorId;
    }

    /** 设置“发帖者” */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /** 取得“帖子标题” */
    public String getTitle() {
        return title;
    }

    /** 设置“帖子标题” */
    public void setTitle(String title) {
        this.title = title;
    }

    /** 取得“浏览数” */
    public Integer getVisitNum() {
        return visitNum;
    }

    /** 设置“浏览数” */
    public void setVisitNum(Integer visitNum) {
        this.visitNum = visitNum;
    }

    /** 取得“回复数” */
    public Integer getReplyNum() {
        return replyNum;
    }

    /** 设置“回复数” */
    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    /** 取得“版块” */
    public Integer getSectionId() {
        return sectionId;
    }

    /** 设置“版块” */
    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    /** 取得“创建时刻” */
    public Date getCreatedAt() {
        return createdAt;
    }

    /** 设置“创建时刻” */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /** 取得“更新时刻” */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /** 设置“更新时刻” */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /** 取得“帖子内容” */
    public String getContent() {
        return content;
    }

    /** 设置“帖子内容” */
    public void setContent(String content) {
        this.content = content;
    }
}