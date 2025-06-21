package com.todo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.todo.Binding.TaskB;
import com.todo.entity.TaskEntity;
import com.todo.repository.TaskRepository;

import jakarta.validation.Valid;

@Controller
public class TaskController {
	@Autowired
	private TaskRepository taskrepo;
	@GetMapping("/task")
	public String getTask(Model model,TaskB taskb) {
		//show task page
		model.addAttribute("taskb", new TaskB());
		model.addAttribute("tasks", taskrepo.findAll()); // Add this line so that next time ui always shows the tasks
		return "task";
	}
	@PostMapping("/saveTask")
	public String saveTask(Model model,@Valid TaskB taskb,BindingResult result) {
		// get task from form 
		if(result.hasErrors()) {
			model.addAttribute("taskb", taskb);              // ✅ bind form back
		    model.addAttribute("tasks", taskrepo.findAll()); // ✅ show list
			return "task";
		}
		System.out.println(taskb);
		//db save
		//1. data

		TaskEntity entity = new TaskEntity();
		BeanUtils.copyProperties(taskb, entity);
		//2. date + time
		entity.setTaskDate(new Date());
		//3. save
		taskrepo.save(entity);
		//dynamic display task on page
		List<TaskEntity> all = taskrepo.findAll();
		for(TaskEntity i:all) {
			System.out.println(i);
		}
		
//		model.addAttribute("taskb", new TaskB());
//		model.addAttribute("tasks", all);
//		
//		
//		return "task";
		 //  Redirect to prevent resubmission on refresh
	    return "redirect:/task";
	}
	 @GetMapping("/deleteTask/{id}")
	 public String deleteTask(@PathVariable Integer id,Model model) {
		//delete task
		 taskrepo.deleteById(id);
		//delete task from page
//		 model.addAttribute("taskb", new TaskB());
//		 model.addAttribute("tasks", taskrepo.findAll()); // Add this line so that next time ui always shows the tasks
//		 return "task";
		 return "redirect:/task";
	 }
	 @GetMapping("/logout")
	 public String logoutpg() {
		 return "redirect:/login";
	 }
	 
	 

	 
}
