package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.CandidateDtlsEntity;

public interface CandidateDtlsRepo extends JpaRepository<CandidateDtlsEntity, Integer>{

	/* No use since the collection is used to get each candidate
	//count total no of candidates that a specific interviewer has registered/added
	//Integer countByInterviewer_InterviewerId(Integer interviewerId);
	
	// count no of candidate by parameter = accepted,rejected,no-update
	//Integer countByCandidateStatus(String candidateStatus);*/
	
	//update student details based on example
	

	
	
}
