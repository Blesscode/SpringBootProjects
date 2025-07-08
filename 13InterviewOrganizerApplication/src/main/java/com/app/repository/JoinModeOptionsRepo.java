package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.JoinModeOptionsEntity;

public interface JoinModeOptionsRepo extends JpaRepository<JoinModeOptionsEntity, Integer>{
	//find all unique join-mode names from all the join-mode present
	@Query("select distinct u.joinModeName from JoinModeOptionsEntity u")
	List<String> listOfRoles();
}
