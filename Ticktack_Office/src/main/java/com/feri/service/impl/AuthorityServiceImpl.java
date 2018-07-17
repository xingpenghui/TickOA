package com.feri.service.impl;


import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.dao.AuthorityMapper;
import com.feri.domain.Authority;
import com.feri.domain.Role;
import com.feri.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/6 14:43
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityMapper mapper;

    @Override
    public ResultVo save(Authority authority) {
        if(mapper.save(authority)>0){
            return ResultVo.setOK("新增成功");
        }else {
            return ResultVo.setERROR("新增失败");
        }
    }

    @Override
    public List<Authority> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public PageVo<Authority> queryByPage(int page,int limit) {
        PageVo<Authority> pageVo=new PageVo<>();
        pageVo.setData(mapper.queryPage((page-1)*limit,limit));
        pageVo.setCode(0);
        pageVo.setCount(mapper.queryCount().intValue());
        return  pageVo;
    }

    @Override
    public List<Role> queryRole(int id) {
        return mapper.queryRole(id);
    }

    @Override
    public List<Authority> queryFirst() {
        return mapper.queryFirst();
    }


}
