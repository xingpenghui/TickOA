package com.feri.service;

import java.util.List;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Depart;

public interface DepartService {

	//新增
	boolean insert(Depart depart);
	ResultVo update(String name,int id);
	ResultVo delete(int id);
	PageVo<Depart> queryByPage(int page,int count);
	Long queryCount(int index,int count);
	List<Depart> queryAll();
	
}
