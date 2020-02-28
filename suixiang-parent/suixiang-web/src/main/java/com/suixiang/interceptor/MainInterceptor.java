package com.suixiang.interceptor;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.suixiang.utils.JsonUtils;
import com.suixiang.utils.RedisOperator;
import com.suixiang.utils.ReturnJSONResult;

public class MainInterceptor implements HandlerInterceptor {
	
	@Autowired
	public RedisOperator redisOperator;	
	public static final String USER_REDIS_SESSION = "user_redis_session";
	
	/**
	 * 拦截请求，在controller调用之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String userId = request.getHeader("userId");
		String usertoken = request.getHeader("usertoken");
		if(StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(usertoken)) {
			String usertoken2 = redisOperator.get(USER_REDIS_SESSION + ":" + userId);
			if(StringUtils.isEmpty(usertoken2) && StringUtils.isBlank(usertoken2)) {
				System.out.println("请重新登录");
				returnErrorResponse(response, new ReturnJSONResult().errorTokenMsg("请重新登录"));
				return false;
			}else {
				if(!usertoken2.equals(usertoken)) {
					System.out.println("异地登陆");
					returnErrorResponse(response, new ReturnJSONResult().errorTokenMsg("异地登陆"));
					return false;
				}
			}
		}else {
			System.out.println("请登录");
			returnErrorResponse(response, new ReturnJSONResult().errorTokenMsg("请登录"));
			return false;
		}
		return true;
	}
	
	public void returnErrorResponse(HttpServletResponse response, ReturnJSONResult result) 
			throws IOException, UnsupportedEncodingException {
		OutputStream out=null;
		try{
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("text/json");
		    out = response.getOutputStream();
		    out.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
		    out.flush();
		} finally{
		    if(out!=null){
		        out.close();
		    }
		}
	}

	/**
	 * 请求controller之后，视图渲染之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 请求controller之后，渲染视图之前
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	

}
