package com.fun.bbs.dao.entities;

import java.io.Serializable;
import java.util.Date;

/** 版块 */
@SuppressWarnings("serial")
public class Section implements Serializable {
    /** id */
    private Integer id;

    /** 版块名称 */
    private String sectionName;

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

    /** 取得“版块名称” */
    public String getSectionName() {
        return sectionName;
    }

    /** 设置“版块名称” */
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
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