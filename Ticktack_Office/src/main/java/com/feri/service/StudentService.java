package com.feri.service;

import java.util.List;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Depart;
import com.feri.domain.Grade;
import com.feri.domain.Staff;
import com.feri.domain.Student;

public interface StudentService {

	//新增
	boolean insert(Student student);
	ResultVo update(Student student);
	ResultVo delete(String no);
	List<Student> queryAll();
	PageVo<Student> queryByPage(int page,int count);
	List<Student> queryByGid(int gid);
	Long queryCountBiGid(int gid);
	
	boolean insertBatch(List<Student> list);
	
}
