package com.feri.web.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.InterviewQuest;
import com.feri.domain.User;
import com.feri.service.InterviewQuestService;

@Controller
public class InterviewQuestController {
	@Autowired
	private InterviewQuestService service;
	//新增
	@RequestMapping("/questadd.do")
	@ResponseBody
	public ResultVo add(InterviewQuest quest,HttpSession session) {
		User user=(User)session.getAttribute("user");
		quest.setNo(user.getNo());
		quest.setCreatedate(new Date());
		if(service.insert(quest)) {
			return ResultVo.setOK("OK");
		}else {
			return ResultVo.setERROR("ERROR");
		}
		
	}
	//查询
	@RequestMapping("/questpage.do")
	@ResponseBody
	public PageVo<InterviewQuest> query(int page,int limit) {
		return service.queryByPage(page, limit);
	}

}
