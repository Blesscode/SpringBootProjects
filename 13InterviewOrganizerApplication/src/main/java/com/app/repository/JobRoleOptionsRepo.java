package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.JobRoleOptionsEntity;

public interface JobRoleOptionsRepo extends JpaRepository<JobRoleOptionsEntity, Integer>{

	//find all unique roles name from all the roles present
	@Query("select distinct u.jobroleName from JobRoleOptionsEntity u")
	List<String> listOfRoles();
}
