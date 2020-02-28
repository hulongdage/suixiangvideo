package com.suixiang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suixiang.enums.BGMOperatorTypeEnum;
import com.suixiang.mapper.BackgroundmusicMapper;
import com.suixiang.pojo.Backgroundmusic;
import com.suixiang.pojo.BackgroundmusicExample;
import com.suixiang.pojo.BackgroundmusicExample.Criteria;
import com.suixiang.service.BgmService;
import com.suixiang.util.zkCuratorClient;
import com.suixiang.utils.JsonUtils;
import com.suixiang.utils.PagedResult;

@Service
public class BgmServiceImpl implements BgmService {
	
	@Autowired
	private BackgroundmusicMapper backgroundmusicMapper;
	
	@Autowired
	private Sid sid;
	
	@Autowired
	private zkCuratorClient zkCuratorClient;

	@Override
	public void addBgm(Backgroundmusic bgm) {
		String id = sid.nextShort();
		bgm.setId(id);
		backgroundmusicMapper.insert(bgm); 
 //       zkCuratorClient.sendBgmOperator(id, BGMOperatorTypeEnum.ADD.type);
        Map<String, String> map = new HashMap<>();
		map.put("operatorType", BGMOperatorTypeEnum.ADD.type);
		map.put("path", bgm.getPath());
		
		zkCuratorClient.sendBgmOperator(id, JsonUtils.objectToJson(map));
	}
	
	@Override
	public void deleteBgm(String bgmId) {
		Backgroundmusic backgroundmusic = backgroundmusicMapper.selectByPrimaryKey(bgmId);
		
		backgroundmusicMapper.deleteByPrimaryKey(bgmId);
		
		Map<String, String> map = new HashMap<>();
		map.put("operatorType", BGMOperatorTypeEnum.DELETE.type);
		map.put("path", backgroundmusic.getPath());
		
		zkCuratorClient.sendBgmOperator(bgmId, JsonUtils.objectToJson(map));
		
	}

	@Override
	public PagedResult queryBgmList(Integer currentPage, Integer pageSize) {
		PageHelper.startPage(currentPage, pageSize);		
		BackgroundmusicExample example = new BackgroundmusicExample();
		List<Backgroundmusic> bgmList = backgroundmusicMapper.selectByExample(example);
		PageInfo<Backgroundmusic> pageInfo = new PageInfo<>(bgmList);
		PagedResult pageResult = new PagedResult();
		pageResult.setPage(currentPage);
		pageResult.setRows(bgmList);
		pageResult.setTotal(pageInfo.getPages());
		pageResult.setRecords(pageInfo.getTotal());
		return pageResult;
	}

	@Override
	public boolean queryIsExitBgm(String bgmName) {
		BackgroundmusicExample example = new BackgroundmusicExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(bgmName);
		List<Backgroundmusic> list = backgroundmusicMapper.selectByExample(example );
		if(list != null && list.size()>0) {
			return true;
		}
		return false;
	}

	

}
