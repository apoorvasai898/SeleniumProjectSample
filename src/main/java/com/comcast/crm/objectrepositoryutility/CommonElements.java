package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonElements {
	@FindBy(xpath="//img[contains(@src,'user.PNG')]")
	private WebElement profileIcon;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutBtn;
	
	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}

	WebDriver driver;
	public CommonElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void signOutofApp()
	{
		Actions act = new Actions(driver);
		act.click(profileIcon).build().perform();
		act.click(signOutBtn).build().perform();
	}
	

}
