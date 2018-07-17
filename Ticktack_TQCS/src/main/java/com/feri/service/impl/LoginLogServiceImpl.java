package com.feri.service.impl;

import java.util.List;

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
	public boolean insert(LoginLog log) {
		// TODO Auto-generated method stub
		return mapper.insert(log)>0;
	}

	@Override
	public List<LoginLog> queryAll() {
		// TODO Auto-generated method stub
		return mapper.queryAll();
	}

}
