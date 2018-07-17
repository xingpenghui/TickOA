package com.feri.service;



import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Authority;
import com.feri.domain.Role;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/6 11:54
 */
public interface AuthorityService {
    //新增
    ResultVo save(Authority authority);
    //查询
   // List<Authority> queryByPage(NoPageQo qo);
    List<Authority> queryAll();
    PageVo<Authority> queryByPage(int page,int limit);
    List<Role> queryRole(int id);
    List<Authority> queryFirst();

}
