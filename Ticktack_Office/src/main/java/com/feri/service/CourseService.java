package com.feri.service;

import java.util.List;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Course;
import com.feri.domain.Depart;
import com.feri.domain.Grade;

public interface CourseService {

	//新增
	boolean insert(Course course);
	ResultVo update(Course course);
	ResultVo delete(int id);
	List<Course> queryAll();
	PageVo<Course> queryByPage(int page,int count);
	
	
}
