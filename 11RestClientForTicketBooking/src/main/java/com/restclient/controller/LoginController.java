package com.restclient.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.restclient.binding.Search;
import com.restclient.binding.Ticket;
import com.restclient.binding.User;
import com.restclient.service.TicketBookingService;

import jakarta.validation.Valid;

@Controller
public class LoginController {
	
	//get the service obj for performing logic
	@Autowired
	private TicketBookingService service;
	
	//show book ticket ui
	@GetMapping("/booking")
	public String getUI(Model model) {
		if(!model.containsAttribute("user") &&  !model.containsAttribute("search")) {
			model.addAttribute("user", new User());
			model.addAttribute("search", new Search());
		}
			
		return "login";
	}

	
	//handle get ticket request
	@GetMapping("/getTicket")
	public String getTicketAndShow(@RequestParam("ticketid") Integer ticketid,
	        Model model,
	        @ModelAttribute("search") Search search,
	        BindingResult result ) {
		if(result.hasErrors()) {
			return "login";
		}
		//get ticket -> from service
		Ticket ticket = service.getTicket(ticketid);
		model.addAttribute("ticket", ticket);
		return "show";
	}
	
	
	//handle book ticket request
	@PostMapping("/bookTicket")
	public String bookTicketAndShow(@Valid @ModelAttribute("user") User user,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("search", new Search()); // re-add other model objects
			return "login";
		}
		Ticket bookTicket = service.bookTicket(user);
		model.addAttribute("ticket", bookTicket);
		return "show";
	}
	
}
