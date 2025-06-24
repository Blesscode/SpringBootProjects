package com.rest.restContoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DisplayController {
	@GetMapping("/welcome")
	public String showWelcomePg() {
		String msg="welcome!!";
		return msg;
	}
	@GetMapping("/greetings")
	public ResponseEntity<String> showGreetingsPg() {
		String msg="hello!!";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}
