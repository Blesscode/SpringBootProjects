package com.app.service;

import java.util.List;

import com.app.binding.AddPageBinding;
import com.app.binding.DashboardPageBinding;

public interface CandidateService {

	//get candidate data on dashboard : based on the interviewer
	public DashboardPageBinding getDashboardData(Integer interviewerId);
	//find candidate based on search : based on the interviewer
	
	//add candidate : based on the interviewer
	public List<String> getjobRoles();
	public List<String> getjoinModes();
	public Boolean saveCandidate(AddPageBinding addBinding);

	//edit candidate : based on the interviewer
}
