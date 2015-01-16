package com.maven.demo.web.filter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Created by Table on 2014/5/12.
 */
public class ObjectMappingCustomer extends ObjectMapper {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4424350683375526512L;

	public ObjectMappingCustomer() {
		super();
		// 允许单引号
		this.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		// 字段和值都加引号
		this.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		// 数字不加引号
		this.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, false);

		this.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, true);
		// 空值处理为空串
		this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
			@Override
			public void serialize(Object value, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {
				System.out.println("===========执行-类名：ObjectMappingCustomer 方法名：serialize===========");
				jg.writeString("");
			}
		});

	}
}
