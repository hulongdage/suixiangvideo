package com.suixiang.service.impl;

import java.util.List;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suixiang.mapper.ReportNodesVOMapper;
import com.suixiang.mapper.VisionMapper;
import com.suixiang.pojo.Vision;
import com.suixiang.pojo.vo.Reports;
import com.suixiang.service.VideoService;
import com.suixiang.utils.PagedResult;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VisionMapper videosMapper;
	
	
	@Autowired
	private ReportNodesVOMapper reportNodesVOMapper;
	
	@Override
	public PagedResult queryReportList(Integer page, Integer pageSize) {

		PageHelper.startPage(page, pageSize);

		List<Reports> reportsList = reportNodesVOMapper.selectAllVideoReport();

		PageInfo<Reports> pageList = new PageInfo<Reports>(reportsList);

		PagedResult grid = new PagedResult();
		grid.setTotal(pageList.getPages());
		grid.setRows(reportsList);
		grid.setPage(page);
		grid.setRecords(pageList.getTotal());

		return grid;
	}

	@Override
	public void updateVideoStatus(String videoId, Integer status) {
		
		Vision video = new Vision();
		video.setId(videoId);
		video.setStatus(status);
		videosMapper.updateByPrimaryKeySelective(video);
	}



}
