package com.form4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.form4.binding.User;

@Controller
public class StudentController {

	//show form
	@GetMapping("/")
	public String welcome(Model model) {
//		But during a GET request
//		Spring has no object to bind or create for you
//		So you must manually add the object to the model using:


		//1. model.addAttribute("user", new User());
		//2.
		model.addAttribute("student", new User());
		return "index";
	}
	
	//save data
	@PostMapping("/save")
	public String saveDataOfForm(User user,Model model) {
		
		
		//1. If the form object name (th:object) matches the method argument name (User user), Spring automatically adds it back to the model under that nam
		//Spring only auto-adds the model object during a POST (or any data-submitting method) if:
		//The object is a method argument (e.g. User user)
		//The parameter name matches the th:object name (user in this case)
		
		//2. else add manually if have diff name as per obj
		model.addAttribute("student", new User());
		System.out.println(user);
		model.addAttribute("msg", "User data saved");

		
		//maybe if you want o save in db then db logic....
		return "index";
	}
}
