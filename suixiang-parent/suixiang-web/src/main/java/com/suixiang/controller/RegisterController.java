package com.suixiang.controller;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.suixiang.pojo.User;
import com.suixiang.pojo.vo.UserVO;
import com.suixiang.service.UserService;
import com.suixiang.utils.MD5Utils;
import com.suixiang.utils.ReturnJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="用户注册的接口",tags= {"注册的controller"})
public class RegisterController extends BasicController{
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="用户注册",notes="用户注册的接口")
	@PostMapping("/regist")
	public ReturnJSONResult regist(@RequestBody User user) throws Exception {
		// 1.判断用户名或密码不能为空
		if(StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
				return ReturnJSONResult.errorMsg("用户名或密码不能为空");
		}
		// 2.判断用户名是否存在
		boolean isExit = userService.queryUsernameIsExit(user.getUsername());
		// 3.保存用户
		if(!isExit) {
			user.setNickname(user.getUsername());
			user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
			user.setCountcon(0);
			user.setCountfan(0);
			user.setCountlove(0);
			userService.saveUser(user);
		}else {
			return ReturnJSONResult.errorMsg("用户名已存在");
		}
		String usertoken = UUID.randomUUID().toString();
		redisOperator.set(USER_REDIS_SESSION + ":" +user.getId(), usertoken, 60 * 1000 * 30);
		UserVO userVO = new UserVO();
		userVO.setUsertoken(usertoken);
		//将user的属性值拷贝到userVO中
		BeanUtils.copyProperties(user, userVO);
		return ReturnJSONResult.ok(userVO);
	}
	
}
