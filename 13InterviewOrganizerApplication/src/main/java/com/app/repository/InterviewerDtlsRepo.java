package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.InterviewerDtlsEntity;
import java.util.List;


public interface InterviewerDtlsRepo extends JpaRepository<InterviewerDtlsEntity, Integer> {

	//find interviewrs by name,email,pwd
	List<InterviewerDtlsEntity> findByInterviewerName(String interviewerName);
	List<InterviewerDtlsEntity> findByInterviewerEmail(String interviewerEmail);
	List<InterviewerDtlsEntity> findByInterviewerPassword(String interviewerPassword);
}
