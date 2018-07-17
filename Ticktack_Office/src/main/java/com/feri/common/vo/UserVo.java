package com.feri.common.vo;

import java.util.ArrayList;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/12 15:01
 */
public class UserVo {
    private int id;
    private String no;
    private String name;
    private List<String> role;
    private List<String> rnames;
    private List<Integer> rids;
    private int flag;

    public UserVo(int id, String no, String name, int flag) {
        this.id = id;
        this.no = no;
        this.name = name;
        this.flag = flag;
        role=new ArrayList<>();
        rnames=new ArrayList<>();
        rids=new ArrayList<>();
    }

    public UserVo() {
        role=new ArrayList<>();
        rnames=new ArrayList<>();
        rids=new ArrayList<>();
    }

    public List<String> getRnames() {
        return rnames;
    }

    public void setRnames(List<String> rnames) {
        this.rnames = rnames;
    }

    public List<Integer> getRids() {
        return rids;
    }

    public void setRids(List<Integer> rids) {
        this.rids = rids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }



    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("包含："+obj);

        return id==(int)obj;
    }
}
