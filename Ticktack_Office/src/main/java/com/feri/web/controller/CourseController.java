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
import com.feri.service.CourseService;

//課程的数据接口 提供 新增、修改、删除、分页查询
@Controller
public class CourseController {

	@Autowired
	private CourseService service;

	// 新增
	@RequestMapping(value = "/courseadd.do", method = { RequestMethod.POST })
	public String add(Course course) {
		if (service.insert(course)) {
			return "courselist";
		} else {
			return "courseadd";
		}
	}

	// 修改--基于form表单
	@RequestMapping(value = "/courseupdate.do", method = { RequestMethod.POST })
	public String updateFrom(Course course) {
		if (service.update(course).getCode() == 1000) {
			return "courselist";
		} else {
			return "courseupdate";
		}
	}

	// 删除--json格式数据 ---ajax
	@RequestMapping(value = "coursedelete.do", method = { RequestMethod.POST })
	@ResponseBody
	public ResultVo delete(int id) {
		return service.delete(id);
	}

	// 查询 --分页
	@RequestMapping(value = "coursepage.do")
	@ResponseBody
	public PageVo<Course> queryPage(int page, int limit) {
		return service.queryByPage(page, limit);
	}

	// 查询全部课程
	@RequestMapping(value = "courseall.do")
	@ResponseBody
	public List<Course> queryAll() {
		return service.queryAll();
	}

}
