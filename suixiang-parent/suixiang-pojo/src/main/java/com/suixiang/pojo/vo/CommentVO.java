package com.suixiang.pojo.vo;

import java.util.Date;

public class CommentVO {
    private String id;

    /**
     * 视频id
     */
    private String visionid;

    /**
     * 留言者，评论的用户id
     */
    private String fromuserid;

    private Date creattime;

    /**
     * 评论内容
     */
    private String comment;
    
    private String headimage;
    private String nickname;
    private String toNickname;
    private String timeAgoStr;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVisionid() {
		return visionid;
	}
	public void setVisionid(String visionid) {
		this.visionid = visionid;
	}
	public String getFromuserid() {
		return fromuserid;
	}
	public void setFromuserid(String fromuserid) {
		this.fromuserid = fromuserid;
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
		this.comment = comment;
	}
	public String getHeadimage() {
		return headimage;
	}
	public void setHeadimage(String headimage) {
		this.headimage = headimage;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getToNickname() {
		return toNickname;
	}
	public void setToNickname(String toNickname) {
		this.toNickname = toNickname;
	}
	public String getTimeAgoStr() {
		return timeAgoStr;
	}
	public void setTimeAgoStr(String timeAgoStr) {
		this.timeAgoStr = timeAgoStr;
	}
    
    
    
    
    
}