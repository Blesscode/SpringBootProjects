package com.form3.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.form3.Binding.Student;
import com.form3.Entity.StudentEntity;
import com.form3.Repository.StudentRepository;
@Controller
public class StudentController {

	//1. View form
	@Autowired
	private StudentRepository repo;
	@GetMapping("/")
	public String showform(Model model) {
		loadFormData(model);
		
		return "index";
	}

	private void loadFormData(Model model) {
		List<String>CoursesList=new ArrayList<>();
		CoursesList.add("java");
		CoursesList.add("Python");
		CoursesList.add("dotnet");
		CoursesList.add("AWS");
		
		List<String>TimingList=new ArrayList<>();
		TimingList.add("morning");
		TimingList.add("noon");
		TimingList.add("evening");
		
		
		
		Student st1=new Student();
		model.addAttribute("courses", CoursesList);
		model.addAttribute("timings", TimingList);
		model.addAttribute("student", st1);
	}
	
	//2. Handle after form submit
	@PostMapping("/save")
	public String saveData(Model model,Student student) {
		System.out.println(student);
		StudentEntity entity=new StudentEntity();
		BeanUtils.copyProperties(student, entity);//only copy primitive,wrapper datatypes not reference/user defines eg [array,collections etc]  
		//for time array data copy to entity
		entity.setTimings(Arrays.toString(student.getTimings()));
		repo.save(entity);
		model.addAttribute("msg", "data Saved");
		loadFormData(model);
		System.out.println(entity);
		return "index";
	}
	
	//3. Show the data
	@GetMapping("/viewStudents")
	public String viewStudents(Model model) {
		List<StudentEntity>StudentData=repo.findAll();
		for(StudentEntity a:StudentData) {
			System.out.println(a);
		}
		model.addAttribute("students",StudentData);
		return "datashow";
	}
	
	
}
