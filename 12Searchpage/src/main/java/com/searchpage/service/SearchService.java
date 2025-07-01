package com.searchpage.service;

import java.util.List;

import com.searchpage.Binding.SearchRequest;
import com.searchpage.entity.DataEntity;

public interface SearchService {

	//1. find status options from db
	public List<String> statusOptions();
	//2. find the data when search clicked based on the search options : search button handle
	public List<DataEntity> searchRecord(SearchRequest search);
	//3. export to pdf
	public Boolean exportToPdf();
	//4. export to excel
	public Boolean exportToExcel();
	
}
