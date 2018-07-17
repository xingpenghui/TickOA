package com.feri.service;

import org.apache.ibatis.annotations.Param;

import com.feri.domain.User;

public interface UserService {

	//登录
	public User queryByNo(String no,String password);
	boolean updatePwd(String pass,String no);
}
