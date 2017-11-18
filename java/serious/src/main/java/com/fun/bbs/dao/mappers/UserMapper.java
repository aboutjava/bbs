package com.fun.bbs.dao.mappers;

import com.fun.bbs.dao.entities.User;
import com.fun.bbs.dao.entities.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 用户信息表映射 */
public interface UserMapper {
    /** 根据用户信息表条件查询用户信息表件数 */
    int countByExample(UserExample example);

    /** 删除满足条件的 用户信息表 */
    int deleteByExample(UserExample example);

    /** 根据用户信息表主键删除用户信息表 */
    int deleteByPrimaryKey(Integer id);

    /** 插入 用户信息表 */
    int insert(User record);

    /** 插入 用户信息表（仅插入有值的字段） */
    int insertSelective(User record);

    /** 根据用户信息表条件查询用户信息表 */
    List<User> selectByExample(UserExample example);

    /** 根据用户信息表主键查询用户信息表 */
    User selectByPrimaryKey(Integer id);

    /** updateByExampleSelective */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /** updateByExample */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /** 根据用户信息表主键更新用户信息表（仅更新有值的字段） */
    int updateByPrimaryKeySelective(User record);

    /** 根据用户信息表主键更新用户信息表 */
    int updateByPrimaryKey(User record);
}