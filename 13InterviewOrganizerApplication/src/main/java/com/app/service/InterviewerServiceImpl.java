package com.app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.binding.RegisterPageBinding;
import com.app.entity.InterviewerDtlsEntity;
import com.app.helper.ActivationLinkGenerator;
import com.app.helper.GeneratePwd;
import com.app.helper.SendEmail;
import com.app.repository.InterviewerDtlsRepo;

import jakarta.servlet.http.HttpSession;

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
	@Autowired
	private HttpSession session;

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
	
	@Override
    public Boolean loginAuth(String dtls, String pwd) {
		if(dtls.contains("@gmail.com")) {
			//check using email and pwd
			List<InterviewerDtlsEntity> interviewerDtlsByEmail = interviewerRepo.findByInterviewerEmail(dtls);
			System.out.println(interviewerDtlsByEmail);
			if(!interviewerDtlsByEmail.isEmpty()) { //atleast 1 entry exist with this email
				InterviewerDtlsEntity firstPersonEmailEntry =interviewerDtlsByEmail.get(0);
				//check with pwd and active acc
				if(firstPersonEmailEntry.getInterviewerPassword().equals(pwd)&& (interviewerRepo.findByInterviewerAccountActiveByEmail(dtls))) {
					System.out.println("valid email & pwd");
					//create session with interviewer-id
					session.setAttribute("user-id", firstPersonEmailEntry.getInterviewerId());
					return true;
				}else {
					System.out.println("in-valid email & pwd");
					return false;
				}
			}else {
				System.out.println("in-valid email & pwd");
				return false;
			}
		}else {
			//check using user-name and pwd
			List<InterviewerDtlsEntity> interviewerDtlsByUsername = interviewerRepo.findByInterviewerUsername(dtls);
			if(!interviewerDtlsByUsername.isEmpty()) { //atleast 1 entry exist with this email
				InterviewerDtlsEntity firstPersonUsernameEntry =interviewerDtlsByUsername.get(0);
				if(firstPersonUsernameEntry.getInterviewerPassword().equals(pwd)&& (interviewerRepo.findByInterviewerAccountActiveByUsername(dtls))) {
					System.out.println("valid username and pwd");
					//create session with interviewer-id
					session.setAttribute("user-id", firstPersonUsernameEntry.getInterviewerId());
					 String sessionId = session.getId();
					    System.out.println("Session ID: " + sessionId);
					return true;
				}else {
					System.out.println("in-valid username and pwd");
					return false;
				}
			}else {
				System.out.println("in-valid username and pwd");
				return false;
			}
		}
    	
    }
	

}
