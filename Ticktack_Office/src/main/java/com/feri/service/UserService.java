package com.feri.service;

import java.util.List;

import com.feri.common.vo.MenuVo;
import com.feri.common.vo.PageVo;
import com.feri.common.vo.UserRoleVo;
import com.feri.common.vo.UserVo;
import com.feri.domain.Role;
import com.feri.domain.User;


public interface UserService {

	//登录
	public User queryByNo(String no,String password);
	//修改密码
	public boolean updatePassword(User user);
	//新增
	public boolean insert(User user);
	//批量新增
	public boolean insertBach(List<User> list);
	//包含一级和对应的二级菜单
	List<MenuVo> queryMenuByUid(int id);
	//查询用户的角色
	List<Role> queryRole(int id);
    PageVo<UserVo> queryAll(int page, int count,String no,int flag);
    //更改角色
    boolean updateRle(int uid,int[] rids);
    boolean updateFlag(int flag,int id);
}
