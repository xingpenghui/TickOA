package com.feri.domain;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/5 15:20
 * 角色---
 */
//@Entity
//@Table(name = "t_role")
public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(length = 20)
    private String name;
//    @Column(length = 100)
    private String info;//备注信息
    private int parentId;

//    @ManyToMany
//    @JoinTable(name = "t_roleauthority",joinColumns = {@JoinColumn(name = "rid")},inverseJoinColumns = {@JoinColumn(name = "aid")})
//    @Fetch(FetchMode.JOIN)
    private List<Authority> authoritys;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<Authority> getAuthoritys() {
        return authoritys;
    }

    public void setAuthoritys(List<Authority> authoritys) {
        this.authoritys = authoritys;
    }
}
