package com.fun.bbs.dao.mappers;

import com.fun.bbs.dao.entities.BanResource;
import com.fun.bbs.dao.entities.BanResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 禁言权限映射 */
public interface BanResourceMapper {
    /** 根据禁言权限条件查询禁言权限件数 */
    int countByExample(BanResourceExample example);

    /** 删除满足条件的 禁言权限 */
    int deleteByExample(BanResourceExample example);

    /** 根据禁言权限主键删除禁言权限 */
    int deleteByPrimaryKey(Integer id);

    /** 插入 禁言权限 */
    int insert(BanResource record);

    /** 插入 禁言权限（仅插入有值的字段） */
    int insertSelective(BanResource record);

    /** 根据禁言权限条件查询禁言权限 */
    List<BanResource> selectByExample(BanResourceExample example);

    /** 根据禁言权限主键查询禁言权限 */
    BanResource selectByPrimaryKey(Integer id);

    /** updateByExampleSelective */
    int updateByExampleSelective(@Param("record") BanResource record, @Param("example") BanResourceExample example);

    /** updateByExample */
    int updateByExample(@Param("record") BanResource record, @Param("example") BanResourceExample example);

    /** 根据禁言权限主键更新禁言权限（仅更新有值的字段） */
    int updateByPrimaryKeySelective(BanResource record);

    /** 根据禁言权限主键更新禁言权限 */
    int updateByPrimaryKey(BanResource record);
}