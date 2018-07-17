package com.feri.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.feri.common.util.ExcelUtils;
import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Staff;
import com.feri.service.StaffService;

//员工的数据接口 提供 新增、修改、删除、分页查询
@Controller
public class StaffController {

	@Autowired
	private StaffService service;

	// 新增
	@RequestMapping(value = "/staffadd.do", method = { RequestMethod.POST })
	public String add(Staff staff) {
		if (service.insert(staff)) {
			return "stafflist";
		} else {
			return "staffadd";
		}
	}

	// 修改--基于form表单
	@RequestMapping(value = "/staffupdate.do", method = { RequestMethod.POST })
	public String updateFrom(Staff staff) {
		if (service.update(staff).getCode() == 1000) {
			return "stafflist";
		} else {
			return "staffupdate";
		}
	}

	// 删除--json格式数据 ---ajax
	@RequestMapping(value = "staffdelete.do", method = { RequestMethod.POST })
	@ResponseBody
	public ResultVo delete(String no) {
		return service.delete(no);
	}

	// 查询 --分页
	@RequestMapping(value = "staffpage.do")
	@ResponseBody
	public PageVo<Staff> queryPage(int page, int limit) {
		return service.queryByPage(page, limit);
	}

	// 查询全部信息
	@RequestMapping(value = "staffall.do")
	@ResponseBody
	public List<Staff> queryAll() {
		return service.queryAll();
	}
	@RequestMapping(value = "staffno.do")
	@ResponseBody
	public ResultVo queryMaxNo() {
		return ResultVo.setOK(service.queryMaxNo());
	}
	//批量导入
	@RequestMapping("staffbatch.do")
	public String batch(MultipartFile mFile,HttpServletRequest request) throws IOException {
		List<Staff> list=ExcelUtils.parseExcel(mFile.getInputStream());
		if(service.insertBatch(list)) {
			return "stafflist";
		} else {
			return "staffbatch";
		}
		
	}
	

}
