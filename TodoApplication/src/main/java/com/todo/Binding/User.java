package com.todo.Binding;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class User {
	@NotEmpty(message = "enter name")
	private String name;
	@NotEmpty
	@Pattern(
		    regexp = "^[1-5][0-9]{4}$",
		    message = "Phone number must be exactly 5 digits and start with 1-5"
		)
	private String phno;
	@NotEmpty
	@Pattern(
		    regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
		    message = "Invalid email format"
		)
	private String email;
	@NotEmpty
	@Pattern(
			 regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{7,}$",
			    message = "Password must be at least 7 characters and include a digit, a lowercase, an uppercase, and a special character"
			)
	private String password;
	@NotEmpty(message = "Confirm password is required")
	private String confirmPassword;
}
