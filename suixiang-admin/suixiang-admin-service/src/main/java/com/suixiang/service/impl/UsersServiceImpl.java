package com.suixiang.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suixiang.mapper.AdminMapper;
import com.suixiang.mapper.UserMapper;
import com.suixiang.pojo.Admin;
import com.suixiang.pojo.AdminExample;
import com.suixiang.pojo.User;
import com.suixiang.pojo.UserExample;
import com.suixiang.pojo.UserExample.Criteria;
import com.suixiang.service.UserService;
import com.suixiang.utils.PagedResult;


@Service
public class UsersServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public PagedResult queryUserList(User user, Integer page, Integer pageSize) {

		String username = "";
		String nickname = "";
		if (user != null) {
			username = user.getUsername();
			nickname = user.getNickname();
		}
		
		PageHelper.startPage(page, pageSize);

		UserExample userExample = new UserExample();
		Criteria userCriteria = userExample.createCriteria();
		if (StringUtils.isNotBlank(username)) {
			userCriteria.andUsernameLike("%" + username + "%");
		}
		if (StringUtils.isNotBlank(nickname)) {
			userCriteria.andNicknameLike("%" + nickname + "%");
		}

		List<User> userList = userMapper.selectByExample(userExample);

		PageInfo<User> pageList = new PageInfo<User>(userList);

		PagedResult grid = new PagedResult();
		grid.setTotal(pageList.getPages());
		grid.setRows(userList);
		grid.setPage(page);
		grid.setRecords(pageList.getTotal());

		return grid;
	}

	@Override
	public boolean queryIsExitAdmin(String username, String password) {
		AdminExample example = new AdminExample();
		com.suixiang.pojo.AdminExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		List<Admin> list = adminMapper.selectByExample(example );
		if(list != null && list.size()>0) {
			return true;
		}
		return false;
	}


}
