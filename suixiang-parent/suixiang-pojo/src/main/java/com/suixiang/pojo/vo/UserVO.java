package com.suixiang.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="用户对象",description="用户对象")
public class UserVO {
	@ApiModelProperty(hidden=true)
    private String id;
	
	@ApiModelProperty(hidden=true)
    private String usertoken;
	
	private boolean isConcern;

    public boolean isConcern() {
		return isConcern;
	}

	public void setConcern(boolean isConcern) {
		this.isConcern = isConcern;
	}

	/**
     * 用户名
     */
    @ApiModelProperty(value="用户名",name="username",example="hulong",required=true)
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value="密码",name="password",example="123456",required=true)
    private String password;

    /**
     * 用户头像照片
     */
    @ApiModelProperty(hidden=true)
    private String headimage;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 粉丝数量
     */
    @ApiModelProperty(hidden=true)
    private Integer countfan;

    /**
     * 关注人数量
     */
    @ApiModelProperty(hidden=true)
    private Integer countcon;

    /**
     * 收到的赞美/收藏 的数量
     */
    @ApiModelProperty(hidden=true)
    private Integer countlove;

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
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户头像照片
     *
     * @return headImage - 用户头像照片
     */
    public String getHeadimage() {
        return headimage;
    }

    /**
     * 设置用户头像照片
     *
     * @param headimage 用户头像照片
     */
    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取粉丝数量
     *
     * @return countFan - 粉丝数量
     */
    public Integer getCountfan() {
        return countfan;
    }

    /**
     * 设置粉丝数量
     *
     * @param countfan 粉丝数量
     */
    public void setCountfan(Integer countfan) {
        this.countfan = countfan;
    }

    /**
     * 获取关注人数量
     *
     * @return countCon - 关注人数量
     */
    public Integer getCountcon() {
        return countcon;
    }

    /**
     * 设置关注人数量
     *
     * @param countcon 关注人数量
     */
    public void setCountcon(Integer countcon) {
        this.countcon = countcon;
    }

    /**
     * 获取收到的赞美/收藏 的数量
     *
     * @return countLove - 收到的赞美/收藏 的数量
     */
    public Integer getCountlove() {
        return countlove;
    }

    /**
     * 设置收到的赞美/收藏 的数量
     *
     * @param countlove 收到的赞美/收藏 的数量
     */
    public void setCountlove(Integer countlove) {
        this.countlove = countlove;
    }

	public String getUsertoken() {
		return usertoken;
	}

	public void setUsertoken(String usertoken) {
		this.usertoken = usertoken;
	}
    
}