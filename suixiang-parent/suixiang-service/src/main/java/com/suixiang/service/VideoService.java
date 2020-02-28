package com.suixiang.service;

import java.util.List;

import com.suixiang.pojo.Comment;
import com.suixiang.pojo.Vision;
import com.suixiang.pojo.vo.VisionVO;
import com.suixiang.utils.PageResult;

public interface VideoService {
	 /**
	  * 保存视频信息
	  * @param vision 视频信息
	  */
	 public String saveVideo(Vision vision);
	 /**
	  * 更新视频信息
	  * @param videoId  视频id
	  * @param coverPath  封面路径
	  */
	 public void updateVideo(String videoId,String coverPath);  
	 /**
	  * 查询视频列表
	  * @param currentPage 当前页
	  * @param pageSize 每页显示条数
	  * @return 分页查询结果
	  */
	 public PageResult queryAllVideos(Integer currentPage,Integer pageSize);
	 /**
	  * 查询热门视频(前三条)
	  * @return 分页查询结果
	  */
	 public List<VisionVO> queryHotVideos();
	 /**
	  * 根据查询词查询视频列表
	  * @param vision 视频信息
	  * @param isSavedRecords 是否保存搜索记录  1--保存   0或空--不保存
	  * @param currentPage 当前页
	  * @param pageSize 每页显示条数
	  * @return 分页查询结果
	  */
	 public PageResult searchVideo(Vision vision,Integer isSavedRecords,Integer currentPage,Integer pageSize);
	 /**
	  * 查询热点词列表
	  * @return 热点词列表
	  */
	 public List<String> getHotWordList();
	 /**
	  * 用户点赞视频
	  * @param userId 用户id
	  * @param videoId 视频id
	  * @param publisherId 发布者id
	  */
	 public void userLoveVideo(String userId,String videoId,String publisherId);
	 /**
	  * 用户取消点赞视频
	  * @param userId 用户id
	  * @param videoId 视频id
	  * @param publisherId 发布者id
	  */
	 public void userDisLoveVideo(String userId,String videoId,String publisherId);
	 /**
	  * 查询我点赞的视频列表
	  * @param userId 用户id
	  * @param currentPage 当前页
	  * @param pageSize 每页显示条数
	  * @return 分页查询结果
	  */
	 public PageResult queryMyLikeVideos(String userId, Integer currentPage, Integer pageSize);
	 public List<VisionVO> showMyLikeList(String userId);
	 /**
	  * 查询我关注的人视频列表
	  * @param userId 用户id
	  * @param currentPage 当前页
	  * @param pageSize 每页显示条数
	  * @return 分页查询结果
	  */
	 public PageResult queryMyFollowVideos(String userId, Integer currentPage, Integer pageSize);
	 public List<VisionVO> showMyFollowList(String userId);
	 public void saveComment(Comment comment);
	 public PageResult getAllComments(String videoId, Integer page, Integer pageSize);
}
     
