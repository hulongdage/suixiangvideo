package com.suixiang.pojo;

import javax.persistence.*;

@Table(name = "user_fans")
public class UserFans {
    @Id
    private String id;

    /**
     * 用户id
     */
    @Column(name = "userId")
    private String userid;

    /**
     * 粉丝id
     */
    @Column(name = "fansId")
    private String fansid;

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
     * 获取用户id
     *
     * @return userId - 用户id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置用户id
     *
     * @param userid 用户id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取粉丝id
     *
     * @return fansId - 粉丝id
     */
    public String getFansid() {
        return fansid;
    }

    /**
     * 设置粉丝id
     *
     * @param fansid 粉丝id
     */
    public void setFansid(String fansid) {
        this.fansid = fansid;
    }
}