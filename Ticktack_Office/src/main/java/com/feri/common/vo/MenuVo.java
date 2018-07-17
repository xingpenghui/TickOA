package com.feri.common.vo;

import com.feri.domain.Authority;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/11 11:38
 *一级菜单和二级菜单
 */
public class MenuVo {
    private int id;
    private String title;
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    private List<Authority> childs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Authority> getChilds() {
        return childs;
    }

    public void setChilds(List<Authority> childs) {
        this.childs = childs;
    }
}
