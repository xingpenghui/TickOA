package com.feri.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.feri.common.vo.PageVo;
import com.feri.domain.LoginLog;
import com.feri.domain.User;
import com.feri.service.LoginLogService;
import com.feri.service.UserService;

//操作用户表
@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@Autowired
	private LoginLogService logService;
	//InternalResourceViewResolver
	//登录
	@RequestMapping(value="/login.do",method= {RequestMethod.POST})
	public String login(String no,String pass,String ip,String city,HttpSession session) {
		User user=service.queryByNo(no, pass);
		if(user!=null) {
			session.setAttribute("user", user);
			LoginLog log=new LoginLog();
			log.setCreatetime(new Date());
			log.setIp(ip);
			log.setNo(no);
			log.setLocation(city);
			logService.insert(log);
			return "redirect:index.html";
		}else {
			return "redirect:login.html";
		}
	}
	//注销
	@RequestMapping("/loginout.do")
	public String loginout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}
	//查询登录历史
	@RequestMapping("/loginloglist.do")
	@ResponseBody
	public PageVo<LoginLog> list()
	{
			PageVo<LoginLog> po=new PageVo<>();
			po.setData(logService.queryAll());
			po.setCode(0);
			po.setCount(po.getData().size());
			po.setMsg("OK");
			return po;
	}
	//修改密码
	@RequestMapping(value="/userpwd.do",method= {RequestMethod.POST})
	public void changePwd(String password,HttpSession session,HttpServletResponse response) throws IOException {
		User user=(User) session.getAttribute("user");
		if(service.updatePwd(password, user.getNo())) {
			response.getWriter().println("OK");
		}else {
			response.getWriter().println("ERROR");
		}
	}


}
