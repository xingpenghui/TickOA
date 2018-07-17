package com.feri.service;

import java.util.List;

import com.feri.common.vo.ResultVo;
import com.feri.domain.Student;

public interface StudentService {

	Student queryByNo(String no);
	ResultVo update(String photo,String no);
	List<Student> queryByGid(int gid);
	
	
}
