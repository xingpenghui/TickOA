package com.feri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.feri.domain.Grade;

public interface GradeMapper {
	@Update("update t_grade set flag=2 where id=#{id}")
    int deleteById(Integer id);
	@Insert("insert into t_grade ( name, flag, week, createdate, location ,cid)values ( #{name}, 1,#{week,jdbcType=INTEGER}, #{createdate,jdbcType=DATE}, #{location,jdbcType=VARCHAR},#{cid} )")
    int insert(Grade record);
	@Update("update t_grade set name=#{name},week=#{week},location=#{location} where id=#{id}")
    int updateById(Grade record);
	@Select("select id, name from t_grade where flag=1")
    @ResultType(Grade.class)
    List<Grade> queryAll();
	//查询  分页
	@Select("select g.id, g.name, g.flag, g.week, g.createdate, g.location,g.cid,c.name cname from t_grade g left join t_course c on g.cid=c.id where g.flag=1 limit #{rowindex},#{count}")
	@ResultType(Grade.class)
	List<Grade> queryByPage(@Param("rowindex")int index,@Param("count")int count);
	
	//总数量
	@Select("select count(*) from t_grade where flag=1")
	@ResultType(Long.class)
	Long queryCount();
    
}