package com.threeMMM.commom.utils;

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Java对象和JSON字符串相互转化工具类
 * 
 * @author xiaoyong
 */
public final class JsonUtil {

	private JsonUtil() {
	}

	/**
	 * 对象转换成json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

	/**
	 * json字符串转成对象
	 * 
	 * @param str
	 * @param type
	 * @return
	 */
	public static <T> T fromJson(String str, Type type) {
		Gson gson = new Gson();
		return gson.fromJson(str, type);
	}

	/**
	 * json字符串转成对象
	 * 
	 * @param str
	 * @param type
	 * @return
	 */
	public static <T> T fromJson(String str, Class<T> type) {
		Gson gson = new Gson();
		return gson.fromJson(str, type);
	}
	/**
	 * json 转 map
	 * @param str
	 * @return
	 */
	public static Map<String, String> toMap(String str) {
		Gson gson = new Gson();
		Map<String, String> gsonMap = gson.fromJson(str, new TypeToken<Map<String, String>>() {
		}.getType());
		return gsonMap;
	}
}
