package com.fun.bbs.dao.mappers;

import com.fun.bbs.dao.entities.Role;
import com.fun.bbs.dao.entities.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 角色表映射 */
public interface RoleMapper {
    /** 根据角色表条件查询角色表件数 */
    int countByExample(RoleExample example);

    /** 删除满足条件的 角色表 */
    int deleteByExample(RoleExample example);

    /** 根据角色表主键删除角色表 */
    int deleteByPrimaryKey(Integer id);

    /** 插入 角色表 */
    int insert(Role record);

    /** 插入 角色表（仅插入有值的字段） */
    int insertSelective(Role record);

    /** 根据角色表条件查询角色表 */
    List<Role> selectByExample(RoleExample example);

    /** 根据角色表主键查询角色表 */
    Role selectByPrimaryKey(Integer id);

    /** updateByExampleSelective */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /** updateByExample */
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /** 根据角色表主键更新角色表（仅更新有值的字段） */
    int updateByPrimaryKeySelective(Role record);

    /** 根据角色表主键更新角色表 */
    int updateByPrimaryKey(Role record);
}