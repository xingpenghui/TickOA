package com.feri.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2018/7/11 15:12
 */
public class FromActiviti {
    public static void main(String[] args) {
        ProcessEngineConfiguration configuration=ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("spring-activiti.xml");
        ProcessEngine processEngine=configuration.buildProcessEngine();
//        Deployment deployment=processEngine.getRepositoryService().createDeployment().addClasspathResource("bpmn/leave.bpmn").deploy();
//        System.out.println("部署："+deployment.getId());
//        ProcessDefinition processDefinition=processEngine.getRepositoryService().createProcessDefinitionQuery().deploymentId("2501").singleResult();
//        System.out.println("流程定义："+processDefinition.getResourceName());
//        List<FormProperty> formPropertyList=processEngine.getFormService().getStartFormData(processDefinition.getId()).getFormProperties();
//        for(FormProperty fp:formPropertyList){
//            System.out.println(fp.getName()+"--->"+fp.getId());
//        }
//        ProcessDefinition processDefinition=processEngine.getRepositoryService().getProcessDefinition()
//        processEngine.getFormService().getStartFormData(processEngine.)
        Map<String,Object> map=new HashMap<>();
        map.put("user","赵武");
        ProcessInstance processInstance=processEngine.getRuntimeService().startProcessInstanceByKey("myProcess_1",map);
        System.out.println("流程实例："+processInstance.getId());
        Task task=processEngine.getTaskService().createTaskQuery().taskAssignee("赵武").singleResult();
        System.out.println("任务："+task.getName());

        Map<String,String> vls=new HashMap<>();
        vls.put("reason","太搞笑");
        processEngine.getFormService().saveFormData(task.getId(),vls);
        TaskFormData tfd=processEngine.getFormService().getTaskFormData(task.getId());
        List<FormProperty> formPropertyList=tfd.getFormProperties();
        for(FormProperty fp:formPropertyList){
            System.out.println(fp.getValue()+"--->"+fp.getId());
        }
    }
}
