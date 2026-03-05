package com.sample.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	@FindBy(xpath = "//img[contains(@alt,'Create Contact')]")
	private WebElement createContactBtn;

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
}
