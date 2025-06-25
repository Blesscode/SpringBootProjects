package com.restclient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.restclient.binding.Ticket;
import com.restclient.binding.User;

@Service
public class TicketBookingService {
	
	//endpoints url
	@Value("${ticketbooking.endpoint.get.ticket}")
	private String TICKET_GET_API;
	@Value("${ticketbooking.endpoint.book.ticket}")
	private String BOOK_TICKET_API;

	//get ticket
	public Ticket getTicket(Integer ticketid) {
		
		WebClient client = WebClient.create();
		Ticket ticket = client
				.get() 									//get req
				.uri(TICKET_GET_API,ticketid)			//api url + data[send from url in get]
				.accept(MediaType.APPLICATION_JSON)		//accepting type of data, no header needed since only id is sending no json/xml data sending
				.retrieve()								//get data
				.bodyToMono(Ticket.class)				//convert data to obj
				.block();								//synchronous req
		
		if(ticket!=null) {
			return ticket;
		}
		return null;
		
			
		
	}
	
	//perform booking
	public Ticket bookTicket(User user) {
		WebClient client = WebClient.create();
		Ticket ticket = client
				.post()											//post req
				.uri(BOOK_TICKET_API)							//api url
				.body(BodyInserters.fromValue(user))			// data send from body in post
				.header("Content-Type", "application/json")		// since post send data in json format so header needed
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(Ticket.class)
				.block();
		if(ticket!=null) {
			return ticket;
		}
		return null;
	}
	

}
