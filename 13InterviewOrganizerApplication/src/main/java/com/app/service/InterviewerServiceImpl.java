package com.app.service;

import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.binding.LoginPageBinding;
import com.app.binding.RegisterPageBinding;
import com.app.entity.InterviewerDtlsEntity;
import com.app.helper.GeneratePwd;
import com.app.helper.SendEmail;
import com.app.repository.InterviewerDtlsRepo;

import jakarta.servlet.http.HttpServletResponse;
@Service
public class InterviewerServiceImpl implements InterviewerService {

	private InterviewerDtlsRepo interviewerrepo;
	private GeneratePwd activationobj;
	private SendEmail emailRepo;
	@Autowired
	InterviewerServiceImpl(InterviewerDtlsRepo interviewerrepo,GeneratePwd activationobj,SendEmail emailRepo){
		this.interviewerrepo= interviewerrepo;
		this.activationobj=activationobj;
		this.emailRepo=emailRepo;
	}
	
	@Override
	public Boolean registerNewInterviewer(RegisterPageBinding register) {
		// TODO Auto-generated method stub
		//1. save the user to db
		this.saveNewInterviewer(register);
		//2. find password based on username or email
		String interviewer_username = register.getUsername();
		String interviewer_email = register.getInterviewerEmail();
		String activationPwd = interviewerrepo.findActivationPwd(interviewer_email, interviewer_username);
		//3. create link 
		String activationLink=this.createActivationLink(register.getInterviewerEmail());
		//4. send pwd to mail with activation page url [url is unique to each person]
		System.out.println(activationPwd);
		//emailRepo.topdf(httpresponse, activationPwd, activationLink);
		this.activationMailSending(activationPwd, activationLink);
			
		return null;
	}
	@Override
	public Boolean saveNewInterviewer(RegisterPageBinding register) {
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
		//get pwd and save to db
		entity.setInterviewerPassword(ActivationPassword);
		//set activation token
		
		entity.setActiveToken(UUID.randomUUID().toString());
		
		entity.setInterviewerAccountActive(false);
		interviewerrepo.save(entity);
		
		 

		return null;
	}

	@Override
	public Boolean findInterviewer(LoginPageBinding login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean activationMailSending(String pwd, String link) {
		// TODO Auto-generated method stub
		
		String subject="Your activation Link";
		
		String body="Your activation password is"+" "+pwd+" "+"to activate your account please click the following link and reset your password"+" "+link;
		
		String to="reciver@gmail.com";
		
		emailRepo.sendEmail(subject,body,to);
		return true;
	}

	@Override
	public Boolean sendPwdToEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createActivationLink(String interviewer_email){
		// TODO Auto-generated method stub
		
		
		//1. get activation pwd: that is generated and saved to db

		//String interviewer_username = register.getUsername();
		//String interviewer_email = register.getInterviewerEmail();
		//String activationPwd = interviewerrepo.findActivationPwd(interviewer_email, interviewer_username);
		//2. create link
		String token=interviewerrepo.findByActiveToken(interviewer_email) ;
		String encodedEmail = URLEncoder.encode(interviewer_email, StandardCharsets.UTF_8);
		String encodedToken = URLEncoder.encode(token, StandardCharsets.UTF_8);
		String activationLink = "http://localhost:8080/activePage?token=" + encodedToken+"&email=" + encodedEmail;
		System.out.println("Activation Link: " + activationLink);
		
		// before encoding = http://localhost:8080/ActivePage?token=56f04e3f-df11-44d9-9cc2-f0f72cea1ee0&email=abc@gmail.com
		//2. send pwd to mail with activation page url [url is unique to each person]
		//emailRepo.topdf(httpresponse, activationPwd, activationLink);
		return activationLink;
	}
	
	@Override
	public Boolean authenticateUserTempPassword(String tempPwd,String email,String newPwd) {
		// TODO Auto-generated method stub
		String tempPwdFormDb = interviewerrepo.findActivationPwd(email, null);
		if(tempPwdFormDb.equals(tempPwd)) {
			//update pwd in db with new pwd
			interviewerrepo.updatePasswordByEmail(newPwd, email);
			
			return true;
		}
		return false;
	}

	@Override
	public Boolean lockActivationLink() {
		// TODO Auto-generated method stub
		return null;
	}

}
