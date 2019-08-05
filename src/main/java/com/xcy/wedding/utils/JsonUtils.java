package com.xcy.wedding.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;




public class JsonUtils {

	public static JsonBean createJsonBean(int code, Object info){
		JsonBean bean = new JsonBean();
		bean.setCode(code);
		bean.setInfo(info);

		return bean;
	}
}
