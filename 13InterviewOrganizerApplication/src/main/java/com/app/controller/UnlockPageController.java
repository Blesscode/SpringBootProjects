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
		public String registrationPageShow(Model model,@RequestParam String email, @RequestParam String token) {
			//token auth to unactivate link
			
			if(service.authenticateLinkStatus( email,token)) {
				model.addAttribute("message", "Invalid or expired activation link.");
		        return "ActivePage"; //  return a Thymeleaf page showing "Link Expired"
			}
			model.addAttribute("email", email);
		    model.addAttribute("activationPageBinding", new UnlockPageBinding());
			return "ActivePage";
		}
		@PostMapping("/activationSubmit")
		public String unlockAcc(UnlockPageBinding activedtls,@RequestParam String email,Model model ) {
			System.out.println(activedtls);
			// to prevent multiple tab problem
			if(service.authenticateLinkStatus(email, "Not Provided")==false) {
			//1. get the email from path param[pass from url]=risky for email to pass use reqparam[pass from html body]
			//1. perform check if the pwd is correct with email
			 System.out.println("Temp Password: " + activedtls.getInterviewerPassword());
			    System.out.println("New Password: " + activedtls.getChange_pwd());
			    System.out.println("email: " + email);
			Boolean Authcheck = service.activatingAccount(activedtls.getInterviewerPassword(),email,activedtls.getChange_pwd());
			//2. redirect to login page else redirect to same page
			if(Authcheck) {
				//3. make the link dead
				System.out.println("correct");
				service.lockActivationLink(email);
				 return "redirect:/login";
			}
			System.out.println("wrong");
			//return "redirect:/activePage/{email}";
			model.addAttribute("email", email);
		    model.addAttribute("activationPageBinding", new UnlockPageBinding());
			return "ActivePage";
			}
			else {
				
				 model.addAttribute("message", "Invalid or expired activation link.");
				 model.addAttribute("activationPageBinding", new UnlockPageBinding());
					return "ActivePage";
			}

			
			
			//todo : implement confirm pwd check + perform link dead fn
			

		}
		
}
