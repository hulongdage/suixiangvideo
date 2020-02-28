package com.suixiang.pojo;

import java.util.Date;

public class ReportNodes {
    private String id;

    private String reportuserid;

    private String reportvisionid;

    private String reporttitle;

    private String reportcontent;

    private String userid;

    private Date creattime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getReportuserid() {
        return reportuserid;
    }

    public void setReportuserid(String reportuserid) {
        this.reportuserid = reportuserid == null ? null : reportuserid.trim();
    }

    public String getReportvisionid() {
        return reportvisionid;
    }

    public void setReportvisionid(String reportvisionid) {
        this.reportvisionid = reportvisionid == null ? null : reportvisionid.trim();
    }

    public String getReporttitle() {
        return reporttitle;
    }

    public void setReporttitle(String reporttitle) {
        this.reporttitle = reporttitle == null ? null : reporttitle.trim();
    }

    public String getReportcontent() {
        return reportcontent;
    }

    public void setReportcontent(String reportcontent) {
        this.reportcontent = reportcontent == null ? null : reportcontent.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }
}