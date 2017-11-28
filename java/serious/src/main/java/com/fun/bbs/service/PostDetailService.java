package com.fun.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fun.bbs.dao.entities.PostRecordDetail;
import com.fun.bbs.dao.entities.ReplyDetail;
import com.fun.bbs.dao.mappers.PostRecordExMapper;

@Transactional(readOnly = true)
@Service
public class PostDetailService {
	
	@Autowired
	private PostRecordExMapper postRecordExMapper;
	
	/**
	 * 查询帖子详情
	 * @param PostId
	 * @return
	 */
	public PostRecordDetail findPostDetailById(Integer postId) {
		return postRecordExMapper.selectPostRecordDetail(postId);
	}
	
	/**
	 * 查询帖子的回复
	 * @param postId
	 * @return
	 */
	public List<ReplyDetail> findPostRepliesByPostId(Integer postId) {
		return postRecordExMapper.selectPostReplies(postId);
	}
}
