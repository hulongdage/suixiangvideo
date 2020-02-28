package com.suixiang;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
/**
 * 以继承SpringBootServletInitializer的方式去启动部署,相当于web.xml的方式
 * @author Administrator
 *
 */
public class WarStartApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(Application.class);
	}
 
}
