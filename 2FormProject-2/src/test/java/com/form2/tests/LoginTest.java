package com.form2.tests;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.form2.pages.LoginPage;

public class LoginTest {
	// we did't used jUnit so using psvm
	public static void main(String args[]) {
	//1. create driver instance
	WebDriver driver=new ChromeDriver();
	
	try{
		//2. goto url
		driver.get("https://localhost:8080/");
		//3. max window
		driver.manage().window().maximize();
		//4. create page object model
		LoginPage page=new LoginPage(driver);
		//5. access methods
		page.enterName("raja");
		page.enterEmail("raja@gmail");
		page.selectGender("male");
		page.selectCourse("aws");
		page.selectTimings(Arrays.asList("Morning", "Evening"));
		
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
		//close browser
		driver.quit();
	}
  }
}
