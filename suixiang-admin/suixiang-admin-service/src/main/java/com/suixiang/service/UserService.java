package com.suixiang.service;

import com.suixiang.pojo.User;
import com.suixiang.utils.PagedResult;

public interface UserService {
    /**
     * 查询用户列表
     * @param user 用户信息
     * @param page 当前页
     * @param pageSize 每页显示条数
     * @return
     */
	public PagedResult queryUserList(User user, Integer page, Integer pageSize);
	/**
	 * 查询是否存在管理员
	 * @param username 用户名
	 * @param password 密码
	 * @return true/false
	 */
	public boolean queryIsExitAdmin(String username, String password);
	
}
