package com.feri.common.vo;

import java.util.ArrayList;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/12 11:42
 */
public class EchartsVo {
    private String id;//
    private List<String> datax;//水平值
    private List<String> datas1;//开始时间
    private List<String> datas2;//结束时间
    private List<String> datas3;//差值

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getDatax() {
        return datax;
    }

    public void setDatax(List<String> datax) {
        this.datax = datax;
    }

    public List<String> getDatas1() {
        return datas1;
    }

    public void setDatas1(List<String> datas1) {
        this.datas1 = datas1;
    }

    public List<String> getDatas2() {
        return datas2;
    }

    public void setDatas2(List<String> datas2) {
        this.datas2 = datas2;
    }

    public List<String> getDatas3() {
        return datas3;
    }

    public void setDatas3(List<String> datas3) {
        this.datas3 = datas3;
    }

    public EchartsVo() {
        datax=new ArrayList<>();
        datas1=new ArrayList<>();
        datas2=new ArrayList<>();
        datas3=new ArrayList<>();
    }
}
