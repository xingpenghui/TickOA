package com.feri.common.vo;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/14 10:34
 */
public class TreeRoot {
    private int id;
    private String name;
    private List<TreeNode> children;

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

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
