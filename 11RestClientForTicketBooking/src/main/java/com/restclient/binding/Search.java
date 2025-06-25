package com.restclient.binding;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Search {
	@NotEmpty(message="enter some id")
	private Integer ticketid;
}
