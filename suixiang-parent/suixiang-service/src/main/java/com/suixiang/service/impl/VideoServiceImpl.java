package com.suixiang.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suixiang.mapper.CommentMapper;
import com.suixiang.mapper.CommentVOMapper;
import com.suixiang.mapper.SearchMapper;
import com.suixiang.mapper.UserMapper;
import com.suixiang.mapper.UserVisionMapper;
import com.suixiang.mapper.VisionMapper;
import com.suixiang.mapper.VisionVOMapper;
import com.suixiang.pojo.Comment;
import com.suixiang.pojo.Search;
import com.suixiang.pojo.UserVision;
import com.suixiang.pojo.Vision;
import com.suixiang.pojo.vo.CommentVO;
import com.suixiang.pojo.vo.VisionVO;
import com.suixiang.service.VideoService;
import com.suixiang.utils.PageResult;
import com.suixiang.utils.TimeAgoUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VisionMapper visionMapper;
    
    @Autowired
    private VisionVOMapper visionVOMapper;
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private SearchMapper searchMapper;
    
    @Autowired
    private UserVisionMapper userVisionMapper;
    
    @Autowired
    private CommentMapper commentMapper;
    
    @Autowired
    private CommentVOMapper commentVOMapper;
    
    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.REQUIRED)
	@Override
	public String saveVideo(Vision vision) {
		String id = sid.nextShort();
		vision.setId(id);
		visionMapper.insertSelective(vision);
		return id;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void updateVideo(String videoId, String coverPath) {
		Vision video = new Vision();
		video.setId(videoId);
		video.setCoverpath(coverPath);
		visionMapper.updateByPrimaryKeySelective(video);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public PageResult queryAllVideos(Integer currentPage, Integer pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		List<VisionVO> list = visionVOMapper.queryVisionVOList();
		PageInfo<VisionVO> pageInfo = new PageInfo<>(list);
		PageResult pageResult = new PageResult();
		pageResult.setCurrentPage(currentPage);
		pageResult.setRows(list);
		pageResult.setTotalPage(pageInfo.getPages());
		pageResult.setTotalSize(pageInfo.getTotal());
		return pageResult;
	}
	

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public PageResult searchVideo(Vision vision, Integer isSavedRecords, Integer currentPage, Integer pageSize) {
		
		String visionDesc = vision.getVisiondesc();
		String userId = vision.getUserid();
		if(isSavedRecords != null && isSavedRecords == 1) {
			Search searchContent = new Search();
			searchContent.setId(sid.nextShort());
			searchContent.setContent(visionDesc);
			searchMapper.insert(searchContent);
		}
		PageHelper.startPage(currentPage, pageSize);
		List<VisionVO> list = visionVOMapper.queryVisionVOListByDesc(visionDesc,userId);
		PageInfo<VisionVO> pageInfo = new PageInfo<>(list);
		PageResult pageResult = new PageResult();
		pageResult.setCurrentPage(currentPage);
		pageResult.setRows(list);
		pageResult.setTotalPage(pageInfo.getPages());
		pageResult.setTotalSize(pageInfo.getTotal());
		return pageResult;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<String> getHotWordList() {
		List<String> list = searchMapper.getHotWordList();
		return list;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void userLoveVideo(String userId, String videoId, String publisherId) {
		UserVision userVision = new UserVision();
		String id = sid.nextShort();
		userVision.setId(id);
		userVision.setUserid(userId);
		userVision.setVisionid(videoId);
		userVisionMapper.insert(userVision);
		visionVOMapper.increaseVideoLoveCount(videoId);
		userMapper.increaseUserLoveCount(publisherId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void userDisLoveVideo(String userId, String videoId, String publisherId) {
		Example example = new Example(UserVision.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("userid", userId);
		criteria.andEqualTo("visionid", videoId);
		userVisionMapper.deleteByExample(example);
		visionVOMapper.decreaseVideoLoveCount(videoId);
		userMapper.decreaseUserLoveCount(publisherId);
		
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public PageResult queryMyLikeVideos(String userId, Integer currentPage, Integer pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		List<VisionVO> list = visionVOMapper.queryMyLikeVideos(userId);				
		PageInfo<VisionVO> pageList = new PageInfo<>(list);		
		PageResult pageResult = new PageResult();
		pageResult.setTotalPage(pageList.getPages());
		pageResult.setRows(list);
		pageResult.setCurrentPage(currentPage);
		pageResult.setTotalSize(pageList.getTotal());		
		return pageResult;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public PageResult queryMyFollowVideos(String userId, Integer currentPage, Integer pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		List<VisionVO> list = visionVOMapper.queryMyFollowVideos(userId);			
		PageInfo<VisionVO> pageList = new PageInfo<>(list);		
		PageResult pageResult = new PageResult();
		pageResult.setTotalPage(pageList.getPages());
		pageResult.setRows(list);
		pageResult.setCurrentPage(currentPage);
		pageResult.setTotalSize(pageList.getTotal());		
		return pageResult;		
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<VisionVO> showMyFollowList(String userId) {
		List<VisionVO> list = visionVOMapper.queryMyFollowVideos(userId);					
		return list;		
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<VisionVO> showMyLikeList(String userId) {
		List<VisionVO> list = visionVOMapper.queryMyLikeVideos(userId);			
		return list;		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void saveComment(Comment comment) {
		String id = sid.nextShort();
		comment.setId(id);
		comment.setCreattime(new Date());
		commentMapper.insert(comment);
		
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public PageResult getAllComments(String videoId, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
		
		List<CommentVO> list = commentVOMapper.queryComments(videoId);
		
			for (CommentVO c : list) {
				String timeAgo = TimeAgoUtils.format(c.getCreattime());
				c.setTimeAgoStr(timeAgo);
			}
		
		PageInfo<CommentVO> pageList = new PageInfo<>(list);		
		PageResult pageResult = new PageResult();
		pageResult.setTotalPage(pageList.getPages());
		pageResult.setRows(list);
		pageResult.setCurrentPage(page);
		pageResult.setTotalSize(pageList.getTotal());		
		return pageResult;
		
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<VisionVO> queryHotVideos() {		
		List<VisionVO> list = visionVOMapper.queryHotVisionVOList();
		List<VisionVO> list2 = new ArrayList<>();
		if(list != null && list.size()>=3) {
			for(int i = 0;i < 3;i++) {
				list2.add(list.get(i));
			}			
		}
		return list2;
	}
    
	
	
}
