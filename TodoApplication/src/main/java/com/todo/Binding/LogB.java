package com.todo.Binding;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LogB {
	@NotEmpty(message = "Email is required")
	@Pattern(
		    regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
		    message = "Invalid email format"
		)
	private String email;
	@NotEmpty(message = "Password is required")
	@Pattern(
			 regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{7,}$",
			    message = "Password must be at least 7 characters and include a digit, a lowercase, an uppercase, and a special character"
			)
	private String password;
}
