package com.fun.bbs.dao.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.fun.bbs.dao.entities.PostRecordDetail;
import com.fun.bbs.dao.entities.ReplyDetail;

public interface PostRecordExMapper {
	List<PostRecordDetail> queryList(Map<String, Object> cond);
	Integer queryCount(Map<String, Object> cond);
	PostRecordDetail selectPostRecordDetail(@Param("postId") Integer postId);
	List<ReplyDetail> selectPostReplies(@Param("postId") Integer postId);
}
