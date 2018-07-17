package com.feri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.feri.domain.LoginLog;

public interface LoginLogMapper {
    int insert(LoginLog record);
	List<LoginLog> queryAll();
}