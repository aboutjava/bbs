package com.fun.bbs.dao.mappers;

import com.fun.bbs.dao.entities.Resource;
import com.fun.bbs.dao.entities.ResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 权限表映射 */
public interface ResourceMapper {
    /** 根据权限表条件查询权限表件数 */
    int countByExample(ResourceExample example);

    /** 删除满足条件的 权限表 */
    int deleteByExample(ResourceExample example);

    /** 根据权限表主键删除权限表 */
    int deleteByPrimaryKey(Integer id);

    /** 插入 权限表 */
    int insert(Resource record);

    /** 插入 权限表（仅插入有值的字段） */
    int insertSelective(Resource record);

    /** 根据权限表条件查询权限表 */
    List<Resource> selectByExample(ResourceExample example);

    /** 根据权限表主键查询权限表 */
    Resource selectByPrimaryKey(Integer id);

    /** updateByExampleSelective */
    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceExample example);

    /** updateByExample */
    int updateByExample(@Param("record") Resource record, @Param("example") ResourceExample example);

    /** 根据权限表主键更新权限表（仅更新有值的字段） */
    int updateByPrimaryKeySelective(Resource record);

    /** 根据权限表主键更新权限表 */
    int updateByPrimaryKey(Resource record);
}