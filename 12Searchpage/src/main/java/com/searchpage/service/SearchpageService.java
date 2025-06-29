package com.searchpage.service;

import java.io.FileOutputStream;
import java.util.Comparator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.searchpage.entity.DataEntity;
import com.searchpage.repository.DataRepository;



@Service
public class SearchpageService  {
	
	@Autowired
	private DataRepository repo;
	
	//search all result from db
	public List<DataEntity> searchRecords() {
		List<DataEntity> all = repo.findAll();
		return all;
	}
	
	//get data to excel sheet
	public void getExcel() throws Exception{
		
	}
	//get data to pdf sheet
	public void getPdf() {
			
	}

}
