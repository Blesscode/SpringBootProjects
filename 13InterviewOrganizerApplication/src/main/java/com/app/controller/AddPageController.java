package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddPageController {

	@GetMapping("/addPage")
	public String getAddPage() {
		return "Add";
	}
}
