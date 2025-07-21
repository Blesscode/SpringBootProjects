package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.binding.LoginPageBinding;
import com.app.service.InterviewerService;

@Controller
public class LoginPageController {
	@Autowired
	@Qualifier("interviewerServiceImpl")
	private InterviewerService service;
	
	//1. show login page
	@GetMapping("/login")
	public String showLoginPage(Model model) {
		model.addAttribute("loginmodel", new LoginPageBinding());
		return "Login";
	}
	
	//2. auth login credentails with username/email and pwd
	@PostMapping("/loginSubmit")
	public String handelLogin(LoginPageBinding logBinding) {
		System.out.println(logBinding);
		//1. auth credentials = bool
		Boolean authCheck=service.loginAuth(logBinding.getInterviewerDtls(), logBinding.getInterviewerPassword());
		if(authCheck) {
			return "redirect:/dashboard";
		}
		return "redirect:/login";
	}
}

