package com.qcjk.cms.util;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * @author lichunbo
 *
 */

public abstract class JsonUtil {

	private JsonUtil() {

	}

	private static final String SUCCESS_CODE = "200";
	private static final String ERROR_CODE = "400";

	public static String success() {
		Map<String, String> map = new HashMap<String, String>(2);
		map.put("code", SUCCESS_CODE);
		return JSONObject.fromObject(map).toString();
	}

	public static String success(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>(4);
		map.put("code", SUCCESS_CODE);
		map.put("data", obj);
		return JSONObject.fromObject(map).toString();
	}

	public static String error(String msg) {
		Map<String, String> map = new HashMap<String, String>(4);
		map.put("code", ERROR_CODE);
		map.put("msg", msg);
		return JSONObject.fromObject(map).toString();
	}

}
