package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class DashboardPageController {
	@Autowired
	private HttpSession session;
	//1. show login page
	@GetMapping("/dashboard")
	public String showLoginPage() {
		
		return "Dashboard";
	}
	@GetMapping("/logout")
	public String logoutAction(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("session invalid");
		session.invalidate();
//		 HttpSession session = request.getSession(false);
//		 if (session != null) {
//		        session.invalidate(); // Invalidate session
//		    }
//		 // Remove JSESSIONID cookie from browser
//		    Cookie cookie = new Cookie("JSESSIONID", null);
//		    cookie.setMaxAge(0); // delete it
//		    cookie.setPath("/");
//		    response.addCookie(cookie);
		 // Prevent any caching
	    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
	    response.setHeader("Pragma", "no-cache");
	    response.setDateHeader("Expires", 0);
		return "Home";
	}
}
