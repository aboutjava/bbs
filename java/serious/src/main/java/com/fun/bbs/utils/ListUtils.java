package com.fun.bbs.utils;

import java.util.List;

public class ListUtils {
	public static <T> T firstOrNull(List<T> list) {
		if (list == null || list.isEmpty()) return null;
		return list.get(0);
	}
}
