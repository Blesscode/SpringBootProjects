package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.binding.AddPageBinding;
import com.app.binding.DashboardPageBinding;
import com.app.entity.CandidateDtlsEntity;
import com.app.entity.InterviewerDtlsEntity;
import com.app.repository.InterviewerDtlsRepo;
import com.app.repository.JobRoleOptionsRepo;
import com.app.repository.JoinModeOptionsRepo;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	//private CandidateDtlsRepo candidateRepo;
	private InterviewerDtlsRepo interviewerRepo;

	@Autowired
	private JobRoleOptionsRepo jobRoleRepo;

	@Autowired
	private JoinModeOptionsRepo joinModeRepo;

	@Override
	public DashboardPageBinding getDashboardData(Integer interviewerId) {

		// TODO Auto-generated method stub
		/*Integer totalCandidatesAdded = candidateRepo.countByInterviewer_InterviewerId(interviewerId);
		Integer noUpdatecandidates = candidateRepo.countByCandidateStatus("Pending");
		Integer candidatesRejected = candidateRepo.countByCandidateStatus("Rejected");
		Integer candidatesAccepted = candidateRepo.countByCandidateStatus("Accepted");*/
		
		Optional<InterviewerDtlsEntity> interviewer = interviewerRepo.findById(interviewerId);
		
		int candidatesRejected=0;
		int candidatesAccepted=0;
		int noUpdatecandidates=0;
		DashboardPageBinding dashboardBinding=new DashboardPageBinding();
		
		if(interviewer.isPresent()) {
			InterviewerDtlsEntity interviewerEntity = interviewer.get();
			List<CandidateDtlsEntity> candidatesInterviewedEntity = interviewerEntity.getCandidatesInterviewed();
			//total candates interviewd
			int totalCandidatesAdded = candidatesInterviewedEntity.size();
			for(CandidateDtlsEntity i:candidatesInterviewedEntity) {
				String candidateStatus = i.getCandidateStatus();
				if("Rejected".equals(candidateStatus)) {
					candidatesRejected++;
				}
				else if("Accepted".equals(candidateStatus)){
					candidatesAccepted++;
				}else {
					noUpdatecandidates++;
				}
			}
			
			dashboardBinding.setTotal(totalCandidatesAdded);
			dashboardBinding.setLeft(candidatesRejected);
			dashboardBinding.setAccepted(candidatesAccepted);
			dashboardBinding.setPending(noUpdatecandidates);
		}
		
		
		return dashboardBinding;
	}

	//get the dropdown data 
	@Override
	public List<String> getjobRoles(){
		return jobRoleRepo.listOfRoles();
	}
	@Override
	public List<String> getjoinModes(){
		return joinModeRepo.listOfModes();
	}
	@Override
	public Boolean saveCandidate(AddPageBinding addBinding){
		
		return null;
		
	}

}
