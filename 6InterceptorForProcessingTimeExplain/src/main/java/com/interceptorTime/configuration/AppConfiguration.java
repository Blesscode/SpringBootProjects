package com.interceptorTime.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.interceptorTime.interceptor.RequestLogInterceptor;
@Configuration
public class AppConfiguration implements WebMvcConfigurer{
	@Autowired
	private RequestLogInterceptor logInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(logInterceptor);
	}

}
