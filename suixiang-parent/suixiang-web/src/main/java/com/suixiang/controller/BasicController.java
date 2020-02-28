package com.suixiang.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.suixiang.utils.RedisOperator;


@RestController
public class BasicController {
	
	@Autowired
	public RedisOperator redisOperator;
	
	public static final String USER_REDIS_SESSION = "user_redis_session";
	
	// ffmpeg所在目录
	public static final String FFMPEG_EXE = "C:\\ffmpeg\\bin\\ffmpeg.exe";
	
	//分页时每页显示条数
	public static final Integer PAGE_SIZE = 4;
	
}
