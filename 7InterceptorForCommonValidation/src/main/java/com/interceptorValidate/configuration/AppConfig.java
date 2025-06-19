package com.interceptorValidate.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.interceptorValidate.interceptor.LogInterceptor;
@Configuration
public class AppConfig implements WebMvcConfigurer{
	@Autowired
	private LogInterceptor logInterceptor;
	 @Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		 //add my interceptor to interceptor registry
		 registry.addInterceptor(logInterceptor);
	}

}
