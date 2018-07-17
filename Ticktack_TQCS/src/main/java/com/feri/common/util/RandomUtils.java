package com.feri.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

//随机数
public class RandomUtils {
	//生成激活码
	public static String createActive(){
		return getTime()+Integer.toHexString(new Random().nextInt(900)+100);
	}
	//设置时间戳
	public static String getTime(){
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
	}
	//生成订单编号
	public static String createOrderId(){
		return getTime()+UUID.randomUUID().toString();
	}
}
