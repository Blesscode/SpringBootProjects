package com.app.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	//1. show home page
	@GetMapping("/")
	public String showLoginPage() {
		
		return "Home";
	}
}
