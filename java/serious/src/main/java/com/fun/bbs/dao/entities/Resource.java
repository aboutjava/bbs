package com.fun.bbs.dao.entities;

import java.io.Serializable;
import java.util.Date;

/** 权限表 */
@SuppressWarnings("serial")
public class Resource implements Serializable {
    /** id */
    private Integer id;

    /** 权限编号 */
    private String resourceCode;

    /** 权限名 */
    private String resourceName;

    /** 权限控制名 */
    private String resourceControl;

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

    /** 取得“权限编号” */
    public String getResourceCode() {
        return resourceCode;
    }

    /** 设置“权限编号” */
    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    /** 取得“权限名” */
    public String getResourceName() {
        return resourceName;
    }

    /** 设置“权限名” */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /** 取得“权限控制名” */
    public String getResourceControl() {
        return resourceControl;
    }

    /** 设置“权限控制名” */
    public void setResourceControl(String resourceControl) {
        this.resourceControl = resourceControl;
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