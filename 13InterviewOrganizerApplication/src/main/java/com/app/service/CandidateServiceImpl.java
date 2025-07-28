package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.app.repository.JobRoleOptionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.binding.DashboardPageBinding;
import com.app.entity.CandidateDtlsEntity;
import com.app.entity.InterviewerDtlsEntity;
import com.app.repository.InterviewerDtlsRepo;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	//private CandidateDtlsRepo candidateRepo;
	private InterviewerDtlsRepo interviewerRepo;

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
	

}
