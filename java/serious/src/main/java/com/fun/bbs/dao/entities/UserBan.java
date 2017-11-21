package com.fun.bbs.dao.entities;

import java.io.Serializable;
import java.util.Date;

/** 用户禁言表 */
@SuppressWarnings("serial")
public class UserBan implements Serializable {
    /** id */
    private Integer id;

    /** 用户id */
    private Integer userId;

    /** 禁言角色id */
    private Integer banId;

    /** 禁言天数：
7
30
99(永久)
 */
    private Byte banDay;

    /** 创建时刻 */
    private Date createdAt;

    /** 更新时刻 */
    private Date updatedAt;

    /** 取得“id” */
    public Integer getId() {
        return id;
    }

    /** 设置“id” */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 取得“用户id” */
    public Integer getUserId() {
        return userId;
    }

    /** 设置“用户id” */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /** 取得“禁言角色id” */
    public Integer getBanId() {
        return banId;
    }

    /** 设置“禁言角色id” */
    public void setBanId(Integer banId) {
        this.banId = banId;
    }

    /** 取得“禁言天数：
7
30
99(永久)
” */
    public Byte getBanDay() {
        return banDay;
    }

    /** 设置“禁言天数：
7
30
99(永久)
” */
    public void setBanDay(Byte banDay) {
        this.banDay = banDay;
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
}