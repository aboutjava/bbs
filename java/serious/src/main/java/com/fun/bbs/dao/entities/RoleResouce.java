package com.fun.bbs.dao.entities;

import java.io.Serializable;
import java.util.Date;

/** 角色权限表 */
@SuppressWarnings("serial")
public class RoleResouce implements Serializable {
    /** id */
    private Integer id;

    /** 角色id */
    private Integer roleId;

    /** 权限id */
    private Integer resourceId;

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

    /** 取得“角色id” */
    public Integer getRoleId() {
        return roleId;
    }

    /** 设置“角色id” */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /** 取得“权限id” */
    public Integer getResourceId() {
        return resourceId;
    }

    /** 设置“权限id” */
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
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