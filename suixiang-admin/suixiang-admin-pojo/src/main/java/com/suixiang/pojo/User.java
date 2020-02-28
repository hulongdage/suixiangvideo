package com.suixiang.pojo;

public class User {
    private String id;

    private String username;

    private String password;

    private String headimage;

    private String nickname;

    private Integer countfan;

    private Integer countcon;

    private Integer countlove;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage == null ? null : headimage.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getCountfan() {
        return countfan;
    }

    public void setCountfan(Integer countfan) {
        this.countfan = countfan;
    }

    public Integer getCountcon() {
        return countcon;
    }

    public void setCountcon(Integer countcon) {
        this.countcon = countcon;
    }

    public Integer getCountlove() {
        return countlove;
    }

    public void setCountlove(Integer countlove) {
        this.countlove = countlove;
    }
}