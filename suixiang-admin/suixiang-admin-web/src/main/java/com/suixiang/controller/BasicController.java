package com.suixiang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class BasicController {
	
	public static final String USER_REDIS_SESSION = "user_redis_session";
	
	// ffmpeg所在目录
	public static final String FFMPEG_EXE = "C:\\ffmpeg\\bin\\ffmpeg.exe";
	
	//分页时每页显示条数
	public static final Integer PAGE_SIZE = 10;
	
}
