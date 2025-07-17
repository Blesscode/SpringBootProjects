package com.app.service;

import com.app.binding.LoginPageBinding;
import com.app.binding.RegisterPageBinding;
import com.app.binding.UnlockPageBinding;

import jakarta.servlet.http.HttpServletResponse;

public interface InterviewerService  {
	
	//1. register the user with the website i.e. create an acc
	Boolean registerNewInterviewer(RegisterPageBinding register);
	
	   //helper service methods for registering the user
		//Boolean saveNewInterviewer(RegisterPageBinding register);
		
		//String createActivationLink(String email);
		
		//Boolean activationMailSending(String pwd, String mail);
	
	//2. unlock it's acc
	Boolean activatingAccount(String tempPwd,String email,String newPwd);

	Boolean findInterviewer(LoginPageBinding login);



	Boolean sendPwdToEmail(String email);

	

	Boolean lockActivationLink(String email);
    Boolean authenticateLinkStatus(String email,String reciveToken);
}
