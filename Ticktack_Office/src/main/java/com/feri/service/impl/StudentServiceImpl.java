package com.feri.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.dao.StudentMapper;
import com.feri.domain.Student;
import com.feri.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper mapper;

	@Override
	public boolean insert(Student student) {
		// TODO Auto-generated method stub
		return mapper.insert(student) > 0;
	}

	@Override
	public ResultVo update(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultVo delete(String no) {
		// TODO Auto-generated method stub
		if (mapper.deleteByNo(no) > 0) {
			return ResultVo.setOK("删除学员成功");
		} else {
			return ResultVo.setERROR("删除学员失败");
		}
	}

	@Override
	public List<Student> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageVo<Student> queryByPage(int page, int count) {
		// TODO Auto-generated method stub
		PageVo<Student> po = new PageVo<>();
		int index = 0;
		if (page > 0) {
			index = (page - 1) * count;
		}
		po.setData(mapper.queryByPage(index, count));
		if (po.getData() != null) {
			po.setCount(mapper.queryCount().intValue());
		}
		po.setCode(0);
		po.setMsg("OK");
		return po;
	}

	@Override
	public List<Student> queryByGid(int gid) {
		// TODO Auto-generated method stub
		return mapper.queryByGid(gid);
	}

	@Override
	public Long queryCountBiGid(int gid) {
		// TODO Auto-generated method stub
		return mapper.queryCountGid(gid);
	}

	@Override
	public boolean insertBatch(List<Student> list) {
		// TODO Auto-generated method stub
		try {
			for (Student s : list) {

				mapper.insert(s);
			}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

}
