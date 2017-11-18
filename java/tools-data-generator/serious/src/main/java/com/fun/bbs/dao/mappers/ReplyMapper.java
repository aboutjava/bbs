package com.fun.bbs.dao.mappers;

import com.fun.bbs.dao.entities.Reply;
import com.fun.bbs.dao.entities.ReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 帖子回复表映射 */
public interface ReplyMapper {
    /** 根据帖子回复表条件查询帖子回复表件数 */
    int countByExample(ReplyExample example);

    /** 删除满足条件的 帖子回复表 */
    int deleteByExample(ReplyExample example);

    /** 根据帖子回复表主键删除帖子回复表 */
    int deleteByPrimaryKey(Integer id);

    /** 插入 帖子回复表 */
    int insert(Reply record);

    /** 插入 帖子回复表（仅插入有值的字段） */
    int insertSelective(Reply record);

    /** 根据帖子回复表条件（WithBLOBs）查询帖子回复表 */
    List<Reply> selectByExampleWithBLOBs(ReplyExample example);

    /** 根据帖子回复表条件查询帖子回复表 */
    List<Reply> selectByExample(ReplyExample example);

    /** 根据帖子回复表主键查询帖子回复表 */
    Reply selectByPrimaryKey(Integer id);

    /** updateByExampleSelective */
    int updateByExampleSelective(@Param("record") Reply record, @Param("example") ReplyExample example);

    /** updateByExampleWithBLOBs */
    int updateByExampleWithBLOBs(@Param("record") Reply record, @Param("example") ReplyExample example);

    /** updateByExample */
    int updateByExample(@Param("record") Reply record, @Param("example") ReplyExample example);

    /** 根据帖子回复表主键更新帖子回复表（仅更新有值的字段） */
    int updateByPrimaryKeySelective(Reply record);

    /** 根据帖子回复表主键（WithBLOBs）更新帖子回复表 */
    int updateByPrimaryKeyWithBLOBs(Reply record);

    /** 根据帖子回复表主键更新帖子回复表 */
    int updateByPrimaryKey(Reply record);
}