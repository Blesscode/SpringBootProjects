package com.interceptorTime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class DisplayController {

	@GetMapping("/welcome")
	public String welcome() {
		return "hello";
	}
	@GetMapping("/greetings")
	public String greetings() {
		return "welcome to my page";
	}
}
