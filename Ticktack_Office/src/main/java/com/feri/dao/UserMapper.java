package com.feri.dao;

import com.feri.common.vo.MenuVo;
import com.feri.common.vo.UserRoleVo;
import com.feri.domain.Authority;
import com.feri.domain.Role;
import org.apache.ibatis.annotations.*;

import com.feri.domain.User;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface UserMapper {

	//新增
	@Insert("insert into t_user(no,password,name,flag) values(#{no},#{password},#{name},1)")
	public int insert(User user);
	//查询
	@Select("select * from t_user where no=#{no} and flag=1")
	@ResultType(User.class)
	public User queryByNo(String no);
	@Update("update t_user set flag=#{flag} where id=#{id}")
	int updateFlag(@Param("flag")int flag,@Param("id") int id);
	//修改密码
	@Update("update t_user set password=#{password} where flag=1 and no=#{no}")
	public int updatePassword(User user);
	//查询用户的角色
	@Select("select r.* from t_role r left join t_userrole ur on r.id=ur.rid left join t_user u on u.id=ur.uid where u.id=#{id}")
	@ResultType(Role.class)
	List<Role> queryRole(int id);
	//查询用户对应的菜单权限
	@Select("select a.id,a.title,a.aicon icon  from t_authority a left join t_roleauthority ra on a.id=ra.aid left join t_userrole ur on ra.rid=ur.rid  where a.type=1 and a.parentId=0 and ur.uid=#{id}")
	@ResultType(MenuVo.class)
	List<MenuVo> queryMenu(int id);
	@Select("select * from t_authority where parentId=#{pid}")
	@ResultType(Authority.class)
	List<Authority> queryMenuChild(int pid);

	@Select("select u.*,r.info rinfo,r.name rname,r.id rid from t_user u left join t_userrole ur on u.id=ur.uid left join t_role r on ur.rid=r.id ${tj}")
	@ResultType(UserRoleVo.class)
	@Options(statementType = StatementType.STATEMENT)
	public List<UserRoleVo> queryAll(@Param("tj") String tj);

	//新增
	@Insert("insert into t_userrole(uid,rid) values(#{uid},#{rid})")
	int insertRole(@Param("uid") int uid, @Param("rid") int rid);
	//删除
	@Delete("delete from t_userrole where uid=#{uid}")
	int delRole(int uid);
	
	
}
