package com.fun.bbs.mvc;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fun.bbs.dao.entities.PostRecordDetail;
import com.fun.bbs.dao.entities.ReplyDetail;
import com.fun.bbs.service.PostDetailService;
import com.fun.bbs.utils.JsonResultBuilder;

@RequestMapping(value = "/bbs/postDetail")
@RestController
public class PostDetailController {
	
	@Autowired
	private PostDetailService postDetailService;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	Map<String, Object> search(Principal principal, Integer postId) {
		JsonResultBuilder builder = JsonResultBuilder.create(true);
		PostRecordDetail post = postDetailService.findPostDetailById(postId);
		builder.set("post", post);
		List<ReplyDetail> replies = postDetailService.findPostRepliesByPostId(postId);
		if (replies.size() > 0) {
			builder.set("replies", replies);
		}
		return builder.toMap();
	}
}
