package com.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.app.binding.RegisterPageBinding;
import com.app.service.InterviewerService;

@Controller
public class RegisterPageController {

	@Autowired
	@Qualifier("interviewerServiceImpl")
	private InterviewerService service;

	//1. show register page
	@GetMapping("/registration")
	public String registrationPageShow(Model model) {
		
		
	       model.addAttribute("regPageBinding", new RegisterPageBinding());
		return "Register";
	}
	//2.Get registration page data
	@PostMapping("/registerSubmit")
	public String getRegistrationDtlsAndSendEmail(RegisterPageBinding registerdtls,Model model) {
		//1. get registration dtls from user
		System.out.println(registerdtls);
		/*
		 * NOTES :if void return type then will look for registerSubmit.html
		controller map redirect = redirect:/xyz search for/xyz controller mapping.
		
		//model.addAttribute("regPageBinding", new RegisterPageBinding());
		//return "Register";*/

		//2. save/register new user dtls in db
		service.registerNewInterviewer(registerdtls);
		//3. send activation using dtls to user acc
		//service.sendActivationPwdToEmail(registerdtls.getEmail());

		//4. create new registration page http req since old one is done by registring
		return "redirect:/registration";

	}
	
	
	
}
