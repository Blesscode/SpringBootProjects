package com.form2.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Locators
	private By usernameInform= By.xpath("//td[text(),'Name:']");
	private By emailTyped = By.xpath("//td[text()='Email:]");
	private By genderMaleRadio = By.xpath("//input[@name='gender' and @value='Male']");
	private By genderFemaleRadio = By.xpath("//input[@name='gender' and @value='Female']");
	private By courseDropdown = By.id("course");
	private By timingsCheckboxes = By.name("timings"); // Multiple checkboxes, same name
	private By submitButton = By.xpath("//input[@type='submit']");
	
	// Actions
	public void enterName(String name) {
        driver.findElement(usernameInform).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailTyped).sendKeys(email);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(genderMaleRadio).click();
        } else {
            driver.findElement(genderFemaleRadio).click();
        }
    }

    public void selectCourse(String value) {
        Select select = new Select(driver.findElement(courseDropdown));
        select.selectByValue(value);
    }

    public void selectTimings(List<String> desiredValues) {
        List<WebElement> checkboxes = driver.findElements(timingsCheckboxes);
        for (WebElement box : checkboxes) {
            String value = box.getAttribute("value");
            if (desiredValues.contains(value) && !box.isSelected()) {
                box.click();
            }
        }
    }

    public void submitForm() {
    	 driver.findElement(submitButton).click();
    }
	
}
