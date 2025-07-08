package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.CandidateDtlsEntity;

public interface CandidateDtlsRepo extends JpaRepository<CandidateDtlsEntity, Integer>{

	// count no of candidate by parameter = accepted,rejected,no-update
	long countByCandidateStatus(String candidateStatus);
	//update student details based on example

	
	
}
