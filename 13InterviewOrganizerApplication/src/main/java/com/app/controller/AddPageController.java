package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.binding.AddPageBinding;
import com.app.service.CandidateService;

@Controller
public class AddPageController {
	@Autowired
	private CandidateService candidateService;

	@GetMapping("/addPage")
	public String getAddPage(Model model) {
		//get the data of job & add that to modal object 
		model.addAttribute("roles",candidateService.getjobRoles());
		//get the data of modes & add that to modal object 
		model.addAttribute("modes",candidateService.getjoinModes());
		//create binding class obj & add that to modal object
		model.addAttribute("addBinding",new AddPageBinding());

		return "Add";
	}

	@PostMapping("/addSubmit")
	public String addCandidate(){
		return "Add";
	}
}
