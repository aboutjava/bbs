package com.fun.bbs.dao.mappers;

import java.util.List;
import java.util.Map;

import com.fun.bbs.dao.entities.PostRecordDetail;

public interface PostRecordExMapper {
	List<PostRecordDetail> queryList(Map<String, Object> cond);
	Integer queryCount(Map<String, Object> cond);
}
