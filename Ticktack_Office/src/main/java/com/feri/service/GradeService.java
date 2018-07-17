package com.feri.service;

import java.util.List;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Course;
import com.feri.domain.Depart;
import com.feri.domain.Grade;

public interface GradeService {

	//新增
	boolean insert(Grade grade);
	ResultVo update(Grade grade);
	ResultVo delete(int id);
	List<Grade> queryAll();
	PageVo<Grade> queryByPage(int page,int count);
	
	
}
