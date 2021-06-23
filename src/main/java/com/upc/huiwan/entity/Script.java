package com.upc.huiwan.entity;

import java.io.Serializable;
import java.util.Date;

public class Script implements Serializable {

    private static final long serialVersionUID=1L;

    private int id;
    private String name;
    private int numbers;
    private int status;
    private int grade;
    private int price;
    private int belongBusinessId;
    private String synopsis;
    private Date createTime;
    private String pictureUrl;

    @Override
    public String toString() {
        return "Script{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numbers=" + numbers +
                ", status=" + status +
                ", grade=" + grade +
                ", price=" + price +
                ", belongBusinessId=" + belongBusinessId +
                ", synopsis='" + synopsis + '\'' +
                ", createTime=" + createTime +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getBelongBusinessId() {
        return belongBusinessId;
    }

    public void setBelongBusinessId(int belongBusinessId) {
        this.belongBusinessId = belongBusinessId;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
