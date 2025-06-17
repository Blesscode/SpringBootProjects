package com.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.form.binding.User;

@Controller
public class UserController {
	//1.show form page
	@GetMapping("/")
	public String showform() {
		return "index"; // resolves to /views/index.jsp
	}
		
	//2.  handle submit form
	@PostMapping("/user")
	public String getform(User user,Model model) {
		System.out.println(user); //internally call toString()
		model.addAttribute("msg", "user saved");
		return"index";
	}

	
}
	