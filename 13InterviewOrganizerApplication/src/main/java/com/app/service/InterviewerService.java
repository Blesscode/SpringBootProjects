package com.app.service;

import com.app.binding.LoginPageBinding;
import com.app.binding.RegisterPageBinding;
import com.app.binding.UnlockPageBinding;

public interface InterviewerService  {
	Boolean registerNewInterviewer(RegisterPageBinding register);

	Boolean findInterviewer(LoginPageBinding login);

	Boolean activateAccount(UnlockPageBinding unlock);

	Boolean sendPwdToEmail(String email);

	Boolean sendActivationPwdToEmail(String email);

	Boolean lockActivationLink();
	
}
