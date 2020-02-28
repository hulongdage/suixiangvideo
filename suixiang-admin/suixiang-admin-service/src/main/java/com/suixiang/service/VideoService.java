package com.suixiang.service;

import com.suixiang.utils.PagedResult;

public interface VideoService {

	
	public PagedResult queryReportList(Integer page, Integer pageSize);
	
	public void updateVideoStatus(String videoId, Integer status);
}
