package com.feri.web.controller;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.TreeRoot;
import com.feri.domain.Authority;
import com.feri.domain.Role;
import com.feri.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/12 15:35
 */
@Controller
public class RoleController {
    @Autowired
    private RoleService service;

    @RequestMapping("roleall")
    @ResponseBody
    public List<Role> queryAll(){
        return service.queryAll();
    }

    @RequestMapping("rolepage")
    @ResponseBody
    public PageVo<Role> queryAll2(){
        PageVo<Role> pageVo=new PageVo<>();
        List<Role> roles= service.queryAll();
        pageVo.setData(roles);
        pageVo.setCode(0);
        pageVo.setCount(roles.size());
        return pageVo;
    }

    @RequestMapping("authorithall")
    @ResponseBody
    public List<TreeRoot> queryAuthoritys(){
        return service.queryAuthoritys();
    }
    @RequestMapping("roleauths")
    @ResponseBody
    public List<Authority> queryAuthority(int rid){
        return service.queryAuthority(rid);
    }


}
