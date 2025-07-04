package com.searchpage.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.searchpage.Binding.SearchRequest;
import com.searchpage.entity.DataEntity;
import com.searchpage.repository.DataRepository;
@Service
public class SearchServiceImplementation implements SearchService {
	
	//dependent on repo
	@Autowired
	private DataRepository repo;

	@Override
	public List<String> statusOptions() {
		// TODO Auto-generated method stub
		List<String> status = repo.getStatus();
		return status;
	}

	@Override
	public List<DataEntity> searchRecord(SearchRequest search) {
		// TODO Auto-generated method stub
		//1. based on the DYNAMIC obj req recive findAll records
		/*
		 * FOR DYNAMIC QUERY BASED ON PARAMETERS :  use QBE query by example
		 * Example.of() only works with entity classes
		 * Example is a wrapper object used to define search criteria dynamically using an entity object 
		 * provide a partially filled entity, and Spring Data will query the database for all entities that match the non-null fields of that objec
		 */
		//copy binding to entity
		DataEntity entity=new DataEntity();
		//BeanUtils.copyProperties(search, entity); copies empty feild also which will result in query searching for empty feilds also
		
		//manual copy
		//name
		if(search.getName()!=null && !search.getName().trim().isEmpty()) {
			entity.setName(search.getName());
		}
		//status
		if(search.getStatus()!=null && !search.getStatus().trim().isEmpty()) {
			entity.setStatus(search.getStatus());
		}
		//gender
		if(search.getGender()!=null && !search.getGender().trim().isEmpty()) {
			entity.setGender(search.getGender());
		}
		//start-date
		if(search.getStartDate()!=null ) {
			entity.setStart(search.getStartDate());
		}
		//end-date
		if(search.getEndDate()!=null ) {
			entity.setEnd(search.getEndDate());
		}

		
		List<DataEntity> listRecords = repo.findAll(Example.of(entity));

		return listRecords;
	}

	@Override
	public Boolean exportToPdf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean exportToExcel() {
		// TODO Auto-generated method stub
		return null;
	}

}
