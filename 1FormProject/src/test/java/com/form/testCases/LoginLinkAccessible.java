package com.form.testCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//open browser
	// open url
	//validate title user registration present
	//close browser

public class LoginLinkAccessible {

	
	public static void main(String args[]) {
		//1. open browser (chrome) : auto launch the chrome browser
				//[1]ChromeDriver driver1=new ChromeDriver();
			 	//[2]WebDriver driver2=new ChromeDriver();		**better**:since i can add any child browser driver to parent webDriver
		WebDriver driver=new ChromeDriver();
		
		//2. open url
		driver.get("https://google.com");
		 
		//3. validate title user registration present
		String visible_title=driver.getTitle();
		if(visible_title.equals("user registration")) {
			System.out.println("test passes");
		}else {
			System.out.println("test failed");
		}
		
		//4.close browser
		//[1]driver.close();
		//[2]driver.quit();
		
	}
	
	
}
