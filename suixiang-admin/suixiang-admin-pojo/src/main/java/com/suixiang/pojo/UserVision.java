package com.suixiang.pojo;

public class UserVision {
    private String id;

    private String userid;

    private String visionid;

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

    public String getVisionid() {
        return visionid;
    }

    public void setVisionid(String visionid) {
        this.visionid = visionid == null ? null : visionid.trim();
    }
}