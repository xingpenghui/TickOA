package com.feri.service.impl;

import com.feri.common.vo.EchartsItem;
import com.feri.common.vo.EchartsVo;
import com.feri.common.vo.PageVo;
import com.feri.common.vo.ProcessVo;
import com.feri.dao.CheckProcessMapper;
import com.feri.domain.CheckProcess;
import com.feri.service.CheckProcessService;
import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2018/7/11 23:27
 */
@Service
public class CheckProcessServiceImpl implements CheckProcessService {
    @Autowired
    private CheckProcessMapper mapper;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private FormService formService;
    @Override
    public boolean insert(CheckProcess checkProcess,String rname) {
        Map<String,Object> vars=new HashMap<>();
        vars.put("startName",checkProcess.getStartname());
        vars.put("resultName",rname);
        vars.put("managerName",rname);
        vars.put("startDate",rname);
        vars.put("endDate",rname);
        vars.put("days",checkProcess.getDays());
        ProcessInstance processInstance=runtimeService.startProcessInstanceByKey("process_check",vars);
        checkProcess.setPid(processInstance.getId());
        Task task=taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        taskService.complete(task.getId(),vars);
        return mapper.insert(checkProcess)>0;
    }

    @Override
    public boolean update(String tid,int id, int flag) {
        taskService.complete(tid);
        return mapper.update(id,flag)>0;
    }

    @Override
    public boolean del(String pid,String name, int id) {
        taskService.resolveTask(taskService.createTaskQuery().processInstanceId(pid).taskAssignee(name).singleResult().getId());
        return  mapper.update(id,4)>0;
    }

    @Override
    public PageVo<CheckProcess> queryAll(String no) {
        PageVo<CheckProcess> pageVo=new PageVo<>();
        pageVo.setData(mapper.queryAll(no));
        pageVo.setCount(pageVo.getData().size());
        pageVo.setCode(0);
        return pageVo;
    }

    @Override
    public PageVo<ProcessVo> queryByName(String name) {
        PageVo<ProcessVo> pageVo=new PageVo<>();
        pageVo.setData(mapper.queryByName(name));
        pageVo.setCount(pageVo.getData().size());
        pageVo.setCode(0);
        return pageVo;
    }

    @Override
    public EchartsVo queryBtEcharts(String pid) {
        List<EchartsItem> items=mapper.queryBtEcharts(pid);
        if(items!=null){
            EchartsVo vo=new EchartsVo();
            for(int i=0;i<items.size();i++){
                EchartsItem item=items.get(i);
                if(i==0){
                    vo.setId(item.getId());
                }
                vo.getDatax().add(item.getAname());
                vo.getDatas1().add(item.getStime());
                vo.getDatas2().add(item.getEtime());
                vo.getDatas3().add(item.getDura());
            }
            return vo;
        }
        return null;
    }

}
