package com.feri.dao;


import com.feri.common.vo.TreeNode;
import com.feri.domain.Authority;
import com.feri.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/6 09:35
 */
public interface RoleMapper {
    //新增
    @Insert("insert into t_role(info,name,parentId) values(#{info},#{root},#{parentId})")
    int save(Role role);
    //删除
    @Delete("delete from t_role where id=#{id}")
    int delete(int id);
    //查询
    @Select("select * from t_role")
    @ResultType(Role.class)
    List<Role> queryAll();

    //查询角色对应的权限
    @Select("select t.* from t_authority t left join t_roleauthority ra on t.id=ra.aid where ra.rid=#{rid}")
    @ResultType(Authority.class)
    List<Authority> queryAuthority(int rid);
    @Select("select a.id,a.title name,a.aurl href,a.parentid from t_authority a order by a.parentid ")
    @ResultType(TreeNode.class)
    List<TreeNode> queryAuthoritys();
    //修改角色对应的权限
    //新增角色对应的权限
    @Insert("insert into t_roleauthority(rid,aid) values(#{rid},#{aid});")
    int insertAuth(@Param("rid") int rid, @Param("aid") int aid);
    //删除
    @Delete("delete from t_roleauthority where rid=#{rid}")
    int delAuth(int rid);




}
