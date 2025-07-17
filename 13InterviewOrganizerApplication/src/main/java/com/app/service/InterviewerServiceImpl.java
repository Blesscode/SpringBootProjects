package com.app.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.binding.LoginPageBinding;
import com.app.binding.RegisterPageBinding;
import com.app.entity.InterviewerDtlsEntity;
import com.app.helper.ActivationLinkGenerator;
import com.app.helper.GeneratePwd;
import com.app.helper.SendEmail;
import com.app.repository.InterviewerDtlsRepo;

@Service
public class InterviewerServiceImpl implements InterviewerService {

	@Autowired
	private InterviewerDtlsRepo interviewerRepo;
	@Autowired
	private GeneratePwd activationPwd;
	@Autowired
	private SendEmail emailUtils;
	@Autowired
	private ActivationLinkGenerator linkGeneratorUtil;

	/*
	 * To register new user account
	 * Activieties in register business logic
		 * 1. save the user dtls to db
		 * 2. get the pwd for activation of user acc
		 * 3. create an acc activation link
		 * 4. send activation link to email
	 * @param (register model from the registerPageBinding containing the user details from registration page)
	 * @return Boolean
	 */
	@Override
	public Boolean registerNewInterviewer(RegisterPageBinding register) {
		// TODO Auto-generated method stub
		//1. save the user to db
		this.saveNewInterviewer(register);
		//2. find password based on username or email
		String activationPwd = interviewerRepo.findActivationPwd(register.getInterviewerEmail(), register.getUsername());
		System.out.println("got pwd: "+activationPwd);
		//3. create link 
		//String activationLink=this.createActivationLink(register.getInterviewerEmail());
		String activationLink = linkGeneratorUtil.createActivationLink(register.getInterviewerEmail());
		System.out.println(activationLink);
		//4. send pwd to mail with activation page url [url is unique to each person]
		//emailRepo.topdf(httpresponse, activationPwd, activationLink);
		//this.activationMailSending(activationPwd, activationLink);
		emailUtils.activationMailSending(activationPwd, activationLink);
			
		return null;
	}

	/*
	 * Helper method for registerNewInterviewer method to save/ register user 
	 * Generate a pwd for user and save that also
	 * Saves all details of user 
	 * [USE GENERATE PWD + SAVE USER]
	 * @param (register model from the registerPageBinding containing the user details from registration page)
	 * @return Boolean
	 */
	private Boolean saveNewInterviewer(RegisterPageBinding register) {
		// TODO Auto-generated method stub
		//1. get temporary gen pwd
		String ActivationPassword=activationPwd.genPwdForUnlocking();
		System.out.println("generated pwd: "+ActivationPassword);
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
		interviewerRepo.save(entity);
		
		 

		return null;
	}

	@Override
	public Boolean findInterviewer(LoginPageBinding login) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Boolean activationMailSending(String pwd, String link) {
		// TODO Auto-generated method stub
		
		String subject="Your activation Link";
		
		String body="Your activation password is"+" "+pwd+" "+"to activate your account please click the following link and reset your password"+" "+link;
		
		String to="reciver@gmail.com";
		
		emailUtils.sendEmail(subject,body,to);
		return true;
	}*/

	@Override
	public Boolean sendPwdToEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public String createActivationLink(String interviewer_email){
		// TODO Auto-generated method stub
		
		
		//1. get activation pwd: that is generated and saved to db

		//String interviewer_username = register.getUsername();
		//String interviewer_email = register.getInterviewerEmail();
		//String activationPwd = interviewerrepo.findActivationPwd(interviewer_email, interviewer_username);
		//2. create link
		String token=interviewerRepo.findByActiveToken(interviewer_email) ;
		String encodedEmail = URLEncoder.encode(interviewer_email, StandardCharsets.UTF_8);
		String encodedToken = URLEncoder.encode(token, StandardCharsets.UTF_8);
		String activationLink = "http://localhost:8080/activePage?token=" + encodedToken+"&email=" + encodedEmail;
		System.out.println("Activation Link: " + activationLink);
		
		// before encoding = http://localhost:8080/ActivePage?token=56f04e3f-df11-44d9-9cc2-f0f72cea1ee0&email=abc@gmail.com
		//2. send pwd to mail with activation page url [url is unique to each person]
		//emailRepo.topdf(httpresponse, activationPwd, activationLink);
		return activationLink;
	}*/
	
	/*
	 * Perform user account activation by taking the password provided and
	 * check/authenticating if the password is correct then activate user account and save the new password
	 * else reload the activation link page
	 * @param (temporaryPassword that is provided to activate the account, email to autherize the temp pwd belong to which account,new password to change)
	 * @return Boolean
	 */
	@Override
	
	public Boolean activatingAccount(String tempPwd,String email,String newPwd) {
		// TODO Auto-generated method stub
	
		String tempPwdFormDb = interviewerRepo.findActivationPwd(email, null);
		if(tempPwdFormDb.equals(tempPwd)) {
			//update pwd in db with new pwd
			interviewerRepo.updatePasswordByEmail(newPwd, email);
			
			
			return true;
		}
		return false;
	}

	@Override
	public Boolean lockActivationLink(String email) {
		// TODO Auto-generated method stub
		//update acc to active
		interviewerRepo.updateAccountStatus(true,email);
		//set token value to null[token invalid] = lock link
		interviewerRepo.updateToken("null",email);
		String storedToken=interviewerRepo.getTokenByEmail(email);
		if(storedToken == null || storedToken.equals("null") ) {
			return true;
		}else {
			return false;
		}

	}
	

	@Override
	public Boolean authenticateLinkStatus(String email,String reciveToken){
		String storedToken=interviewerRepo.getTokenByEmail(email);
		if("Not Provided".equals(reciveToken)) {
			if(storedToken == null || storedToken.equals("null") ) {
				return true;
			}else {
				return false;
			}
		}else {
		if(storedToken == null || storedToken.equals("null")|| !storedToken.equals(reciveToken) ) {
			return true;
		}else {
			return false;
		}
		}
	}
	

}
