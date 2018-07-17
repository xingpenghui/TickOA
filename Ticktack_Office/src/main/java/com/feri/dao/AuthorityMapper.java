package com.feri.dao;


import com.feri.domain.Authority;
import com.feri.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.math.BigInteger;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/6 09:35
 */
public interface AuthorityMapper {
    //新增
    @Insert("insert into t_authority (title,aicon,aurl,parentid) values(#{title},#{aicon},#{aurl},#{parentId})")
    int save(Authority authority);
    //删除
    int delete(int id);
    //查询分页
   // List<Authority> queryByPage(NoPageQo qo);
    @Select("select * from t_authority limit #{index},#{count}")
    @ResultType(Authority.class)
    List<Authority> queryPage(@Param("index") int index,@Param("count") int count);
    @Select("select r.* from t_role r left join t_roleauthority ra on ra.rid=r.id where ra.aid=#{id}")
    @ResultType(Role.class)
    List<Role> queryRole(int id);
    //查询数量
    @Select("select count(*) from t_authority")
    @ResultType(Long.class)
    Long queryCount();

    @Select("select * from t_authority where parentid=0")
    @ResultType(Authority.class)
    List<Authority> queryFirst();
    @Select("select * from t_authority")
    @ResultType(Authority.class)
    List<Authority> queryAll();



}
