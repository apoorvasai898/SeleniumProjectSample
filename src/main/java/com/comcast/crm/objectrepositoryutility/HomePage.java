package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath="//a[contains(@href,'Accounts&action') and text()='Organizations']")
	private WebElement organizationsLink;
	
	@FindBy(xpath="//img[contains(@alt,'Cre')]")
	private WebElement addOrg;
	
	@FindBy(xpath = "//a[contains(text(),'Prod')]")
	private WebElement ProductLink;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement ContactsLink;

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getProductLink() {
		return ProductLink;
	}

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnOrgLink()
	{
		organizationsLink.click();
	}
	
	public void clickOnAddBtn()
	{
		addOrg.click();
	}
	
	public void clickOnConLink()
	{
		ContactsLink.click();
	}

}
