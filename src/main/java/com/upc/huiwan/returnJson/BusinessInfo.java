package com.upc.huiwan.returnJson;

public class BusinessInfo {

    private String name;
    private String avatar = "/avatar2.jpg";
    private Permissions role;
    public BusinessInfo(String name,Permissions role){
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return "BusinessInfo{" +
                "name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", role=" + role +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Permissions getRole() {
        return role;
    }

    public void setRole(Permissions role) {
        this.role = role;
    }
}
