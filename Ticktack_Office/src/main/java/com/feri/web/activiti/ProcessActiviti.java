package com.feri.web.activiti;

import com.feri.common.vo.EchartsVo;
import com.feri.common.vo.PageVo;
import com.feri.common.vo.ProcessVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.CheckProcess;
import com.feri.domain.User;
import com.feri.service.CheckProcessService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/11 23:53
 */
@Controller
public class ProcessActiviti {
    @Autowired
    private CheckProcessService service;

    //新增
    @RequestMapping("processadd")
    public String save(CheckProcess process,String rname){
        User user=(User)SecurityUtils.getSubject().getSession().getAttribute("user");
        process.setStartno(user.getNo());
        process.setStartname(user.getName());
        if(service.insert(process,rname)){
            //成功
            return "processlist";
        }else{
            //失败
            return "processadd";
        }
    }
    //审批
    @RequestMapping("processupdate")
    @ResponseBody
    public ResultVo update(String tid,int id,int flag){
        if(service.update(tid, id, flag)){
            return ResultVo.setOK("审批成功");
        }else {
            return ResultVo.setERROR("审批失败");
        }
    }
    //我的流程记录
    @RequestMapping("processlist")
    @ResponseBody
    public PageVo<CheckProcess> list(){
        User user=(User)SecurityUtils.getSubject().getSession().getAttribute("user");
       return service.queryAll(user.getNo());
    }
    //待办事项
    @RequestMapping("processnolist")
    @ResponseBody
    public PageVo<ProcessVo> list2(){
        User user=(User)SecurityUtils.getSubject().getSession().getAttribute("user");
        return service.queryByName(user.getName());
    }

    @RequestMapping("processdel")
    @ResponseBody
    public ResultVo del(String pid,int id){
        User user=(User)SecurityUtils.getSubject().getSession().getAttribute("user");
        if(service.del(pid,user.getName(),id)){
            return ResultVo.setOK("取消成功");
        }else{
            return ResultVo.setERROR("取消失败");
        }
    }
    @RequestMapping("processecharts")
    @ResponseBody
    public EchartsVo tb(String pid){
        return service.queryBtEcharts(pid);
    }


}
