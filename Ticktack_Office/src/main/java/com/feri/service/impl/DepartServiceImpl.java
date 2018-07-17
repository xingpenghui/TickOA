package com.feri.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.dao.DepartMapper;
import com.feri.domain.Depart;
import com.feri.service.DepartService;

@Service
public class DepartServiceImpl implements DepartService{

	@Autowired
	private DepartMapper dao;
	@Override
	public boolean insert(Depart depart) {
		// TODO Auto-generated method stub
		return dao.insert(depart)>0;
	}

	@Override
	public ResultVo update(String name, int id) {
		// TODO Auto-generated method stub
		if( dao.update(name, id)>0) {
			return ResultVo.setOK("修改部门成功");
		}else {
			return ResultVo.setERROR("修改部门失败");
		}
	}

	@Override
	public ResultVo delete(int id) {
		// TODO Auto-generated method stub
		if(dao.delete(id)>0) {
			return ResultVo.setOK("删除部门成功");
		}else {
			return ResultVo.setERROR("删除部门失败");
		}
	}

	@Override
	public PageVo<Depart> queryByPage(int page, int count) {
		// TODO Auto-generated method stub
		PageVo<Depart> vo=new PageVo<>();
		int index=0;
		if(page>0) {
			index=(page-1)*count;
		}
		List<Depart> list=dao.queryByPage(index, count);
		if(list!=null) {
			vo.setCode(0);
			vo.setMsg("");
			vo.setData(list);
			vo.setCount(dao.queryCount().intValue());
		}else {
			vo.setCode(1);
			vo.setMsg("暂无数据");
			vo.setData(new ArrayList<>());
			vo.setCount(0);
		}
		return vo;
	}

	@Override
	public Long queryCount(int index, int count) {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	@Override
	public List<Depart> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}

}
