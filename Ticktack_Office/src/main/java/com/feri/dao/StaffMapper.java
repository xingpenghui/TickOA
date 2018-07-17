package com.feri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.feri.domain.Grade;
import com.feri.domain.Staff;

public interface StaffMapper {
	@Update("update t_staff set flag=2 where no=#{no}")
    int deleteById(String no);
	@Insert("insert into t_staff (no, name, did,  flag, sex, email, qq,  phone, createdate, photo ) values (#{no,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{did,jdbcType=INTEGER},   1, #{sex,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{qq,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{createdate,jdbcType=DATE}, #{photo,jdbcType=VARCHAR} )")
    int insert(Staff record);
	@Update(" update t_staff set name = #{name,jdbcType=VARCHAR}, did = #{did,jdbcType=INTEGER}, email = #{email,jdbcType=VARCHAR},qq = #{qq,jdbcType=VARCHAR}, phone = #{phone,jdbcType=VARCHAR}, photo = #{photo,jdbcType=VARCHAR}  where no = #{no,jdbcType=VARCHAR}")
    int updateById(Staff record);
	@Update("update t_staff set photo = #{photo} where no = #{no}")
    int updatePhoto(@Param("no")String no,@Param("photo")String photo);
  //查询  分页
  	@Select("select s.no, s.name, s.did, s.flag, s.sex,s.email, s.qq, s.phone, s.createdate, s.photo,d.name dname from t_staff  s left join t_depart d on s.did=d.id  where s.flag=1 limit #{rowindex},#{count}")
  	@ResultType(Staff.class)
  	List<Staff> queryByPage(@Param("rowindex")int index,@Param("count")int count);
  	
  	//总数量
  	@Select("select count(*) from t_staff where flag=1")
  	@ResultType(Long.class)
  	Long queryCount();
  	
  	@Select("select no, name from t_staff where flag=1")
    @ResultType(Staff.class)
    List<Staff> queryAll();
  	
  	@Select("select no from t_staff order by no desc limit 1")
  	@ResultType(String.class)
  	String queryMaxNo();
  	
}