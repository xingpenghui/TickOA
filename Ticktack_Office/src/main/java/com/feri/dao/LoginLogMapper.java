package com.feri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.feri.domain.LoginLog;

public interface LoginLogMapper {
	@Insert("insert into t_loginlog (ip, no, createtime,location) values ( #{ip}, #{no}, #{createtime}, #{location})")
    int insert(LoginLog record);
	@Select("select id, ip, no, createtime, location from t_loginlog order by createtime desc limit 15")
    @ResultType(LoginLog.class)
	List<LoginLog> queryAll();
	@Select("select id, ip, no, createtime, location from t_loginlog where no=#{no} order by createtime desc ")
    @ResultType(LoginLog.class)
	List<LoginLog> queryByNo(String no);
}