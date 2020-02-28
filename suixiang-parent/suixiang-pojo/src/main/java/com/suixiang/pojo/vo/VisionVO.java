package com.suixiang.pojo.vo;

import java.util.Date;

public class VisionVO {
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
    private String headImage;
    private String nickname;
    
    public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

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
     * 获取发布者id
     *
     * @return userId - 发布者id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置发布者id
     *
     * @param userid 发布者id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取用户使用音频的信息
     *
     * @return audioId - 用户使用音频的信息
     */
    public String getAudioid() {
        return audioid;
    }

    /**
     * 设置用户使用音频的信息
     *
     * @param audioid 用户使用音频的信息
     */
    public void setAudioid(String audioid) {
        this.audioid = audioid;
    }

    /**
     * 获取视频描述
     *
     * @return visionDesc - 视频描述
     */
    public String getVisiondesc() {
        return visiondesc;
    }

    /**
     * 设置视频描述
     *
     * @param visiondesc 视频描述
     */
    public void setVisiondesc(String visiondesc) {
        this.visiondesc = visiondesc;
    }

    /**
     * 获取视频存放的路径
     *
     * @return visionPath - 视频存放的路径
     */
    public String getVisionpath() {
        return visionpath;
    }

    /**
     * 设置视频存放的路径
     *
     * @param visionpath 视频存放的路径
     */
    public void setVisionpath(String visionpath) {
        this.visionpath = visionpath;
    }

    /**
     * 获取视频秒数
     *
     * @return visionSeconds - 视频秒数
     */
    public Float getVisionseconds() {
        return visionseconds;
    }

    /**
     * 设置视频秒数
     *
     * @param visionseconds 视频秒数
     */
    public void setVisionseconds(Float visionseconds) {
        this.visionseconds = visionseconds;
    }

    /**
     * 获取视频宽度
     *
     * @return visionWidth - 视频宽度
     */
    public Integer getVisionwidth() {
        return visionwidth;
    }

    /**
     * 设置视频宽度
     *
     * @param visionwidth 视频宽度
     */
    public void setVisionwidth(Integer visionwidth) {
        this.visionwidth = visionwidth;
    }

    /**
     * 获取视频高度
     *
     * @return visionHeight - 视频高度
     */
    public Integer getVisionheight() {
        return visionheight;
    }

    /**
     * 设置视频高度
     *
     * @param visionheight 视频高度
     */
    public void setVisionheight(Integer visionheight) {
        this.visionheight = visionheight;
    }

    /**
     * 获取视频封面图
     *
     * @return coverPath - 视频封面图
     */
    public String getCoverpath() {
        return coverpath;
    }

    /**
     * 设置视频封面图
     *
     * @param coverpath 视频封面图
     */
    public void setCoverpath(String coverpath) {
        this.coverpath = coverpath;
    }

    /**
     * 获取喜欢/赞美的数量
     *
     * @return loveCount - 喜欢/赞美的数量
     */
    public Long getLovecount() {
        return lovecount;
    }

    /**
     * 设置喜欢/赞美的数量
     *
     * @param lovecount 喜欢/赞美的数量
     */
    public void setLovecount(Long lovecount) {
        this.lovecount = lovecount;
    }

    /**
     * 获取视频状态：
1、发布成功
2、禁止播放，管理员操作
     *
     * @return status - 视频状态：
1、发布成功
2、禁止播放，管理员操作
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置视频状态：
1、发布成功
2、禁止播放，管理员操作
     *
     * @param status 视频状态：
1、发布成功
2、禁止播放，管理员操作
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return creatTime - 创建时间
     */
    public Date getCreattime() {
        return creattime;
    }

    /**
     * 设置创建时间
     *
     * @param creattime 创建时间
     */
    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

	@Override
	public String toString() {
		return "VisionVO [id=" + id + ", userid=" + userid + ", audioid=" + audioid + ", visiondesc=" + visiondesc
				+ ", visionpath=" + visionpath + ", visionseconds=" + visionseconds + ", visionwidth=" + visionwidth
				+ ", visionheight=" + visionheight + ", coverpath=" + coverpath + ", lovecount=" + lovecount
				+ ", status=" + status + ", creattime=" + creattime + ", headImage=" + headImage + ", nickname="
				+ nickname + "]";
	}
    
    
}