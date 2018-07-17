package com.feri.service.impl;

import java.util.Date;
import java.util.List;

import com.feri.common.util.HttpUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feri.dao.LoginLogMapper;
import com.feri.domain.LoginLog;
import com.feri.service.LoginLogService;

@Service
public class LoginLogServiceImpl implements LoginLogService{

	@Autowired
	private LoginLogMapper mapper;
	@Override
	public boolean insert(String no) {
		// TODO Auto-generated method stub
		LoginLog log = new LoginLog();
		log.setCreatetime(new Date());
		String json=HttpUtils.getLocation("http://ip.chinaz.com/getip.aspx");
		System.out.println(json);
		JSONObject jo=new JSONObject(json);
		log.setIp(jo.getString("ip"));
		log.setNo(no);
		log.setLocation(jo.getString("address").substring(0,jo.getString("address").indexOf(" ")));
		System.out.println(log.getLocation());
		return mapper.insert(log)>0;
	}

	@Override
	public List<LoginLog> queryAll() {
		// TODO Auto-generated method stub
		return mapper.queryAll();
	}

	@Override
	public List<LoginLog> queryByNo(String no) {
		return mapper.queryByNo(no);
	}

}
