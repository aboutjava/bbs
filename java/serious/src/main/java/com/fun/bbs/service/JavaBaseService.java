package com.fun.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fun.bbs.dao.entities.PostRecord;
import com.fun.bbs.queryCond.PostRecordCond;

@Transactional(readOnly = true)
@Service
public class JavaBaseService {

	public List<PostRecord> findJavaBaseRecords(PostRecordCond cond) {
		
		return null;
	}
}
