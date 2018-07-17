package com.feri.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.feri.common.util.EncrypUtil;
import com.feri.common.vo.MenuVo;
import com.feri.common.vo.PageVo;
import com.feri.common.vo.UserRoleVo;
import com.feri.common.vo.UserVo;
import com.feri.domain.Role;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feri.common.util.MD5Utils;
import com.feri.dao.UserMapper;
import com.feri.domain.User;
import com.feri.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper dao;
	//成功 有对象 失败 null
	@Override
	public User queryByNo(String no, String password) {
		// TODO Auto-generated method stub
		User user=dao.queryByNo(no);
		if(user!=null) {
//			System.out.println("shur :"+MD5Utils.md5(password));
//			System.out.println("shujuk :"+user.getPassword());
			//if(Objects.equals(MD5Utils.md5(password), user.getPassword())){
			if(Objects.equals(EncrypUtil.md5Pass(password), user.getPassword())){
				return user;
			}
		}
		return null;
	}
	@Override
	public boolean updatePassword(User user) {
		// TODO Auto-generated method stub
		user.setPassword(MD5Utils.md5(user.getPassword()));
		return dao.updatePassword(user)>0;
	}
	@Override
	public boolean insert(User user) {
		// TODO Auto-generated method stub
		return dao.insert(user)>0;
	}
	@Override
	public boolean insertBach(List<User> list) {
		// TODO Auto-generated method stub
		try {
			for(User u:list) {
				dao.insert(u);
			}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
		
	}

	@Override
	public List<MenuVo> queryMenuByUid(int id) {
		List<MenuVo> menuVos=dao.queryMenu(id);
		for(MenuVo m:menuVos){
			m.setChilds(dao.queryMenuChild(m.getId()));
		}
		return menuVos;
	}

	@Override
	public List<Role> queryRole(int id) {
		return dao.queryRole(id);
	}

	@Override
	public PageVo<UserVo> queryAll(int page,int count,String no,int flag) {
        //PageHelper.startPage(page,count);
        StringBuffer where=new StringBuffer();
        where.append(" where flag="+flag);
        if(no.length()>0){
            where.append(" and u.no='"+no+"' or u.name='"+no+"'");
        }
		List<UserRoleVo> list=dao.queryAll(where.toString());
		List<UserVo> userVos=new ArrayList<>();
		for(UserRoleVo u:list){
			UserVo uv=indexOf(u.getId(),userVos);
			if(uv==null){
				uv=new UserVo(u.getId(),u.getNo(),u.getName(),u.getFlag());
				userVos.add(uv);
			}
			uv.getRole().add(u.getRinfo());
			uv.getRnames().add(u.getRname());
			uv.getRids().add(u.getRid());

		}
        PageVo<UserVo> pageVo=new PageVo<>();
		pageVo.setData(userVos);
		pageVo.setCount(pageVo.getData().size());
		pageVo.setCode(0);
		return pageVo;
	}
    @Override
    public boolean updateRle(int uid, int[] rids) {
	    //删除
        try {
            dao.delRole(uid);
            for (int id : rids) {
                dao.insertRole(uid, id);
            }
            return true;
        }catch (Exception e)
        {
        	e.printStackTrace();
            return false;
        }

    }
    private UserVo indexOf(int id,List<UserVo> list){
		for(UserVo u:list){
			if(u.getId()==id){
				return u;
			}
		}
		return null;
	}

    @Override
    public boolean updateFlag(int flag, int id) {
        return dao.updateFlag(flag,id)>0;
    }

}
