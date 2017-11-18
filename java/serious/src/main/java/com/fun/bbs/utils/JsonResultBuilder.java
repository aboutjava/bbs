package com.fun.bbs.utils;

import java.util.HashMap;
import java.util.Map;

public class JsonResultBuilder {
	private Map<String, Object> result = new HashMap<>();
	
	public static JsonResultBuilder create(boolean success) {
		JsonResultBuilder builder = new JsonResultBuilder();
		return builder.set("success", success);
	}
	
	public JsonResultBuilder set(String key, Object val) {
		result.put(key, val);
		return this;
	}
	
	public JsonResultBuilder setMsg(String message) {
		return this.set("message", message);
	}
	
	public Map<String, Object> toMap() {
		return result;
	}
}
