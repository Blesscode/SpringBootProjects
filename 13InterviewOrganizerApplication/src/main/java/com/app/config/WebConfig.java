package com.app.config;

import java.util.Collections;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.ServletContext;
import jakarta.servlet.SessionTrackingMode;

@Configuration
public class WebConfig {

	 @Bean
	    public ServletContextInitializer servletContextInitializer() {
	        return new ServletContextInitializer() {
	            @Override
	            public void onStartup(ServletContext servletContext) {
	                // Use only cookies for session tracking — disable URL-based JSESSIONID
	                servletContext.setSessionTrackingModes(Collections.singleton(SessionTrackingMode.COOKIE));
	            }
	        };
	    }
}
