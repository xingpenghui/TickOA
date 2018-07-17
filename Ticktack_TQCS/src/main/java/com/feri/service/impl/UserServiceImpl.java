package com.feri.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feri.common.util.MD5Utils;
import com.feri.dao.UserMapper;
import com.feri.domain.User;
import com.feri.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper dao;
	//成功 有对象 失败 null
	@Override
	public User queryByNo(String no, String password) {
		// TODO Auto-generated method stub
		User user=dao.queryByNo(no);
		if(user!=null) {
			if(Objects.equals(MD5Utils.md5(password), user.getPassword())){
				return user;
			}
		}
		return null;
	}
	@Override
	public boolean updatePwd(String pass, String no) {
		// TODO Auto-generated method stub
		return dao.updatePwd(MD5Utils.md5(pass), no)>0;
	}

}
