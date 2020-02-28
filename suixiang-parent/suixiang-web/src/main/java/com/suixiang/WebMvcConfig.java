package com.suixiang;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.suixiang.interceptor.MainInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("file:C:/suixiangsoul_file/")
		.addResourceLocations("classpath:/META-INF/resources/");
	}
  
	@Bean
	public MainInterceptor mainInterceptor() {
		return new MainInterceptor();
	}
	
	@Bean(initMethod="init")
	public zkCuratorClient zkCuratorClient() {
		return new zkCuratorClient();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(mainInterceptor()).addPathPatterns("/user/**")
		              .addPathPatterns("/bgm/**")
		              .addPathPatterns("/video/**")
		              .excludePathPatterns("/user/queryPublisherDetail")
		              .excludePathPatterns("/video/queryAllVideo","/video/queryHotVideos","/video/searchVideo",
		            		  "/video/hotWord","/video/getVideoComments");
		
		super.addInterceptors(registry);
	}
	
	
}
