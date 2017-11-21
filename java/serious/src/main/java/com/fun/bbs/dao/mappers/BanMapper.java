package com.fun.bbs.dao.mappers;

import com.fun.bbs.dao.entities.Ban;
import com.fun.bbs.dao.entities.BanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 禁言角色映射 */
public interface BanMapper {
    /** 根据禁言角色条件查询禁言角色件数 */
    int countByExample(BanExample example);

    /** 删除满足条件的 禁言角色 */
    int deleteByExample(BanExample example);

    /** 根据禁言角色主键删除禁言角色 */
    int deleteByPrimaryKey(Integer id);

    /** 插入 禁言角色 */
    int insert(Ban record);

    /** 插入 禁言角色（仅插入有值的字段） */
    int insertSelective(Ban record);

    /** 根据禁言角色条件查询禁言角色 */
    List<Ban> selectByExample(BanExample example);

    /** 根据禁言角色主键查询禁言角色 */
    Ban selectByPrimaryKey(Integer id);

    /** updateByExampleSelective */
    int updateByExampleSelective(@Param("record") Ban record, @Param("example") BanExample example);

    /** updateByExample */
    int updateByExample(@Param("record") Ban record, @Param("example") BanExample example);

    /** 根据禁言角色主键更新禁言角色（仅更新有值的字段） */
    int updateByPrimaryKeySelective(Ban record);

    /** 根据禁言角色主键更新禁言角色 */
    int updateByPrimaryKey(Ban record);
}