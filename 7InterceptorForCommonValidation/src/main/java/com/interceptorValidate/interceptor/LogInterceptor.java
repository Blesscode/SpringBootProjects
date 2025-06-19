package com.interceptorValidate.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LogInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//if username is StoreCustomer then only perform rest steps else no
		//i.e.  1. http://localhost:8080/welcome?CustomerId=abc = invalid user
		//		2. http://localhost:8080/welcome?CustomerId=StoreCustomer = Hello
		
		String CustomerId=request.getParameter("CustomerId"); //used to take parameters form request
		if("StoreCustomer".equals(CustomerId)) {
			return true;
		}
			
		response.getWriter().print("invalid user");  // used to send response
		return false;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
}
