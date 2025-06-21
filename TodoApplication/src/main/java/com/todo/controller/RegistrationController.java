package com.todo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.todo.Binding.LogB;
import com.todo.Binding.User;
import com.todo.entity.UserEntity;
import com.todo.repository.UserRepository;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {
	@Autowired
	private UserRepository userrepo;
	@GetMapping("/reg")
	public String showReg(Model model,User user) {
		model.addAttribute("user", new User());
		return "register";
	}
	// take values from form and save to db and move to login
	@PostMapping("/regsave")
	public String savereg(Model model,@Valid User user, BindingResult result) {
		System.out.println(user);
		 if (!user.getConfirmPassword().equals(user.getPassword())) {
		        result.rejectValue("confirmPassword", "error.confirmPassword", "Passwords do not match");
		    }
		
		if(result.hasErrors()) {
			//if invalid detials given redirect with error
			model.addAttribute("logb", new User());
			return "register";
		}else {
			//store to db 
			UserEntity entity = new UserEntity();
			BeanUtils.copyProperties(user,entity);
			userrepo.save(entity);
			//goto login page
			model.addAttribute("logb", new LogB());
			return "login";
		}

		
	}
}
