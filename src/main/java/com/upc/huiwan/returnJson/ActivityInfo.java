package com.upc.huiwan.returnJson;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ActivityInfo {

    private int people_all;
    private int people_existence;
    private int people_lack;
    private List<Map<String, Object>> list;

    public ActivityInfo(int people_all,int people_existence,int people_lack, List<Map<String, Object>> list){
        this.people_all=people_all;
        this.people_existence=people_existence;
        this.people_lack=people_lack;
        this.list=list;
    }


    public int getPeople_all() {
        return people_all;
    }

    public void setPeople_all(int people_all) {
        this.people_all = people_all;
    }

    public int getPeople_existence() {
        return people_existence;
    }

    public void setPeople_existence(int people_existence) {
        this.people_existence = people_existence;
    }

    public int getPeople_lack() {
        return people_lack;
    }

    public void setPeople_lack(int people_lack) {
        this.people_lack = people_lack;
    }

    public List<Map<String, Object>> getList() {
        return list;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }
}
