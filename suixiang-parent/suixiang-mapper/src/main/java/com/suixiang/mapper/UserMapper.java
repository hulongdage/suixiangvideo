package com.suixiang.mapper;

import com.suixiang.pojo.User;
import com.suixiang.utils.MyMapper;

public interface UserMapper extends MyMapper<User> {
	/**
	 * 增加用户被喜欢的总次数
	 * @param userId 用户id
	 */
	public void increaseUserLoveCount(String userId);
	/**
	 * 减少用户被喜欢的总次数
	 * @param userId 用户id
	 */
	public void decreaseUserLoveCount(String userId);
	/**
	 * 增加用户的粉丝数量
	 * @param userId  用户id
	 */
	public void increaseFansCount(String userId);
	/**
	 * 减少用户的粉丝数量
	 * @param userId  用户id
	 */
	public void decreaseFansCount(String userId);
	/**
	 * 增加用户的关注数量
	 * @param userId  用户id
	 */
	public void increaseConCount(String userId);
	/**
	 * 减少用户的关注数量
	 * @param userId  用户id
	 */
	public void decreaseConCount(String userId);
}