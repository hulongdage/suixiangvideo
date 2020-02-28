package com.suixiang.pojo;

import java.util.Date;

public class Comment {
    private String id;

    private String fcommentid;

    private String touserid;

    private String visionid;

    private String fromuserid;

    private Date creattime;

    private String comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFcommentid() {
        return fcommentid;
    }

    public void setFcommentid(String fcommentid) {
        this.fcommentid = fcommentid == null ? null : fcommentid.trim();
    }

    public String getTouserid() {
        return touserid;
    }

    public void setTouserid(String touserid) {
        this.touserid = touserid == null ? null : touserid.trim();
    }

    public String getVisionid() {
        return visionid;
    }

    public void setVisionid(String visionid) {
        this.visionid = visionid == null ? null : visionid.trim();
    }

    public String getFromuserid() {
        return fromuserid;
    }

    public void setFromuserid(String fromuserid) {
        this.fromuserid = fromuserid == null ? null : fromuserid.trim();
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}