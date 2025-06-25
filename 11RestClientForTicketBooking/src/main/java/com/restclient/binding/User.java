package com.restclient.binding;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
//@XmlRootElement
@Data
public class User {
	@NotNull(message="enter some date")
	private Integer date;
	@NotEmpty(message="enter some name")
	private String name;
	@NotEmpty(message="enter valid loc")
	private String to; 
	@NotEmpty(message="enter valid loc")
	private String from;
	@NotNull(message="enter some train no")
	private Integer trainno;

}
