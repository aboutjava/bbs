package com.fun.bbs.mvc;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fun.bbs.LoginUser;
import com.fun.bbs.dao.entities.PostRecord;
import com.fun.bbs.dao.entities.PostRecordDetail;
import com.fun.bbs.dao.entities.Reply;
import com.fun.bbs.queryCond.PostRecordCond;
import com.fun.bbs.security.SecurityUtils;
import com.fun.bbs.service.JavaBaseService;
import com.fun.bbs.utils.JsonResultBuilder;

@RequestMapping(value = "/bbs/javaBase")
@RestController
public class JavaBaseController {
	
	@Autowired
	private JavaBaseService javaBaseService;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	Map<String, Object> search(Principal principal, PostRecordCond cond) {
		JsonResultBuilder builder = JsonResultBuilder.create(true);
		List<PostRecordDetail> list = javaBaseService.findJavaBaseRecords(cond);
		builder.set("list", list);
		return builder.toMap();
	}
	
	/**
	 * 编辑初始化
	 * @param principal
	 * @param postId
	 * @return
	 */
	@RequestMapping(value = "/editInit", method = RequestMethod.POST)
	Map<String, Object> editInit(Principal principal, @RequestParam(required = false)Integer postId) {
		JsonResultBuilder builder = JsonResultBuilder.create(true);
		if (postId != null) {
			PostRecord postRecord = javaBaseService.findPostById(postId);
			builder.set("postRecord", postRecord);
		}
		return builder.toMap();
	}
	
	/**
	 * 帖子保存
	 * @param principal
	 * @param postRecord
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	Map<String, Object> save(Principal principal, PostRecord postRecord) {
		JsonResultBuilder builder = JsonResultBuilder.create(true);
		LoginUser loginUser = SecurityUtils.extractLoginUser(principal);
		javaBaseService.save(loginUser, postRecord);
		return builder.toMap();
	}
	
	/**
	 * 回复修改初始化
	 * @param principal
	 * @param replyId
	 * @return
	 */
	@RequestMapping(value = "/replyEditInit", method = RequestMethod.POST)
	Map<String, Object> replyEditInit(Principal principal, @RequestParam(required = false)Integer replyId) {
		JsonResultBuilder builder = JsonResultBuilder.create(true);
		Reply reply = javaBaseService.findReplyById(replyId);
		if (reply != null) {
			builder.set("reply", reply);
		}
		return builder.toMap();
	}
	
	@RequestMapping(value = "/replySave", method = RequestMethod.POST)
	Map<String, Object> replySave(Principal principal, Reply reply) {
		JsonResultBuilder builder = JsonResultBuilder.create(true);
		LoginUser loginUser = SecurityUtils.extractLoginUser(principal);
		
		return builder.toMap();
	}
}
