package com.app.helper;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.repository.InterviewerDtlsRepo;
@Component
public class ActivationLinkGenerator {
	private InterviewerDtlsRepo interviewerrepo;

	@Autowired
	ActivationLinkGenerator(InterviewerDtlsRepo interviewerrepo){
		this.interviewerrepo= interviewerrepo;
	}

	/*
	 * Generate a unique activation link for each registration based on email and generated unique token for each registration
	 * @param (interviewer mail)
	 * @return String
	 */
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
}
