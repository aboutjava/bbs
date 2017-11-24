package com.fun.bbs.mvc;

import java.security.Principal;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fun.bbs.utils.JsonResultBuilder;

@RequestMapping(value = "/bbs/javaBase")
@RestController
public class JavaBaseController {

	Map<String, Object> search(Principal principal) {
		JsonResultBuilder builder = JsonResultBuilder.create(true);
		
		return builder.toMap();
	}
}
