package com.feri.web.listerner;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;

/**
 *@Author feri
 *@Date Created in 2018/7/12 09:45
 */
public class ApplicationInitListener extends ContextLoaderListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        WebApplicationContext context=WebApplicationContextUtils.findWebApplicationContext(event.getServletContext());
        RepositoryService repositoryService= (RepositoryService) context.getBean("repositoryService");
        if(repositoryService.createDeploymentQuery().deploymentName("process_check").singleResult()==null) {
            Deployment deployment = repositoryService.createDeployment().name("process_check").addClasspathResource("flow/check.bpmn").deploy();
            System.out.println(deployment.getId() + "---->" + deployment.getName());
        }
    }
}
