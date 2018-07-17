package com.feri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.feri.domain.Depart;

public interface DepartMapper {

	//新增
	@Insert("insert into t_depart(name,createtime,flag) value(#{name},#{createtime},1)")
	int  insert(Depart depart);
	
	//修改
	@Update("update t_depart set name=#{name} where flag=1 and id=#{id}")
	int update(@Param("name")String name,@Param("id")int id);
	
	//删除
	@Update("update t_depart set flag=2 where id=#{id}")
	int delete(int id);
	
	//查询  分页
	@Select("select d.id,d.name,d.createtime,d.flag,s.dcount from t_depart d left join (select count(*) dcount,did from t_staff group by did) s on d.id=s.did where d.flag=1 limit #{rowindex},#{count}")
	@ResultType(Depart.class)
	List<Depart> queryByPage(@Param("rowindex")int index,@Param("count")int count);
	
	//总数量
	@Select("select count(*) from t_depart where flag=1")
	@ResultType(Long.class)
	Long queryCount();
	
	@Select("select id,name from t_depart where flag=1")
	@ResultType(Depart.class)
	List<Depart> queryAll();
	
}
