package com.feri.service.impl;

import com.feri.common.vo.TreeNode;
import com.feri.common.vo.TreeRoot;
import com.feri.common.vo.UserVo;
import com.feri.dao.RoleMapper;
import com.feri.domain.Authority;
import com.feri.domain.Role;
import com.feri.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/6 14:39
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper mapper;
    @Override
    public int save(Role role) {
        return mapper.save(role);
    }

    @Override
    public List<Role> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public boolean updateAuth(int rid, int[] aids) {
        try{
            mapper.delAuth(rid);
            for(int i=0;i<aids.length;i++){
                mapper.insertAuth(rid,aids[i]);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Authority> queryAuthority(int rid) {
        return mapper.queryAuthority(rid);
    }

    @Override
    public List<TreeRoot> queryAuthoritys() {
        List<TreeNode> list= mapper.queryAuthoritys();
        List<TreeRoot> roots=new ArrayList<>();
        for(TreeNode n:list){
            TreeRoot root ;
            if(n.getParentid()==0) {
                root= indexOf(n.getId(), roots);
                if (root == null) {
                    root = new TreeRoot();
                    root.setId(n.getId());
                    root.setName(n.getName());
                    root.setChildren(new ArrayList<>());
                }
            }else{
                root=indexOf(n.getParentid(),roots);
                root.getChildren().add(n);
            }
        }
        return roots;
    }
    private TreeRoot indexOf(int id, List<TreeRoot> list){
        for(TreeRoot u:list){
            if(u.getId()==id){
                return u;
            }
        }
        return null;
    }

}
