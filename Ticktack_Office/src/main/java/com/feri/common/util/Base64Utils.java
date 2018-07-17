package com.feri.common.util;

import java.util.Base64;

/**
 * 基于JDK1.8实现的BASE64编码
 * 编码
 * 解码*/
public class Base64Utils {
	//编码
	public static String encode(String msg){
		return Base64.getEncoder().encodeToString(msg.getBytes());
	}
	//解码
	public static String decode(String msg){
		return new String(Base64.getDecoder().decode(msg));
	}
}
