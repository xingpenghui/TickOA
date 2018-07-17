package com.feri.service;

import java.util.List;

import com.feri.domain.LoginLog;

public interface LoginLogService {

	boolean insert(String no);
	List<LoginLog> queryAll();
	List<LoginLog> queryByNo(String no);
}
