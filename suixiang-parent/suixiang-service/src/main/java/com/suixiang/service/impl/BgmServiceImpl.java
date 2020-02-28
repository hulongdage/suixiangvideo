package com.suixiang.service.impl;

import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.suixiang.mapper.BackgroundmusicMapper;
import com.suixiang.mapper.UserMapper;
import com.suixiang.pojo.Backgroundmusic;
import com.suixiang.pojo.User;
import com.suixiang.service.BgmService;
import com.suixiang.service.UserService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@Service
public class BgmServiceImpl implements BgmService {
    @Autowired
    private BackgroundmusicMapper bgmMapper;
    
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<Backgroundmusic> queryBgmList() {
		List<Backgroundmusic> list = bgmMapper.selectAll();
		return list;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public Backgroundmusic queryBgmById(String bgmId) {
		Backgroundmusic bgm = bgmMapper.selectByPrimaryKey(bgmId);
		return bgm;
	}
	
}
