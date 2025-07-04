package com.searchpage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.searchpage.Binding.SearchRequest;
import com.searchpage.entity.DataEntity;
import com.searchpage.service.SearchServiceImplementation;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class SearchPageController {

	//dependent on service
	@Autowired
	private SearchServiceImplementation service;
	
	//1. get status options from db and send resp to ui
	@GetMapping("/")
	public String getSearchPage(Model model) {
		//add empty obj for form binding
		SearchRequest request = new SearchRequest();
		model.addAttribute("data", request);
		initStatus(model);
		
		return "SearchPage";
	}


	private void initStatus(Model model) {
		model.addAttribute("statusList", service.statusOptions());
	}
	
	
	//2. get search req and send search response on ui page
	@PostMapping("/search")
	public String searchResult(Model model,SearchRequest searchreq) {
		//obj detail
		System.out.println(searchreq);
		//based on obj details search
		List<DataEntity> record = service.searchRecord(searchreq);
		//test incoming data
						for(DataEntity i:record) {
							System.out.println(i);
						}
		//add the list of obj to the display ui
		model.addAttribute("data", searchreq);
		model.addAttribute("display",record);
		//  Clear form by sending a new empty object to the form
	    model.addAttribute("data", new SearchRequest());
		//return home page ui
		initStatus(model);
		return "SearchPage";

	}
	
	//3. export to pdf
	@GetMapping("/pdf")
	public void getPdf(HttpServletResponse response)throws Exception {
		//set the response type that will be accepted by browser
			//application/octet-stream = excel
			//application/pdf = pdf
		response.setContentType("application/pdf");
		//send file as attachment to browser
		response.addHeader("Content-Disposition", "attachment;filename=userDetails.pdf");
		
		//logic to get excel file 
		service.exportToPdf(response);
		
	}
	
	//4. export to excel
	@GetMapping("/excel")
	public void getExcel(HttpServletResponse response)throws Exception {
		//set the response type that will be accepted by browser
			//application/octet-stream = excel
			//application/pdf = pdf
		response.setContentType("application/octet-stream");
		//send file as attachment to browser
		response.addHeader("Content-Disposition", "attachment;filename=userDetails.xls");
		
		//logic to get excel file 
		service.exportToExcel(response);
		
	}
	
	
	
}
