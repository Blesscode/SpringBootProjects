package com.searchpage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.searchpage.Binding.SearchRequest;
import com.searchpage.service.SearchServiceImplementation;

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
		model.addAttribute("", request);
		model.addAttribute("statusList", service.statusOptions());
		
		return "SearchPage";
	}
	
	
	//2. get search req and send search response on ui page
	
	
}
