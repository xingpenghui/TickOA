package com.feri.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Depart;
import com.feri.service.DepartService;

//部门的数据接口 提供 新增、修改、删除、分页查询
@Controller
public class DepartController {
	
	@Autowired
	private DepartService service;
	
	//新增
	@RequestMapping(value="/departadd.do",method= {RequestMethod.POST})
	public String add(Depart depart) {
		if(service.insert(depart)) {
			return "departlist";
		}else {
			return "departadd";
		}
	}
	/*//修改--基于Ajax
	@RequestMapping(value="/departupdate1.do",method= {RequestMethod.POST})
	@ResponseBody
	public ResultVo updateAjax(String name,int id) {
		return service.update(name, id);
	}*/
	//修改--基于form表单
	@RequestMapping(value="/departupdate.do",method= {RequestMethod.POST})
	public String updateFrom(String name,int id) {
		if( service.update(name, id).getCode()==1000) {
			return "departlist";
		}else {
			return "departupdate";
		}
	}
	//删除--json格式数据 ---ajax
	@RequestMapping(value="departdelete.do",method= {RequestMethod.POST})
	@ResponseBody
	public ResultVo delete(int id) {
		return service.delete(id);
	}
	//查询  --分页
	@RequestMapping(value="departpage.do")
	@ResponseBody
	public PageVo<Depart> queryPage(int page,int limit){
		return service.queryByPage(page, limit);
	}
	//查询全部
	@RequestMapping("/departall.do")
	@ResponseBody
	public List<Depart> queryAll(){
		return service.queryAll();
	}
	

}
