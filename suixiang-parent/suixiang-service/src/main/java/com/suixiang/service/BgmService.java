package com.suixiang.service;

import java.util.List;

import com.suixiang.pojo.Backgroundmusic;

public interface BgmService {
	 /**
	  *  查询背景音乐列表
	  * @return  背景音乐列表
	  */
     public List<Backgroundmusic> queryBgmList();
     /**
      * 根据背景音乐id查询背景音乐
      * @param bgmId 背景音乐id
      * @return 背景音乐信息
      */
     public Backgroundmusic queryBgmById(String bgmId);
}
     
