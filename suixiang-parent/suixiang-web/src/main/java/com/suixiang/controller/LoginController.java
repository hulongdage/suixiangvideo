package com.suixiang.controller;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.suixiang.pojo.User;
import com.suixiang.pojo.vo.UserVO;
import com.suixiang.service.UserService;
import com.suixiang.utils.MD5Utils;
import com.suixiang.utils.ReturnJSONResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="用户登录的接口",tags= {"登录的controller"})
public class LoginController extends BasicController{
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/hello")
	public String hello() throws Exception {
		return "hello,springboot";
	}
	
	@ApiOperation(value="用户登录",notes="用户登录的接口")
	@PostMapping("/login")
	public ReturnJSONResult login(@RequestBody User user) throws Exception {
		// 1.判断用户名或密码不能为空
		if(StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
				return ReturnJSONResult.errorMsg("用户名或密码不能为空");
		}
		User user2 = userService.queryUserByUsername(user.getUsername());
		if(user2 == null) {
			return ReturnJSONResult.errorMsg("用户不存在, 请重试...");
		}else if(user2 != null && 
				!user2.getPassword().equals(MD5Utils.getMD5Str(user.getPassword()))) {
			return ReturnJSONResult.errorMsg("密码错误, 请重试...");
		}else {
			String usertoken = UUID.randomUUID().toString();
			redisOperator.set(USER_REDIS_SESSION + ":" +user2.getId(), usertoken, 60 * 1000 * 30);
			UserVO userVO = new UserVO();
			userVO.setUsertoken(usertoken);
			//将user的属性值拷贝到userVO中
			BeanUtils.copyProperties(user2, userVO);
			return ReturnJSONResult.ok(userVO);
		}		
	}
	
	@ApiOperation(value="用户注销登录",notes="用户注销登录的接口")
	@ApiImplicitParam(name="userId",value="用户id",required=true,dataType="String")
	@PostMapping("/logout")
	public ReturnJSONResult logout(String userId) throws Exception {
		redisOperator.del(USER_REDIS_SESSION +":"+ userId);
		return ReturnJSONResult.ok();
	}
	
}
