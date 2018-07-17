package com.feri.service;

import com.feri.common.vo.EchartsVo;
import com.feri.common.vo.PageVo;
import com.feri.common.vo.ProcessVo;
import com.feri.domain.CheckProcess;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/11 23:27
 */
public interface CheckProcessService {
    boolean insert(CheckProcess checkProcess,String rname);
    boolean update(String tid,int id, int flag);
    boolean del(String tid,String name,int id);
    PageVo<CheckProcess> queryAll(String no);
    PageVo<ProcessVo> queryByName(String name);
    EchartsVo queryBtEcharts(String pid);
}
