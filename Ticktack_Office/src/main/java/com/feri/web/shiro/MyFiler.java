package com.feri.web.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@Author feri
 *@Date Created in 2018/7/6 11:08
 * 自定义校验
 */
public class MyFiler extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappers) throws Exception {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        System.out.println("请求："+request.getRequestURI());
        if(request.getRequestURI().contains(".do")){
            return true;
        }
        //获取主题
        Subject subject=getSubject(servletRequest,servletResponse);
        //获取需要校验的角色
        String[] checkRoles=(String[])mappers;
        System.out.println("角色："+checkRoles);
        //逐一校验  只要任意一个通过即可
        for(String s:checkRoles) {
           if(subject.hasRole(s)){
               return true;
           }
        }
        return false;
    }
}
