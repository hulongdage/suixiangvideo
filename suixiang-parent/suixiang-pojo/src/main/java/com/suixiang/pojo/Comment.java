package com.suixiang.pojo;

import java.util.Date;
import javax.persistence.*;

public class Comment {
    @Id
    private String id;

    @Column(name = "fCommentId")
    private String fcommentid;

    @Column(name = "toUserId")
    private String touserid;

    /**
     * 视频id
     */
    @Column(name = "visionId")
    private String visionid;

    /**
     * 留言者，评论的用户id
     */
    @Column(name = "fromUserId")
    private String fromuserid;

    @Column(name = "creatTime")
    private Date creattime;

    /**
     * 评论内容
     */
    private String comment;

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
     * @return fCommentId
     */
    public String getFcommentid() {
        return fcommentid;
    }

    /**
     * @param fcommentid
     */
    public void setFcommentid(String fcommentid) {
        this.fcommentid = fcommentid;
    }

    /**
     * @return toUserId
     */
    public String getTouserid() {
        return touserid;
    }

    /**
     * @param touserid
     */
    public void setTouserid(String touserid) {
        this.touserid = touserid;
    }

    /**
     * 获取视频id
     *
     * @return visionId - 视频id
     */
    public String getVisionid() {
        return visionid;
    }

    /**
     * 设置视频id
     *
     * @param visionid 视频id
     */
    public void setVisionid(String visionid) {
        this.visionid = visionid;
    }

    /**
     * 获取留言者，评论的用户id
     *
     * @return fromUserId - 留言者，评论的用户id
     */
    public String getFromuserid() {
        return fromuserid;
    }

    /**
     * 设置留言者，评论的用户id
     *
     * @param fromuserid 留言者，评论的用户id
     */
    public void setFromuserid(String fromuserid) {
        this.fromuserid = fromuserid;
    }

    /**
     * @return creatTime
     */
    public Date getCreattime() {
        return creattime;
    }

    /**
     * @param creattime
     */
    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    /**
     * 获取评论内容
     *
     * @return comment - 评论内容
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置评论内容
     *
     * @param comment 评论内容
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}