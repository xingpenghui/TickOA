package com.feri.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.dao.GradeMapper;
import com.feri.domain.Course;
import com.feri.domain.Grade;
import com.feri.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService{

	@Autowired
	private GradeMapper mapper;
	@Override
	public boolean insert(Grade grade) {
		// TODO Auto-generated method stub
		return mapper.insert(grade)>0;
	}

	@Override
	public ResultVo update(Grade grade) {
		// TODO Auto-generated method stub
		if(mapper.updateById(grade)>0) {
			return ResultVo.setOK("修改班级成功");
		}else {
			return ResultVo.setERROR("修改班级失败");
		}
		
	}

	@Override
	public ResultVo delete(int id) {
		// TODO Auto-generated method stub
		if(mapper.deleteById(id)>0) {
			return ResultVo.setOK("删除班级成功");
		}else {
			return ResultVo.setERROR("删除班级失败");
		}
	}

	@Override
	public List<Grade> queryAll() {
		// TODO Auto-generated method stub
		return mapper.queryAll();
	}

	@Override
	public PageVo<Grade> queryByPage(int page, int count) {
		// TODO Auto-generated method stub
		int index=0;
		if(page>0) {
			index=(page-1)*count;
		}
		PageVo<Grade> po=new PageVo<>();
		po.setData(mapper.queryByPage(index, count));
		if(po.getData()!=null) {
			po.setCount(mapper.queryCount().intValue());
		}
		po.setCode(0);
		po.setMsg("OK");
		return po;
	}

}
