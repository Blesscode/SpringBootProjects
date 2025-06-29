package com.searchpage.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.searchpage.entity.DataEntity;
import com.searchpage.repository.DataRepository;

@Component
public class ApplicationStarter implements ApplicationRunner {

	@Autowired
	private DataRepository repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		//to avoid enties creation every time application runs or refresh
		if(repo.count()>0) {
			System.out.println("Entries alridy exists");
			return;
		}
		System.out.println("App started. Run your startup logic here.");
		DataEntity record1 = new DataEntity();
		record1.setName("raja");
		record1.setGender("M");
		record1.setStatus("working");
		record1.setStart(LocalDate.now());
		record1.setEnd(LocalDate.now().plusMonths(2)); // june+2 = Aug
		record1.setSalary(1000000.00);
		record1.setLeavingReason("none");
		
		DataEntity record2 = new DataEntity();
		record2.setName("rani");
		record2.setGender("F");
		record2.setStatus("working");
		record2.setStart(LocalDate.now().minusMonths(6)); //current month - 6 = 6-6=0[before jan since jan=1] => june may april march feb jan dec = december 2024
		record2.setEnd(null);
		record2.setSalary(2000000.00);
		record2.setLeavingReason(null);
		
		DataEntity record3 = new DataEntity();
		record3.setName("akash");
		record3.setGender("M");
		record3.setStatus("Left");
		record3.setStart(LocalDate.now().minusMonths(4)); //current month se 4 phele = 6-4=2[from starting 2nd month] june may april march feb = feb
		record3.setEnd(LocalDate.now().minusMonths(1)); // may
		record3.setSalary(250000.00);
		record3.setLeavingReason("Medical reasons");
		
		DataEntity record4 = new DataEntity();
		record4.setName("Riya");
		record4.setGender("F");
		record4.setStatus("working");
		record4.setStart(LocalDate.now().minusMonths(2)); //current month - 6 = 6-2 =4 =>april
		record4.setEnd(null);
		record4.setSalary(200000.00);
		record4.setLeavingReason(null);
		

	    DataEntity record5 = new DataEntity();
        record5.setName("Sohan");
        record5.setGender("M");
        record5.setStatus("Left");
        record5.setStart(LocalDate.now().minusMonths(10));
        record5.setEnd(LocalDate.now().minusMonths(4));
        record5.setSalary(500000.00);
        record5.setLeavingReason("Better opportunity");

        DataEntity record6 = new DataEntity();
        record6.setName("Meena");
        record6.setGender("F");
        record6.setStatus("working");
        record6.setStart(LocalDate.now().minusMonths(1));
        record6.setEnd(null);
        record6.setSalary(300000.00);
        record6.setLeavingReason(null);
        
        DataEntity record7 = new DataEntity();
        record7.setName("Karan");
        record7.setGender("M");
        record7.setStatus("Left");
        record7.setStart(LocalDate.now().minusMonths(8)); //6-8= -2 = [2=feb 1=jan 0=dec -1=nov -2=oct] = oct 2024
        record7.setEnd(LocalDate.now().minusMonths(2));
        record7.setSalary(450000.00);
        record7.setLeavingReason("Relocation");

        DataEntity record8 = new DataEntity();
        record8.setName("Pooja");
        record8.setGender("F");
        record8.setStatus("working");
        record8.setStart(LocalDate.now().minusMonths(3));
        record8.setEnd(null);
        record8.setSalary(350000.00);
        record8.setLeavingReason(null);

        DataEntity record9 = new DataEntity();
        record9.setName("Vikram");
        record9.setGender("M");
        record9.setStatus("Left");
        record9.setStart(LocalDate.now().minusMonths(12));
        record9.setEnd(LocalDate.now().minusMonths(6));
        record9.setSalary(750000.00);
        record9.setLeavingReason("Contract ended");

        DataEntity record10 = new DataEntity();
        record10.setName("Neha");
        record10.setGender("F");
        record10.setStatus("working");
        record10.setStart(LocalDate.now().minusMonths(5));
        record10.setEnd(null);
        record10.setSalary(400000.00);
        record10.setLeavingReason(null);
        
        DataEntity record11 = new DataEntity();
        record11.setName("Ankit");
        record11.setGender("M");
        record11.setStatus("working");
        record11.setStart(LocalDate.now().minusMonths(7));
        record11.setEnd(null);
        record11.setSalary(600000.00);
        record11.setLeavingReason(null);

        DataEntity record12 = new DataEntity();
        record12.setName("Sana");
        record12.setGender("F");
        record12.setStatus("Left");
        record12.setStart(LocalDate.now().minusMonths(14));
        record12.setEnd(LocalDate.now().minusMonths(3));
        record12.setSalary(550000.00);
        record12.setLeavingReason("Personal reasons");

        DataEntity record13 = new DataEntity();
        record13.setName("Nitin");
        record13.setGender("M");
        record13.setStatus("working");
        record13.setStart(LocalDate.now().minusMonths(2));
        record13.setEnd(null);
        record13.setSalary(380000.00);
        record13.setLeavingReason(null);

        DataEntity record14 = new DataEntity();
        record14.setName("Shruti");
        record14.setGender("F");
        record14.setStatus("Left");
        record14.setStart(LocalDate.now().minusMonths(9));
        record14.setEnd(LocalDate.now().minusMonths(1));
        record14.setSalary(420000.00);
        record14.setLeavingReason("Pursuing higher studies");

        DataEntity record15 = new DataEntity();
        record15.setName("Dev");
        record15.setGender("M");
        record15.setStatus("working");
        record15.setStart(LocalDate.now().minusMonths(1));
        record15.setEnd(null);
        record15.setSalary(480000.00);
        record15.setLeavingReason(null);
        
        // can modify elements but cannot add or remove values 
        List<DataEntity>arr=Arrays.asList(record1,record2,record3,record4,record5,record6,record7,record8,record9,record10,record11,record12,record13,record14,record15);
		repo.saveAll(arr);	
        	 	
	}
}
