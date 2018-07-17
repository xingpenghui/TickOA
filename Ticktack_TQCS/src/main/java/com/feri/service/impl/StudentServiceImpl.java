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
	public ResultVo update(String photo,String no) {
		// TODO Auto-generated method stub
		if(mapper.updateByNo(photo, no)>0) {
			return ResultVo.setOK("图片修改成功");
		}else {
			return ResultVo.setERROR("图片修改失败");
		}
	}

	@Override
	public List<Student> queryByGid(int gid) {
		// TODO Auto-generated method stub
		return mapper.queryByGid(gid);
	}

	@Override
	public Student queryByNo(String no) {
		// TODO Auto-generated method stub
		return mapper.queryByNo(no);
	}

}
