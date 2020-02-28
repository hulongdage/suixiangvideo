package com.suixiang.pojo;

public class UserFans {
    private String id;

    private String userid;

    private String fansid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getFansid() {
        return fansid;
    }

    public void setFansid(String fansid) {
        this.fansid = fansid == null ? null : fansid.trim();
    }
}