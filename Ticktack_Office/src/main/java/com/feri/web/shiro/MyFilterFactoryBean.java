package com.feri.web.shiro;

import com.feri.domain.Authority;
import com.feri.domain.Role;
import com.feri.service.AuthorityService;
import com.feri.service.RoleService;
import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/6 11:04
 * 过滤工厂
 */
public class MyFilterFactoryBean extends ShiroFilterFactoryBean {
    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private RoleService roleService;

    private String filterChainDefinitions;//设置放行资源  静态

    @Override
    public void setFilterChainDefinitions(String definitions) {
        filterChainDefinitions=definitions;
        //设置Shiro静态配置配置
        Ini ini=new Ini();
        //加载静态资源
        ini.load(filterChainDefinitions);
        //获取静态的url数据  map集合  key就是权限对应的url value：就是拥有此权限的角色
        Ini.Section section=ini.getSection(IniFilterChainResolverFactory.URLS);
        if(CollectionUtils.isEmpty(section)){
            section=ini.getSection(Ini.DEFAULT_SECTION_NAME);
        }
        //读取角色对应的权限
       List<Authority> list=authorityService.queryAll();
        for(Authority a:list){
            StringBuffer buffer=new StringBuffer();
            buffer.append("roles[");
            List<Role> roles=authorityService.queryRole(a.getId());
            for(Role r:roles){
                buffer.append(r.getId()+",");
            }
            buffer.deleteCharAt(buffer.length()-1);
            buffer.append("]");

            section.put(a.getAurl(),buffer.toString());
        }
        //设置认证访问
        section.put("/**","authc");
        System.out.println("权限：key="+section.keySet()+"----值："+section.values());

        //访问控制进行设置
        setFilterChainDefinitionMap(section);
    }
}
