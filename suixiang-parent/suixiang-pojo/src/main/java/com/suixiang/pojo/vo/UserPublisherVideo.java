package com.suixiang.pojo.vo;

import java.util.List;

public class UserPublisherVideo {
    public UserVO userVO;
    public boolean userLoveVideo;
    public List<String> danmuList;
    public Integer danmuNum;
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	public boolean isUserLoveVideo() {
		return userLoveVideo;
	}
	public void setUserLoveVideo(boolean userLoveVideo) {
		this.userLoveVideo = userLoveVideo;
	}
	public List<String> getDanmuList() {
		return danmuList;
	}
	public void setDanmuList(List<String> danmuList) {
		this.danmuList = danmuList;
	}
	public Integer getDanmuNum() {
		return danmuNum;
	}
	public void setDanmuNum(Integer danmuNum) {
		this.danmuNum = danmuNum;
	}
    
}
