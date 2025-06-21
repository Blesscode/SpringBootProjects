package com.todo.Binding;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TaskB {
	@NotEmpty(message="Empty task cannot be created")
	private String taskData;

}
