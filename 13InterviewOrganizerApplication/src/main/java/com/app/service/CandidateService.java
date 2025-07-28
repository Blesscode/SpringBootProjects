package com.app.service;

import com.app.binding.DashboardPageBinding;

public interface CandidateService {

	//get candidate data on dashboard : based on the interviewer
	public DashboardPageBinding getDashboardData(Integer interviewerId);
	//find candidate based on search : based on the interviewer
	
	//add candidate : based on the interviewer
	
	//edit candidate : based on the interviewer
}
