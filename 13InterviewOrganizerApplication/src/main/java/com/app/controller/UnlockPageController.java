package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.binding.UnlockPageBinding;
import com.app.service.InterviewerService;

@Controller
public class UnlockPageController {
	
	@Autowired
	@Qualifier("interviewerServiceImpl")
	private InterviewerService service;

	//1. show register page
		@GetMapping("/activePage")
		public String registrationPageShow(Model model,@RequestParam String email) {
			
			model.addAttribute("email", email);
		    model.addAttribute("activationPageBinding", new UnlockPageBinding());
			return "ActivePage";
		}
		@PostMapping("/activationSubmit")
		public String getData(UnlockPageBinding activedtls,@RequestParam String email,Model model ) {
			System.out.println(activedtls);
			//1. get the email from path param[pass from url]=risky for email to pass use reqparam[pass from html body]
			//1. perform check if the pwd is correct with email
			 System.out.println("Temp Password: " + activedtls.getInterviewerPassword());
			    System.out.println("New Password: " + activedtls.getChange_pwd());
			    System.out.println("email: " + email);
			Boolean Authcheck = service.authenticateUserTempPassword(activedtls.getInterviewerPassword(),email,activedtls.getChange_pwd());
			//2. redirect to login page else redirect to same page
			if(Authcheck) {
				//3. make the link dead
				System.out.println("correct");
				 return "redirect:/registration";
			}
			System.out.println("wrong");
			//return "redirect:/activePage/{email}";
			model.addAttribute("email", email);
		    model.addAttribute("activationPageBinding", new UnlockPageBinding());
			return "ActivePage";
			
			
			//todo : implement confirm pwd check + perform link dead fn
			

		}
		
}
