package com.feri.domain;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/5 15:20
 * 权限----资源
 */
public class Authority {
    private int id;
    private String title;
    private String aurl;
    private String aicon;
    private int type;//类型 1菜单 2具体的限制

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private int parentId;

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

    public String getAurl() {
        return aurl;
    }

    public void setAurl(String aurl) {
        this.aurl = aurl;
    }

    public String getAicon() {
        return aicon;
    }

    public void setAicon(String aicon) {
        this.aicon = aicon;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
