package com.suixiang.service;

import java.util.List;

import com.suixiang.pojo.ReportNodes;
import com.suixiang.pojo.User;

public interface UserService {
	 /**
	  *  查询用户名是否存在
	  * @param username  用户名
	  * @return  true/false
	  */
     public boolean queryUsernameIsExit(String username);
     /**
      *  保存用户
      * @param user  用户信息
      */
     public void saveUser(User user);
     /**
      * 根据用户名查询用户信息
      * @param username  用户名
      * @return 用户信息
      */
     public User queryUserByUsername(String username);
     /**
      * 更新用户信息
      * @param user  用户信息
      */
     public void updateUserDetail(User user);
     /**
      * 根据用户id查询用户信息
      * @param userId 用户id
      * @return 用户信息
      */
     public User queryUserDetailById(String userId);
     /**
      * 用户是否喜欢此视频
      * @param userId 用户id
      * @param videoId 视频id
      * @return true/false
      */
     public boolean userLoveVideo(String userId,String videoId);
     /**
      * 建立用户和粉丝的关系
      * @param userId 用户id
      * @param fansId 粉丝id
      */
     public void addUserFansRelation(String userId,String fansId);
     /**
      * 删除用户和粉丝的关系
      * @param userId 用户id
      * @param fansId 粉丝id
      */
     public void delUserFansRelation(String userId,String fansId);
     /**
      * 查询用户是否已关注视频发布者
      * @param userId 用户id
      * @param fansId 粉丝id
      * @return true/false
      */
     public boolean isConcerned(String userId,String fansId);
     /**
      * 举报视频
      * @param reportNodes 举报信息
      */
	 public void tipUser(ReportNodes reportNodes);
	 /**
	  * 获取弹幕列表
	  * @param videoId 视频id
	  * @return 弹幕列表
	  */
	 public List<String> getDanmuList(String videoId);
}
