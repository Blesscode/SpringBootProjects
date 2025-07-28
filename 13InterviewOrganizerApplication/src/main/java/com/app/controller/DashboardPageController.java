package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.binding.DashboardPageBinding;
import com.app.service.CandidateService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class DashboardPageController {
	@Autowired
	private HttpSession session;
	
	@Autowired
	private CandidateService candidateService;
	//1. show login page
	@GetMapping("/dashboard")
	public String showLoginPage(HttpServletRequest request, HttpServletResponse response,Model model) {
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
	    response.setHeader("Pragma", "no-cache");
	    response.setDateHeader("Expires", 0);
	    
	 // Check if session is valid and user is logged in
	    //Object userId = request.getSession(false) != null ? request.getSession(false).getAttribute("user-id") : null;
	    Integer userId = null;
	    if (session != null) {
	        Object obj = session.getAttribute("user-id");
	        if (obj instanceof Integer) {
	            userId = (Integer) obj;
	        }
	    }
	    System.out.println(userId);
	    
	    if (userId == null) {
	        System.out.println("Session expired or user not logged in. Redirecting to login.");
	        return "redirect:/login";
	    }
	    
	    DashboardPageBinding dashboardBinding = candidateService.getDashboardData(userId);
	    model.addAttribute("dashboardData", dashboardBinding);
	    model.addAttribute("UserName", request.getSession(false).getAttribute("username"));
		return "Dashboard";
	}
	@GetMapping("/logout")
	public String logoutAction(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("session invalid");
		 HttpSession session = request.getSession(false); //get session
		    if (session != null) {
		        session.invalidate();
		    }

		    // Double-check if session is removed
		    session = request.getSession(false);
		    if (session == null) {
		        System.out.println("Confirmed: session is removed.");
		    }


		return "redirect:/";
	}
}
