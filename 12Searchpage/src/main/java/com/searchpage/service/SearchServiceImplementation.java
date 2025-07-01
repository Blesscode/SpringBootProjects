package com.searchpage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.searchpage.Binding.SearchRequest;
import com.searchpage.entity.DataEntity;
import com.searchpage.repository.DataRepository;

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
		return null;
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
