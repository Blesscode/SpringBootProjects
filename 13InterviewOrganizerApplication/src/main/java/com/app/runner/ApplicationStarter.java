package com.app.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.app.entity.JobRoleOptionsEntity;
import com.app.entity.JoinModeOptionsEntity;
import com.app.repository.JobRoleOptionsRepo;
import com.app.repository.JoinModeOptionsRepo;
@Component
public class ApplicationStarter implements ApplicationRunner{

	//dependent objects inject

	private final JobRoleOptionsRepo jobrolerepo; 
	private final JoinModeOptionsRepo joinmoderepo;
	
	@Autowired
	public ApplicationStarter(JobRoleOptionsRepo jobrolerepo, JoinModeOptionsRepo joinmoderepo) {
		this.jobrolerepo = jobrolerepo;
		this.joinmoderepo = joinmoderepo;
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		//prevent re-entering data 
		System.out.println(jobrolerepo.getClass().getName());//dynamic proxy class
		if(jobrolerepo.count()==0 ) {
			//roles 
			JobRoleOptionsEntity role1 = new JobRoleOptionsEntity();
			role1.setJobroleName("Senior : Java Developer");
			JobRoleOptionsEntity role2 = new JobRoleOptionsEntity();
			role2.setJobroleName("Intern : Java Developer");
			JobRoleOptionsEntity role3 = new JobRoleOptionsEntity();
			role3.setJobroleName("Senior : DevOps Engineer");
			JobRoleOptionsEntity role4 = new JobRoleOptionsEntity();
			role4.setJobroleName("GET : Fresher");
			List<JobRoleOptionsEntity>roles=Arrays.asList(role1,role2,role3,role4);
			jobrolerepo.saveAll(roles);
		}else {
			System.out.println("Entries alridy exists for job role ");
		}
		
		if( joinmoderepo.count()==0) {
			//join mode 
			JoinModeOptionsEntity joinmode1=new JoinModeOptionsEntity();
			joinmode1.setJoinModeName("Remote");
			JoinModeOptionsEntity joinmode2=new JoinModeOptionsEntity();
			joinmode2.setJoinModeName("Full-Time");
			JoinModeOptionsEntity joinmode3=new JoinModeOptionsEntity();
			joinmode3.setJoinModeName("Contractual");
			JoinModeOptionsEntity joinmode4=new JoinModeOptionsEntity();
			joinmode4.setJoinModeName("Intern");
			
			List<JoinModeOptionsEntity>joinmodes=Arrays.asList(joinmode1,joinmode2,joinmode3,joinmode4);
			joinmoderepo.saveAll(joinmodes);
		}else {
			System.out.println("Entries alridy exists for join mode");
		}
		
		
		return;
	
	}
}
