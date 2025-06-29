package com.searchpage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.searchpage.entity.DataEntity;

@Repository
public interface DataRepository extends JpaRepository<DataEntity, Integer>{
	
	//find all by name
	@Query("select distinct name from data_table")
	public List<String>getName();
   //findBy (expects some parameters) = retrive some certain person not all persons
	//public List<String>findByName(String name);
	
	
	//find all by status
	@Query(" select distinct status from data_table")
	public List<String>getStatus();
	//	findBy (expects some parameters) = retrive some certain record
	//public List<String>findByStatus(String status);
	
}
