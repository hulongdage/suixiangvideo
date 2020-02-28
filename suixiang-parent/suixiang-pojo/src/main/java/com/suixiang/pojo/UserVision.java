package com.suixiang.pojo;

import javax.persistence.*;

@Table(name = "user_vision")
public class UserVision {
    @Id
    private String id;

    /**
     * 用户
     */
    @Column(name = "userId")
    private String userid;

    /**
     * 视频
     */
    @Column(name = "visionId")
    private String visionid;

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
     * 获取用户
     *
     * @return userId - 用户
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置用户
     *
     * @param userid 用户
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取视频
     *
     * @return visionId - 视频
     */
    public String getVisionid() {
        return visionid;
    }

    /**
     * 设置视频
     *
     * @param visionid 视频
     */
    public void setVisionid(String visionid) {
        this.visionid = visionid;
    }
}