package com.feri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.feri.domain.Course;
import com.feri.domain.Depart;

public interface CourseMapper {
	//删除
	@Update("update t_course set flag=2 where id = #{id}")
    int deleteById(Integer id);
    //新增
	@Insert("insert into t_course ( name, flag, week, createdate, type )values ( #{name}, 1,#{week,jdbcType=INTEGER}, #{createdate,jdbcType=DATE}, #{type})")
    int insert(Course record);

    //
    @Update("update t_course set name = #{name},week = #{week} where id = #{id}")
    int updateById(Course record);
    
    @Select("select id, name from t_course where flag=1")
    @ResultType(Course.class)
    List<Course> queryAll();
	//查询  分页
	@Select("select c.id, c.name, c.flag, c.week, c.createdate, c.type,g.gcount from t_course c left join (select count(*)gcount,cid from t_grade group by cid) g on c.id=g.cid where c.flag=1 limit #{rowindex},#{count}")
	@ResultType(Course.class)
	List<Course> queryByPage(@Param("rowindex")int index,@Param("count")int count);
	
	//总数量
	@Select("select count(*) from t_course where flag=1")
	@ResultType(Long.class)
	Long queryCount();
	
}