package com.suixiang.mapper;

import java.util.List;

import com.suixiang.pojo.Comment;
import com.suixiang.pojo.vo.CommentVO;
import com.suixiang.utils.MyMapper;



public interface CommentVOMapper extends MyMapper<Comment> {
	
	public List<CommentVO> queryComments(String videoId);
}