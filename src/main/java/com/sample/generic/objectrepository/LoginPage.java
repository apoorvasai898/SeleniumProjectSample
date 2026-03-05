package com.sample.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule - 1 : Create separate java Class for every page
						//Rule - 2 : Object creation (Identify all the Elements using @FindBy annotation).
	
	@FindBy(name = "user_name")
	public WebElement usernameEdt;
	
	@FindBy(name = "user_password")
	public WebElement passwordEdt;
	

	@FindBy(id="submitButton")
	public WebElement loginBtn;
	
	//Rule - 3 : Object Initialization should be done inside the Constructor
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Rule - 4 Object Encapsulation
	

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//Provide Action
	public void loginToApp(String username,String password)
	{
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
}
