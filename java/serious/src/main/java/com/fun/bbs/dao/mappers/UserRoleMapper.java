package com.fun.bbs.dao.mappers;

import com.fun.bbs.dao.entities.UserRole;
import com.fun.bbs.dao.entities.UserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 用户角色表映射 */
public interface UserRoleMapper {
    /** 根据用户角色表条件查询用户角色表件数 */
    int countByExample(UserRoleExample example);

    /** 删除满足条件的 用户角色表 */
    int deleteByExample(UserRoleExample example);

    /** 根据用户角色表主键删除用户角色表 */
    int deleteByPrimaryKey(Integer id);

    /** 插入 用户角色表 */
    int insert(UserRole record);

    /** 插入 用户角色表（仅插入有值的字段） */
    int insertSelective(UserRole record);

    /** 根据用户角色表条件查询用户角色表 */
    List<UserRole> selectByExample(UserRoleExample example);

    /** 根据用户角色表主键查询用户角色表 */
    UserRole selectByPrimaryKey(Integer id);

    /** updateByExampleSelective */
    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /** updateByExample */
    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /** 根据用户角色表主键更新用户角色表（仅更新有值的字段） */
    int updateByPrimaryKeySelective(UserRole record);

    /** 根据用户角色表主键更新用户角色表 */
    int updateByPrimaryKey(UserRole record);
}