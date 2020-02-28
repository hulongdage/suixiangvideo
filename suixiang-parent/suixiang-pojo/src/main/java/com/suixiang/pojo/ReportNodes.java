package com.suixiang.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "report_nodes")
public class ReportNodes {
    @Id
    private String id;

    /**
     * 被举报用户id
     */
    @Column(name = "reportUserId")
    private String reportuserid;
    /**
     * 被举报视频id
     */
    @Column(name = "reportVisionId")
    private String reportvisionid;

    /**
     * 类型标题，让用户选择，详情见 枚举
     */
    @Column(name = "reportTitle")
    private String reporttitle;

    /**
     * 内容
     */
    @Column(name = "reportContent")
    private String reportcontent;

    /**
     * 举报人的id
     */
    @Column(name = "userId")
    private String userid;

    /**
     * 举报时间
     */
    @Column(name = "creatTime")
    private Date creattime;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取被举报用户id
     *
     * @return reportUserId - 被举报用户id
     */
    public String getReportuserid() {
        return reportuserid;
    }

    /**
     * 设置被举报用户id
     *
     * @param reportuserid 被举报用户id
     */
    public void setReportuserid(String reportuserid) {
        this.reportuserid = reportuserid;
    }

    /**
     * @return reportVisionId
     */
    public String getReportvisionid() {
        return reportvisionid;
    }

    /**
     * @param reportvisionid
     */
    public void setReportvisionid(String reportvisionid) {
        this.reportvisionid = reportvisionid;
    }

    /**
     * 获取类型标题，让用户选择，详情见 枚举
     *
     * @return reportTitle - 类型标题，让用户选择，详情见 枚举
     */
    public String getReporttitle() {
        return reporttitle;
    }

    /**
     * 设置类型标题，让用户选择，详情见 枚举
     *
     * @param reporttitle 类型标题，让用户选择，详情见 枚举
     */
    public void setReporttitle(String reporttitle) {
        this.reporttitle = reporttitle;
    }

    /**
     * 获取内容
     *
     * @return reportContent - 内容
     */
    public String getReportcontent() {
        return reportcontent;
    }

    /**
     * 设置内容
     *
     * @param reportcontent 内容
     */
    public void setReportcontent(String reportcontent) {
        this.reportcontent = reportcontent;
    }

    /**
     * 获取举报人的id
     *
     * @return userId - 举报人的id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置举报人的id
     *
     * @param userid 举报人的id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取举报时间
     *
     * @return creatTime - 举报时间
     */
    public Date getCreattime() {
        return creattime;
    }

    /**
     * 设置举报时间
     *
     * @param creattime 举报时间
     */
    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }
}