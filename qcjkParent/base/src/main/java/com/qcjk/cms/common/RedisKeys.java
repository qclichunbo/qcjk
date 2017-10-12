package com.qcjk.cms.common;

public interface RedisKeys {

	String MODEL_KEY = "model:%s:%s";
	String MODEL_SET_KEY = "modelSet:%s";
	String PROPERTY_KEY = "property:%s:%s:%s";
	String DEL_MODEL_KEY = "model:%s:*";
	String DEL_PROPERTY_KEY = "property:%s:%s:*";
	String DEL_MODEL_SET_KEY = "modelSet:%s";

}
