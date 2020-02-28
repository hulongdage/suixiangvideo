package com.suixiang.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.suixiang.mapper.CommentMapper;
import com.suixiang.mapper.ReportNodesMapper;
import com.suixiang.mapper.UserFansMapper;
import com.suixiang.mapper.UserMapper;
import com.suixiang.mapper.UserVisionMapper;
import com.suixiang.pojo.Comment;
import com.suixiang.pojo.ReportNodes;
import com.suixiang.pojo.User;
import com.suixiang.pojo.UserFans;
import com.suixiang.pojo.UserVision;
import com.suixiang.service.UserService;
import com.suixiang.utils.ReturnJSONResult;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserVisionMapper userVisionMapper;
	
	@Autowired
	private UserFansMapper userFansMapper;
	
	@Autowired
	private ReportNodesMapper reportNodesMapper;
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private Sid sid;
	
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean queryUsernameIsExit(String username) {
		User user = new User();
		user.setUsername(username);
		User one = userMapper.selectOne(user);
		return one == null ? false : true;
	}
	
    @Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void saveUser(User user) {
		String userId = sid.nextShort();
		user.setId(userId);
		userMapper.insert(user);

	}
    
    @Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public User queryUserByUsername(String username) {
		User user = new User();
		user.setUsername(username);
		User one = userMapper.selectOne(user);
		return one;
	}
    
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void updateUserDetail(User user) {
		Example example = new Example(User.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("id", user.getId());
		userMapper.updateByExampleSelective(user, example);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public User queryUserDetailById(String userId) {
		Example example = new Example(User.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("id", userId);
		User user = userMapper.selectOneByExample(example);
		return user;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean userLoveVideo(String userId, String videoId) {
		if (StringUtils.isBlank(userId) || StringUtils.isBlank(videoId)) {
			return false;
		}
		Example example = new Example(UserVision.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("userid", userId);
		criteria.andEqualTo("visionid", videoId);
		List<UserVision> list = userVisionMapper.selectByExample(example);
		if(list != null && list.size()>0) {
			return true;
		}
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void addUserFansRelation(String userId, String fansId) {
		UserFans userFans = new UserFans();
		String id = sid.nextShort();
		userFans.setId(id);
		userFans.setUserid(userId);
		userFans.setFansid(fansId);
		userFansMapper.insert(userFans);
		userMapper.increaseFansCount(userId);
		userMapper.increaseConCount(fansId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void delUserFansRelation(String userId, String fansId) {
		Example example = new Example(UserFans.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("userid", userId);
		criteria.andEqualTo("fansid", fansId);
		userFansMapper.deleteByExample(example);
		userMapper.decreaseFansCount(userId);
		userMapper.decreaseConCount(fansId);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean isConcerned(String userId, String fansId) {
		Example example = new Example(UserFans.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("userid", userId);
		criteria.andEqualTo("fansid", fansId);
		List<UserFans> list = userFansMapper.selectByExample(example);
		if(list != null && !list.isEmpty() && list.size()>0) {
			return true;
		}
		return false;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void tipUser(ReportNodes reportNodes) {
		String id = sid.nextShort();
		reportNodes.setId(id);
		reportNodes.setCreattime(new Date());
		reportNodesMapper.insert(reportNodes);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<String> getDanmuList(String videoId) {
		Example example = new Example(Comment.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("visionid", videoId);
		List<Comment> list = commentMapper.selectByExample(example);
		List<String> danmuList = new ArrayList<String>();
		if(list != null && list.size()>0) {
			for(Comment comment : list) {
				danmuList.add(comment.getComment());			
			}
		}
		return danmuList;
	}

}
