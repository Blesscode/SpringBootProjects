package com.searchpage.service;

import java.util.List;

import com.searchpage.Binding.SearchRequest;
import com.searchpage.entity.DataEntity;

import jakarta.servlet.http.HttpServletResponse;

public interface SearchService {

	//1. find status options from db
	public List<String> statusOptions();
	//2. find the data when search clicked based on the search options : search button handle
	public List<DataEntity> searchRecord(SearchRequest search);
	//3. export to pdf[download]
	public Boolean exportToPdf(HttpServletResponse response)throws Exception;
	//4. export to excel[download]
	public Boolean exportToExcel(HttpServletResponse response)throws Exception;
	
}
