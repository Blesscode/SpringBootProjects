package com.interceptorTime.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class RequestLogInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Start process");
		//1. current time=start time
		long startTime	=System.currentTimeMillis();
        //add to request that comes
		request.setAttribute("startTime", startTime);
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("End process");
		//2.current time=end time
		long endTime	=System.currentTimeMillis();
		long startTime= (long) request.getAttribute("startTime");
		long totalTime= endTime-startTime;
		System.out.println("Total time taken:"+totalTime);
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
}
