package com.feri.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feri.domain.Student;
import com.feri.domain.User;
import com.feri.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	//查询学生信息
	@RequestMapping("studentbyno.do")
	@ResponseBody
	public Student queryByno(HttpSession session) {
		User user=(User) session.getAttribute("user");
		if(user !=null) {
			Student stu=service.queryByNo(user.getNo());
			return stu;
		}else {
			return new Student();
		}
	}
	//修改图片
	@RequestMapping("studentupdate.do")
	public String update(String photo,String no) {
		service.update(photo, no);
		return "studentupdate";
	}
	//修改密码
	
	

}
