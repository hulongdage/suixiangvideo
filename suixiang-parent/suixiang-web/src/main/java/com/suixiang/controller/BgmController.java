package com.suixiang.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suixiang.pojo.Backgroundmusic;
import com.suixiang.service.BgmService;
import com.suixiang.utils.ReturnJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="操作背景音乐的接口",tags= {"操作背景音乐的controller"})
@RequestMapping("/bgm")
public class BgmController extends BasicController{
	
	@Autowired
	private BgmService bgmService;
	
	@ApiOperation(value="查询背景音乐列表",notes="查询背景音乐列表的接口")
	@PostMapping("/queryBgmList")
	public ReturnJSONResult queryBgmList() {
		List<Backgroundmusic> bgmList = bgmService.queryBgmList();		
		return ReturnJSONResult.ok(bgmList);
	}
	
	
}
