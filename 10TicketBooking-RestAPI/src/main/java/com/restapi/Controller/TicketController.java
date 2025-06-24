package com.restapi.Controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.Binding.Ticket;
import com.restapi.Binding.User;

@RestController
public class TicketController {
	  HashMap<Integer,Ticket> mpp = new HashMap<>();
	  //endpoint1
	@PostMapping(
			value="/bookTicket",
			produces= {"application/json" , "application/xml"},
			consumes={"application/json" , "application/xml"}
			)
	// recieve user details
	public Ticket bookTicket(@RequestBody User user) {
		//send ticket details
		
		Ticket obj = new Ticket();
		obj.setTrainno(user.getTrainno());
		obj.setTo(user.getTo());
		obj.setFrom(user.getFrom());
		obj.setCost(200);
		obj.setStatus("ok");
		obj.setTicketid(100); //got this
		
		//save to hash map
		mpp.put(obj.getTicketid(),obj);
		
		return obj ;
	}
	
	//endpoint2
	@GetMapping(
			value="/getTicket/{id}",
			produces={"application/json" , "application/xml"}
			)
	public Ticket getTicket(@PathVariable("id") Integer ticketid) {
		if(mpp.containsKey(ticketid)) {
			return mpp.get(ticketid);
		}
		
		return null;
	}
}
