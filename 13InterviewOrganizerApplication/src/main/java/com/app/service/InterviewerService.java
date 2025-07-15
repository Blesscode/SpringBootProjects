package com.app.service;

import com.app.binding.LoginPageBinding;
import com.app.binding.RegisterPageBinding;
import com.app.binding.UnlockPageBinding;

import jakarta.servlet.http.HttpServletResponse;

public interface InterviewerService  {
	
	
	Boolean registerNewInterviewer(RegisterPageBinding register,HttpServletResponse httpresponse)throws Exception;
	
	Boolean saveNewInterviewer(RegisterPageBinding register);
	
	String createActivationLink(String email);
	
	Boolean authenticateUserTempPassword(String tempPwd,String email,String newPwd);

	Boolean findInterviewer(LoginPageBinding login);

	Boolean activateAccount(UnlockPageBinding unlock);

	Boolean sendPwdToEmail(String email);

	

	Boolean lockActivationLink();
	
}
