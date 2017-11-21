package com.fun.bbs.dao.entities;

import java.io.Serializable;
import java.util.Date;

/** 禁言角色 */
@SuppressWarnings("serial")
public class Ban implements Serializable {
    /** id */
    private Integer id;

    /** 禁言角色编号 */
    private String banCode;

    /** 禁言角色名称 */
    private String banName;

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

    /** 取得“禁言角色编号” */
    public String getBanCode() {
        return banCode;
    }

    /** 设置“禁言角色编号” */
    public void setBanCode(String banCode) {
        this.banCode = banCode;
    }

    /** 取得“禁言角色名称” */
    public String getBanName() {
        return banName;
    }

    /** 设置“禁言角色名称” */
    public void setBanName(String banName) {
        this.banName = banName;
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