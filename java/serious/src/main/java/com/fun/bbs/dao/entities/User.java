package com.fun.bbs.dao.entities;

import java.io.Serializable;
import java.util.Date;

/** 用户信息表 */
@SuppressWarnings("serial")
public class User implements Serializable {
    /** id */
    private Integer id;

    /** 用户名 */
    private String userCode;

    /** 昵称 */
    private String userName;

    /** 密码 */
    private String password;

    /** 电话 */
    private String telNo;

    /** 邮箱 */
    private String email;

    /** 是否已删除 */
    private Boolean deleted;

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

    /** 取得“用户名” */
    public String getUserCode() {
        return userCode;
    }

    /** 设置“用户名” */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /** 取得“昵称” */
    public String getUserName() {
        return userName;
    }

    /** 设置“昵称” */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /** 取得“密码” */
    public String getPassword() {
        return password;
    }

    /** 设置“密码” */
    public void setPassword(String password) {
        this.password = password;
    }

    /** 取得“电话” */
    public String getTelNo() {
        return telNo;
    }

    /** 设置“电话” */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    /** 取得“邮箱” */
    public String getEmail() {
        return email;
    }

    /** 设置“邮箱” */
    public void setEmail(String email) {
        this.email = email;
    }

    /** 取得“是否已删除” */
    public Boolean getDeleted() {
        return deleted;
    }

    /** 设置“是否已删除” */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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