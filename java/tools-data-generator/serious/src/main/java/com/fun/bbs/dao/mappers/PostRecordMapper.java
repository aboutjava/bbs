package com.fun.bbs.dao.mappers;

import com.fun.bbs.dao.entities.PostRecord;
import com.fun.bbs.dao.entities.PostRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 发帖记录表映射 */
public interface PostRecordMapper {
    /** 根据发帖记录表条件查询发帖记录表件数 */
    int countByExample(PostRecordExample example);

    /** 删除满足条件的 发帖记录表 */
    int deleteByExample(PostRecordExample example);

    /** 根据发帖记录表主键删除发帖记录表 */
    int deleteByPrimaryKey(Integer id);

    /** 插入 发帖记录表 */
    int insert(PostRecord record);

    /** 插入 发帖记录表（仅插入有值的字段） */
    int insertSelective(PostRecord record);

    /** 根据发帖记录表条件（WithBLOBs）查询发帖记录表 */
    List<PostRecord> selectByExampleWithBLOBs(PostRecordExample example);

    /** 根据发帖记录表条件查询发帖记录表 */
    List<PostRecord> selectByExample(PostRecordExample example);

    /** 根据发帖记录表主键查询发帖记录表 */
    PostRecord selectByPrimaryKey(Integer id);

    /** updateByExampleSelective */
    int updateByExampleSelective(@Param("record") PostRecord record, @Param("example") PostRecordExample example);

    /** updateByExampleWithBLOBs */
    int updateByExampleWithBLOBs(@Param("record") PostRecord record, @Param("example") PostRecordExample example);

    /** updateByExample */
    int updateByExample(@Param("record") PostRecord record, @Param("example") PostRecordExample example);

    /** 根据发帖记录表主键更新发帖记录表（仅更新有值的字段） */
    int updateByPrimaryKeySelective(PostRecord record);

    /** 根据发帖记录表主键（WithBLOBs）更新发帖记录表 */
    int updateByPrimaryKeyWithBLOBs(PostRecord record);

    /** 根据发帖记录表主键更新发帖记录表 */
    int updateByPrimaryKey(PostRecord record);
}