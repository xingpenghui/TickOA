package com.feri.service;

import java.util.List;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Depart;
import com.feri.domain.Grade;
import com.feri.domain.Staff;

public interface StaffService {

	//新增
	boolean insert(Staff staff);
	ResultVo update(Staff staff);
	ResultVo delete(String no);
	List<Staff> queryAll();
	PageVo<Staff> queryByPage(int page,int count);
	String queryMaxNo();
	boolean insertBatch(List<Staff> list);
	
}
