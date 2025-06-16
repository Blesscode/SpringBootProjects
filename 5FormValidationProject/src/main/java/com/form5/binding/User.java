package com.form5.binding;

import java.util.List;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class User {
	/*
	 * NotNull= integers
	 * NotEmpty,size= is only valid for String, Collection, arrays, and maps*/
	@NotNull
	//annotations like @NotEmpty, you must always explicitly define message="..." or they will use the default from the validation API (must not be empty, size must be between..., etc.).
	private Integer uid;
	
	@NotEmpty(message="Enter a valid fnam")
	private String fname;
	
	@NotEmpty
	private String lname;
	
	
	@NotNull(message = "Phone number is required")
	@Min(value=10,message="Phone number must be at least 10 digit")
	private Integer phoneno;
	
//	@NotEmpty(message="password is reuired in size")
//	@Size(min=3,max=5,message="Password must be between 3 and 5 characters")
	@Pattern(
		    regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{7,}$",
		    message = "Password must be at least 7 characters and include a digit, a lowercase, an uppercase, and a special character"
		)
	private String upassword;
	
	 @NotEmpty(message = "Please select a gender")
	 private String gender;

	 @NotEmpty(message = "Please select a course")
	 private String course;
	 
	 @Size(min = 1, message = "Select at least one city")
	 private List<String> cities;

	 @AssertTrue(message = "You must agree to the terms")
	 private boolean agreed;
	 
	public String getGender() {
		return gender;
	}
	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public boolean isAgreed() {
		return agreed;
	}
	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getfname() {
		return fname;
	}
	public void setfname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Integer getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(Integer phoneno) {
		this.phoneno = phoneno;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", fname=" + fname + ", lname=" + lname + ", phoneno=" + phoneno + ", upassword="
				+ upassword + ", gender=" + gender + ", course=" + course + ", cities=" + cities + ", agreed=" + agreed
				+ "]";
	}
	
	
}
