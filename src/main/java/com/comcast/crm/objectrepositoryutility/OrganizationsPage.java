package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationsPage {
	@FindBy(name="search_text")
	private WebElement orgSearchEdt;
	
	@FindBy(name="search_field")
	private WebElement orgTypeSl;
	
	@FindBy(name="submit")
	private WebElement searchBTN;

	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrgSearchEdt() {
		return orgSearchEdt;
	}
	

	public WebElement getOrgTypeSl() {
		return orgTypeSl;
	}

	public WebElement getSearchBTN() {
		return searchBTN;
	}
	
	public void searchTheOrg(WebDriver driver, String orgName,String type)
	{
		orgSearchEdt.sendKeys(orgName);
		Actions a = new Actions(driver);
		a.click(orgTypeSl).perform();
		
		Select s = new Select(orgTypeSl);
		s.selectByContainsVisibleText(type);
		
		searchBTN.click();
	}
	
}
