package com.fun.bbs.dao.mappers;

import com.fun.bbs.dao.entities.UserBan;
import com.fun.bbs.dao.entities.UserBanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 用户禁言表映射 */
public interface UserBanMapper {
    /** 根据用户禁言表条件查询用户禁言表件数 */
    int countByExample(UserBanExample example);

    /** 删除满足条件的 用户禁言表 */
    int deleteByExample(UserBanExample example);

    /** 根据用户禁言表主键删除用户禁言表 */
    int deleteByPrimaryKey(Integer id);

    /** 插入 用户禁言表 */
    int insert(UserBan record);

    /** 插入 用户禁言表（仅插入有值的字段） */
    int insertSelective(UserBan record);

    /** 根据用户禁言表条件查询用户禁言表 */
    List<UserBan> selectByExample(UserBanExample example);

    /** 根据用户禁言表主键查询用户禁言表 */
    UserBan selectByPrimaryKey(Integer id);

    /** updateByExampleSelective */
    int updateByExampleSelective(@Param("record") UserBan record, @Param("example") UserBanExample example);

    /** updateByExample */
    int updateByExample(@Param("record") UserBan record, @Param("example") UserBanExample example);

    /** 根据用户禁言表主键更新用户禁言表（仅更新有值的字段） */
    int updateByPrimaryKeySelective(UserBan record);

    /** 根据用户禁言表主键更新用户禁言表 */
    int updateByPrimaryKey(UserBan record);
}