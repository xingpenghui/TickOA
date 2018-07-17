package com.feri.web.shiro;

import com.feri.domain.Role;
import com.feri.domain.User;
import com.feri.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/6 11:02
 * 为Shiro数据源
 * 根据数据库提供数据源
 */
@Controller()
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService service;

    //访问控制  会拦截请求 准备用户的角色信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //根据当前的认证用户实现访问的控制

        //1、获取登录用户
        Session session=SecurityUtils.getSubject().getSession();
        User user= (User) session.getAttribute("user");
        if(user!=null){
            //获取当前用户对应的角色
            SimpleAuthorizationInfo authorizationInfo=(SimpleAuthorizationInfo)session.getAttribute("userroles");
            if(authorizationInfo==null){
                authorizationInfo=new SimpleAuthorizationInfo();
            }
            //获取用户的角色并遍历
            //authorizationInfo.addRole("");
            List<Role> roles=service.queryRole(user.getId());
            System.out.println("用户的角色："+roles);
            for(Role r:roles){
                authorizationInfo.addRole(r.getId()+"");
            }
            session.setAttribute("userroles",authorizationInfo);
            return authorizationInfo;
        }
        return null;
    }

    //认证/登录   登录成功之后的授权、许可
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取登录的用户信息
        UsernamePasswordToken passwordToken= (UsernamePasswordToken) authenticationToken;

            if(passwordToken.getUsername()!=null && passwordToken.getUsername().length()>0){
                return new SimpleAuthenticationInfo(passwordToken.getUsername(),passwordToken.getPassword(),getName());
            }else{
            return null;
        }
    }
}
