package com.todo.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.todo.Binding.LogB;
import com.todo.Binding.TaskB;
import com.todo.entity.UserEntity;
import com.todo.repository.UserRepository;

import jakarta.validation.Valid;

@Controller
public class LoginController {
	@Autowired
	private UserRepository userrepo;
	@GetMapping("/login")
	public String showLogin(Model model,LogB logb) {

		if (!model.containsAttribute("logb")) {
	        model.addAttribute("logb", new LogB());
	    }

		return "login";
	}
	//when login data entered catch that data and search that data in db -> yes=task pg no=login pg
	@PostMapping("/logsubmit")
	public String authenticateLogin(Model model,@Valid LogB logb,BindingResult result) {
		System.out.println(logb);
		 model.addAttribute("logb", logb); 
		// enter valid email and pass
		
		if(result.hasErrors()) {
			//result.getAllErrors().forEach(e -> System.out.println("ERROR: " + e));
			
			return "login";	
		}else {
			//email and pass present
			 Optional<UserEntity> byEmailAndPassword = userrepo.findByEmailAndPassword(logb.getEmail(),logb.getPassword());
			if(byEmailAndPassword.isPresent()) {
				//task
				//model.addAttribute("taskb", new TaskB()); 
				return "redirect:/task";
			}else {
				//login
				
				return "login";
			}
			
			
		}

	}
}
