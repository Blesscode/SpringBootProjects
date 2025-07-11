package com.app.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.binding.LoginPageBinding;
import com.app.binding.RegisterPageBinding;
import com.app.binding.UnlockPageBinding;
import com.app.entity.InterviewerDtlsEntity;
import com.app.helper.GeneratePwd;
import com.app.repository.InterviewerDtlsRepo;
@Service
public class InterviewerServiceImpl implements InterviewerService {

	private InterviewerDtlsRepo interviewerrepo;
	private GeneratePwd activationobj;
	@Autowired
	InterviewerServiceImpl(InterviewerDtlsRepo interviewerrepo,GeneratePwd activationobj){
		this.interviewerrepo= interviewerrepo;
		this.activationobj=activationobj;
	}
	
	@Override
	public Boolean registerNewInterviewer(RegisterPageBinding register) {
		// TODO Auto-generated method stub
		//1. get temporary gen pwd
		String ActivationPassword=activationobj.genPwdForUnlocking();
		//2. save the data to db
	    //2. set to db ---> no here name and everything is null when entity is saved
		InterviewerDtlsEntity entity = new InterviewerDtlsEntity();
		BeanUtils.copyProperties(register,entity);
		System.out.print(entity);
		//since the username in binding is not same as username in entity and copyProperties uses reflection api inside to copy same getters and setter ,so manual value set
		entity.setInterviewerUsername(register.getUsername());
		entity.setInterviewerPassword(ActivationPassword);
		interviewerrepo.save(entity);

		return null;
	}

	@Override
	public Boolean findInterviewer(LoginPageBinding login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean activateAccount(UnlockPageBinding unlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean sendPwdToEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean sendActivationPwdToEmail(String email) {
		// TODO Auto-generated method stub
		
		//1. get activation pwd that is generated and saved to db
		//2. send mail
		return null;
	}

	@Override
	public Boolean lockActivationLink() {
		// TODO Auto-generated method stub
		return null;
	}

}
