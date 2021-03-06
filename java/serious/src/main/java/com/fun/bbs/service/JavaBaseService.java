package com.fun.bbs.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fun.bbs.LoginUser;
import com.fun.bbs.dao.entities.PostRecord;
import com.fun.bbs.dao.entities.PostRecordDetail;
import com.fun.bbs.dao.entities.Reply;
import com.fun.bbs.dao.mappers.PostRecordExMapper;
import com.fun.bbs.dao.mappers.PostRecordMapper;
import com.fun.bbs.dao.mappers.ReplyMapper;
import com.fun.bbs.queryCond.PostRecordCond;
import com.fun.bbs.utils.QueryUtils;

@Transactional(readOnly = true)
@Service
public class JavaBaseService {
	
	@Autowired
	private PostRecordExMapper postRecordExMapper;
	
	@Autowired
	private PostRecordMapper postRecordMapper;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	/**
	 * 查询java基础版块的帖子
	 * @param cond
	 * @return
	 */
	public List<PostRecordDetail> findJavaBaseRecords(PostRecordCond cond) {
		Map<String, Object> condMap = new HashMap<>();
		condMap.put("title", QueryUtils.contain(cond.getTitle()));
		return postRecordExMapper.queryList(condMap);
	}
	
	/**
	 * 保存
	 * @param record
	 */
	@Transactional(readOnly = false)
	public void save(LoginUser loginUser, PostRecord record) {
		boolean isCreate = record.getId() == null;
		
		if (isCreate) {
			record.setAuthorId(loginUser.getUserId());
			record.setSectionId(1);
			record.setPostTime(new Date());
			postRecordMapper.insertSelective(record);
		} else {
			record.setEditTime(new Date());
			record.setEditUserId(loginUser.getUserId());
			postRecordMapper.updateByPrimaryKeySelective(record);
		}
	}
	
	/**
	 * 根据帖子id查询帖子
	 * @param postId
	 * @return
	 */
	public PostRecord findPostById(Integer postId) {
		return postRecordMapper.selectByPrimaryKey(postId);
	}
	
	/**
	 * 根据回复id查询回复详情
	 * @param replyId
	 * @return
	 */
	public Reply findReplyById(Integer replyId) {
		return replyMapper.selectByPrimaryKey(replyId);
	}
	
	/**
	 * 保存回复
	 * @param loginUser
	 * @param reply
	 * @return
	 */
	@Transactional(readOnly = false)
	public int saveReply(LoginUser loginUser, Reply reply) {
		boolean isCreate = reply.getId() == null;
		// 新增
		if (isCreate) {
			reply.setReplierId(loginUser.getUserId());
			reply.setReplyTime(new Date());
			return replyMapper.insertSelective(reply);
		} else {
			reply.setReplyUpdateTime(new Date());
			return replyMapper.updateByPrimaryKeySelective(reply);
		}
	}
}
