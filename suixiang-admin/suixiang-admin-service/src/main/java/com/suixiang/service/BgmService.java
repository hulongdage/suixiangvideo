package com.suixiang.service;

import com.suixiang.pojo.Backgroundmusic;
import com.suixiang.utils.PagedResult;

public interface BgmService {
	/**
	 * 添加背景音乐
	 * @param bgm 背景音乐信息
	 */
  public void addBgm(Backgroundmusic bgm);
  /**
   * 查询背景音乐列表
   * @param currentPage  当前页
   * @param pageSize  每页显示条数
   * @return  背景音乐列表
   */
  public PagedResult queryBgmList(Integer currentPage,Integer pageSize);
  /**
   * 删除背景音乐
   * @param bgmId 背景音乐id
   */
  public void deleteBgm(String bgmId);
  /**
   * 查询是否存在bgm
   * @param bgmName bgm名称
   * @return true/false
   */
  public boolean queryIsExitBgm(String bgmName);
}
