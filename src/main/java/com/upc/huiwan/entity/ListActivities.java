package com.upc.huiwan.entity;

import java.io.Serializable;
import java.util.Date;

public class ListActivities implements Serializable {

    private static final long serialVersionUID=1L;

    private int id;
    private int userId;
    private int scriptId;
    private int businessId;
    private int peopleAll;
    private int peopleExistence;
    private int peopleLack;
    private int status;
    private Date effectiveTime;
    private Date createTime;
    private Date playTime;
    private String pictureUrl;


    @Override
    public String toString() {
        return "ListActivities{" +
                "id=" + id +
                ", userId=" + userId +
                ", scriptId=" + scriptId +
                ", businessId=" + businessId +
                ", peopleAll=" + peopleAll +
                ", peopleExistence=" + peopleExistence +
                ", peopleLack=" + peopleLack +
                ", status=" + status +
                ", effectiveTime=" + effectiveTime +
                ", createTime=" + createTime +
                ", playTime=" + playTime +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScriptId() {
        return scriptId;
    }

    public void setScriptId(int scriptId) {
        this.scriptId = scriptId;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeopleAll() {
        return peopleAll;
    }

    public void setPeopleAll(int peopleAll) {
        this.peopleAll = peopleAll;
    }

    public int getPeopleExistence() {
        return peopleExistence;
    }

    public void setPeopleExistence(int peopleExistence) {
        this.peopleExistence = peopleExistence;
    }

    public int getPeopleLack() {
        return peopleLack;
    }

    public void setPeopleLack(int peopleLack) {
        this.peopleLack = peopleLack;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Date playTime) {
        this.playTime = playTime;
    }
}
