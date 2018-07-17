package com.feri.service;

import java.util.List;

import com.feri.domain.LoginLog;

public interface LoginLogService {

	boolean insert(LoginLog log);
	List<LoginLog> queryAll();
}
