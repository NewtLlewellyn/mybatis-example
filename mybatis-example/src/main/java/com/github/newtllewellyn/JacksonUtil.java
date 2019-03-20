package com.github.newtllewellyn;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {

	private static ObjectMapper mapper = null;

	public static ObjectMapper getMapper() {
		if (mapper == null) {
			mapper = new ObjectMapper();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
			mapper.setDateFormat(df);
		}
		return mapper;
	}

}
