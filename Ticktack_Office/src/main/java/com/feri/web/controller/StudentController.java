package com.feri.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.feri.common.util.ExcelUtils;
import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Student;
import com.feri.service.StudentService;

//操作学员
@Controller
public class StudentController {
	
	@Autowired//自动注入
	private StudentService service;
	//新增
	@RequestMapping(value="studentadd.do",method= {RequestMethod.POST})
	public String add(Student student) {
		if(service.insert(student)) {
			//成功
			return "studentlist";
		}else {
			//失败
			return "studentadd";
		}
	}
	//批量新增
	@RequestMapping(value="studentbatch.do",method= {RequestMethod.POST})
	public String add(MultipartFile mFile) throws IOException {
		List<Student> list=ExcelUtils.parseExcelS(mFile.getInputStream());
		if(service.insertBatch(list)) {
			//成功
			return "studentlist";
		}else {
			//失败
			return "studentadd";
		}
	}
	//查询
	@RequestMapping("studentpage.do")
	@ResponseBody
	public PageVo<Student> page(int page,int limit){
		return service.queryByPage(page, limit);
	}
	//删除
	@RequestMapping("studentdelete.do")
	@ResponseBody
	public ResultVo del(String no){
		return service.delete(no);
	}
	
	
	

}
