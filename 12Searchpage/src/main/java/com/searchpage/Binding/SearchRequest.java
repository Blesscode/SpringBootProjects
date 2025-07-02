package com.searchpage.Binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchRequest {
	//whatever data comes from the form bind that data to this obj : form binding obj 
	private String name;
	private String status;
	private String gender;
	private LocalDate startDate;
	private LocalDate endDate;
}
