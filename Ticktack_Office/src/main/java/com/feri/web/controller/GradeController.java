package com.feri.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Course;
import com.feri.domain.Grade;
import com.feri.service.GradeService;

//部门的数据接口 提供 新增、修改、删除、分页查询
@Controller
public class GradeController {
	
	@Autowired
	private GradeService service;
	
	//新增
	@RequestMapping(value="/gradeadd.do",method= {RequestMethod.POST})
	public String add(Grade grade) {
		if(service.insert(grade)) {
			return "gradelist";
		}else {
			return "gradeadd";
		}
	}
	
	//修改--基于form表单
	@RequestMapping(value="/gradeupdate.do",method= {RequestMethod.POST})
	public String updateFrom(Grade grade) {
		if( service.update(grade).getCode()==1000) {
			return "gradelist";
		}else {
			return "gradeupdate";
		}
	}
	//删除--json格式数据 ---ajax
	@RequestMapping(value="gradedelete.do",method= {RequestMethod.POST})
	@ResponseBody
	public ResultVo delete(int id) {
		return service.delete(id);
	}
	//查询  --分页
	@RequestMapping(value="gradepage.do")
	@ResponseBody
	public PageVo<Grade> queryPage(int page,int limit){
		return service.queryByPage(page, limit);
	}

	// 查询全部课程
	@RequestMapping(value = "gradeall.do")
	@ResponseBody
	public List<Grade> queryAll() {
		return service.queryAll();
	}


}
