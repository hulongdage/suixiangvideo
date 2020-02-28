package com.suixiang.pojo;

import java.util.Date;

public class Vision {
    private String id;

    private String userid;

    private String audioid;

    private String visiondesc;

    private String visionpath;

    private Float visionseconds;

    private Integer visionwidth;

    private Integer visionheight;

    private String coverpath;

    private Long lovecount;

    private Integer status;

    private Date creattime;

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

    public String getAudioid() {
        return audioid;
    }

    public void setAudioid(String audioid) {
        this.audioid = audioid == null ? null : audioid.trim();
    }

    public String getVisiondesc() {
        return visiondesc;
    }

    public void setVisiondesc(String visiondesc) {
        this.visiondesc = visiondesc == null ? null : visiondesc.trim();
    }

    public String getVisionpath() {
        return visionpath;
    }

    public void setVisionpath(String visionpath) {
        this.visionpath = visionpath == null ? null : visionpath.trim();
    }

    public Float getVisionseconds() {
        return visionseconds;
    }

    public void setVisionseconds(Float visionseconds) {
        this.visionseconds = visionseconds;
    }

    public Integer getVisionwidth() {
        return visionwidth;
    }

    public void setVisionwidth(Integer visionwidth) {
        this.visionwidth = visionwidth;
    }

    public Integer getVisionheight() {
        return visionheight;
    }

    public void setVisionheight(Integer visionheight) {
        this.visionheight = visionheight;
    }

    public String getCoverpath() {
        return coverpath;
    }

    public void setCoverpath(String coverpath) {
        this.coverpath = coverpath == null ? null : coverpath.trim();
    }

    public Long getLovecount() {
        return lovecount;
    }

    public void setLovecount(Long lovecount) {
        this.lovecount = lovecount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }
}