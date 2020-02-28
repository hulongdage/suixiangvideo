package com.suixiang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suixiang.pojo.Vision;
import com.suixiang.pojo.vo.VisionVO;
import com.suixiang.utils.MyMapper;

public interface VisionVOMapper extends MyMapper<Vision> {
	/**
	 * 查询自定义视频类列表
	 * @return 自定义视频类列表
	 */
	public List<VisionVO> queryVisionVOList();
	/**
	 * 查询热门视频列表
	 * @return  热门视频列表
	 */
	public List<VisionVO> queryHotVisionVOList();
	/**
	 * 根据视频描述查询自定义视频类列表
	 * @param visionDesc 视频描述
	 * @return 视频列表
	 */
	public List<VisionVO> queryVisionVOListByDesc(@Param("visionDesc") String visionDesc,
			@Param("userId") String userId);
	/**
	 * 增加视频被喜欢的总次数
	 * @param videoId 视频id
	 */
	public void increaseVideoLoveCount(String videoId);
	/**
	 * 减少视频被喜欢的总次数
	 * @param videoId 视频id
	 */
	public void decreaseVideoLoveCount(String videoId);
	/**
	 * 查询用户所有点赞过的视频
	 * @param userId 用户id
	 * @return 视频列表
	 */
	public List<VisionVO> queryMyLikeVideos(@Param("userId") String userId);
	/**
	 * 查询用户关注的人的视频列表
	 * @param userId 用户id
	 * @return 视频列表
	 */
	public List<VisionVO> queryMyFollowVideos(String userId);
}