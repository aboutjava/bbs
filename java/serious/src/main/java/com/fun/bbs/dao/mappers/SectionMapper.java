package com.fun.bbs.dao.mappers;

import com.fun.bbs.dao.entities.Section;
import com.fun.bbs.dao.entities.SectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 版块映射 */
public interface SectionMapper {
    /** 根据版块条件查询版块件数 */
    int countByExample(SectionExample example);

    /** 删除满足条件的 版块 */
    int deleteByExample(SectionExample example);

    /** 根据版块主键删除版块 */
    int deleteByPrimaryKey(Integer id);

    /** 插入 版块 */
    int insert(Section record);

    /** 插入 版块（仅插入有值的字段） */
    int insertSelective(Section record);

    /** 根据版块条件查询版块 */
    List<Section> selectByExample(SectionExample example);

    /** 根据版块主键查询版块 */
    Section selectByPrimaryKey(Integer id);

    /** updateByExampleSelective */
    int updateByExampleSelective(@Param("record") Section record, @Param("example") SectionExample example);

    /** updateByExample */
    int updateByExample(@Param("record") Section record, @Param("example") SectionExample example);

    /** 根据版块主键更新版块（仅更新有值的字段） */
    int updateByPrimaryKeySelective(Section record);

    /** 根据版块主键更新版块 */
    int updateByPrimaryKey(Section record);
}