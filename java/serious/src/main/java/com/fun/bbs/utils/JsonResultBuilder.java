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
	
	@SuppressWarnings("unchecked")
	public JsonResultMap addMap(String name) {
		if (!result.containsKey(name)) {
			result.put(name, new HashMap<String, Object>());
		}
		return new JsonResultMap((Map<String, Object>) result.get(name), this);
	}
	
	public static class JsonResultMap {
		private final Map<String, Object> results;
		private final JsonResultBuilder builder;
		public JsonResultMap(Map<String, Object> map, JsonResultBuilder builder) {
			this.results = map;
			this.builder = builder;
		}
		
		public JsonResultMap set(String name, Object value) {
			results.put(name, value);
			return this;
		}
		
		public JsonResultBuilder end() {
			return builder;
		}
	}
}
