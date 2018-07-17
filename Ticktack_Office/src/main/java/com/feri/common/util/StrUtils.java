package com.feri.common.util;
//字符串的各种校验
public class StrUtils {
	
	/**
	 * 是否为空的校验
	 * @return true 空 false 非空*/
	public static boolean empty(String...msg){
		boolean res = false;
		for(String s:msg){
			res = (s==null|| s.length()==0);
			if(res) {
				break;
			}
		}
		return res;
	}
	
	
}
