package com.fun.bbs.dao.entities;

import java.io.Serializable;
import java.util.Date;

/** 帖子回复表 */
@SuppressWarnings("serial")
public class Reply implements Serializable {
    /** id */
    private Integer id;

    /** 帖子id */
    private Integer postId;

    /** 回复者id */
    private Integer replierId;

    /** 回复时间 */
    private Date replyTime;

    /** 回复修改时间 */
    private Date replyUpdateTime;

    /** 创建时刻 */
    private Date createdAt;

    /** 更新时刻 */
    private Date updatedAt;

    /** 回复内容 */
    private String replyContent;

    /** 取得“id” */
    public Integer getId() {
        return id;
    }

    /** 设置“id” */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 取得“帖子id” */
    public Integer getPostId() {
        return postId;
    }

    /** 设置“帖子id” */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    /** 取得“回复者id” */
    public Integer getReplierId() {
        return replierId;
    }

    /** 设置“回复者id” */
    public void setReplierId(Integer replierId) {
        this.replierId = replierId;
    }

    /** 取得“回复时间” */
    public Date getReplyTime() {
        return replyTime;
    }

    /** 设置“回复时间” */
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    /** 取得“回复修改时间” */
    public Date getReplyUpdateTime() {
        return replyUpdateTime;
    }

    /** 设置“回复修改时间” */
    public void setReplyUpdateTime(Date replyUpdateTime) {
        this.replyUpdateTime = replyUpdateTime;
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

    /** 取得“回复内容” */
    public String getReplyContent() {
        return replyContent;
    }

    /** 设置“回复内容” */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }
}