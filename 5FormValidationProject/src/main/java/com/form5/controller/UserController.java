package com.form5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.form5.binding.User;

import jakarta.validation.Valid;

@Controller
public class UserController {
	@GetMapping("/")
	public String showpage(Model model) {
		model.addAttribute("user", new User());
		return "index";
	}
	@PostMapping("/save")
	public String savepage(Model model,@Valid User user,BindingResult result) {
		System.out.println(user);
		if(result.hasErrors()){
			return "index";
		}else {
			model.addAttribute("msg", "data saved");
		}
		return "index";
	}
}
