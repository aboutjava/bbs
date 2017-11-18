package com.fun.bbs.utils;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public final class GsonUtils {
	private GsonUtils() {}
	
	private static Gson defaultGson;
	
	private static Type TypeStringObjectMap = new TypeToken<Map<String, Object>>() {}.getType();
	private static Type TypeStringObjectMapList = new TypeToken<List<Map<String, Object>>>() {}.getType();
	
	static {
		defaultGson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	}
	
	public static Gson getGson() {
		return defaultGson;
	}
	
	public static Map<String, Object> fromJson(String json) {
		return defaultGson.fromJson(json, TypeStringObjectMap);
	}
	
	public static List<Map<String, Object>> fromJsonToList(String json) {
		return defaultGson.fromJson(json, TypeStringObjectMapList);
	}
}
