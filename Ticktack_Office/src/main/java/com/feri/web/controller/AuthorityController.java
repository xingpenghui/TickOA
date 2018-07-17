package com.feri.web.controller;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.dao.AuthorityMapper;
import com.feri.domain.Authority;
import com.feri.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/14 14:25
 */
@Controller
public class AuthorityController {
    @Autowired
    private AuthorityService service;

    @RequestMapping("authorityadd")
    @ResponseBody
    public ResultVo add(Authority authority){
        return service.save(authority);
    }
    @RequestMapping("authoritylist")
    @ResponseBody
    public PageVo<Authority> list(int page,int limit){
        return service.queryByPage(page, limit);
    }
    @RequestMapping("authorityroot")
    @ResponseBody
    public List<Authority> list2(){
        return service.queryFirst();
    }
}
