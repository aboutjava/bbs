package com.fun.bbs.dao.mappers;

import com.fun.bbs.dao.entities.RoleResouce;
import com.fun.bbs.dao.entities.RoleResouceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 角色权限表映射 */
public interface RoleResouceMapper {
    /** 根据角色权限表条件查询角色权限表件数 */
    int countByExample(RoleResouceExample example);

    /** 删除满足条件的 角色权限表 */
    int deleteByExample(RoleResouceExample example);

    /** 根据角色权限表主键删除角色权限表 */
    int deleteByPrimaryKey(Integer id);

    /** 插入 角色权限表 */
    int insert(RoleResouce record);

    /** 插入 角色权限表（仅插入有值的字段） */
    int insertSelective(RoleResouce record);

    /** 根据角色权限表条件查询角色权限表 */
    List<RoleResouce> selectByExample(RoleResouceExample example);

    /** 根据角色权限表主键查询角色权限表 */
    RoleResouce selectByPrimaryKey(Integer id);

    /** updateByExampleSelective */
    int updateByExampleSelective(@Param("record") RoleResouce record, @Param("example") RoleResouceExample example);

    /** updateByExample */
    int updateByExample(@Param("record") RoleResouce record, @Param("example") RoleResouceExample example);

    /** 根据角色权限表主键更新角色权限表（仅更新有值的字段） */
    int updateByPrimaryKeySelective(RoleResouce record);

    /** 根据角色权限表主键更新角色权限表 */
    int updateByPrimaryKey(RoleResouce record);
}