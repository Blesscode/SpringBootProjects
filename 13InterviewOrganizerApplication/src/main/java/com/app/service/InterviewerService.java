package com.app.service;

import com.app.binding.LoginPageBinding;
import com.app.binding.RegisterPageBinding;
import com.app.binding.UnlockPageBinding;

import jakarta.servlet.http.HttpServletResponse;

public interface InterviewerService  {
	
	//1. register the user with the website i.e. create an acc
	Boolean registerNewInterviewer(RegisterPageBinding register);
	
	//2. unlock it's acc
	Boolean activatingAccount(String tempPwd,String email,String newPwd);
	
	//3. lock activation link for user
	Boolean lockActivationLink(String email);
	
	//4. authenticate account active status
    Boolean authenticateLinkStatus(String email,String reciveToken);
    
    //1. Login auth
    Boolean loginAuth(String dtls, String pwd);
    
}
