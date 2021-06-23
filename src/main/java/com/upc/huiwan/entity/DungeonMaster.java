package com.upc.huiwan.entity;

import java.io.Serializable;
import java.util.Date;

public class DungeonMaster implements Serializable {

    private static final long serialVersionUID=1L;

    private int id;
    private String name;
    private int sex;
    private String idCard;
    private String phone;
    private String selfDescription;
    private int belongBusinessId;
    private int status;
    private Date createTime;

    @Override
    public String toString() {
        return "DungeonMaster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", selfDescription='" + selfDescription + '\'' +
                ", belongBusinessId=" + belongBusinessId +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSelfDescription() {
        return selfDescription;
    }

    public void setSelfDescription(String selfDescription) {
        this.selfDescription = selfDescription;
    }

    public int getBelongBusinessId() {
        return belongBusinessId;
    }

    public void setBelongBusinessId(int belongBusinessId) {
        this.belongBusinessId = belongBusinessId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
