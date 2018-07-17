package com.feri.test;

import com.feri.common.util.HttpUtils;
import org.json.JSONObject;

/**
 *@Author feri
 *@Date Created in 2018/7/12 13:50
 */
public class MyIpTest {
    public static void main(String[] args) {
       String json=HttpUtils.getLocation("http://ip.chinaz.com/getip.aspx");
        System.out.println(new JSONObject(json).get("address"));
    }
}
