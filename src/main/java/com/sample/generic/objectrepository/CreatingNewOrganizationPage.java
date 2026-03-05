package com.sample.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="ship_street")
	private WebElement orgAddrEdt;
	
	@FindBy(name="assigned_user_id")
	private WebElement assignedToSlEle;
	
	@FindBy(id="phone")
	private WebElement phoneNumEdt;
	
	@FindBy(name="industry")
	private WebElement industrySlEl;
	
	@FindBy(xpath="//textarea[@class='detailedViewTextBoxOn']/ancestor::tr[@style='height:25px']/following-sibling::tr/descendant::input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getOrgAddrEdt() {
		return orgAddrEdt;
	}

	public WebElement getAssignedToSlEle() {
		return assignedToSlEle;
	}

	public WebElement getPhoneNumEdt() {
		return phoneNumEdt;
	}

	public WebElement getIndustrySlEl() {
		return industrySlEl;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public CreatingNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
	
	//Create Organization only with the OrganizationName createOrg(oevrLoaded Method)
	public void createOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	//Create Org with OrgName,Assigned To and Organization Address createOrg(Overloaded Method)
	public void createOrg(String orgName,String assignedTo,String orgAddress)
	{
		orgNameEdt.sendKeys(orgName);
		Select s = new Select(assignedToSlEle);
		s.selectByContainsVisibleText(assignedTo);
		orgAddrEdt.sendKeys(orgAddress);
		saveBtn.click();
	}
	
	//Create Org with OrgName,Assigned To ,Industry and Organization Address createOrg(Overloaded Method)
	public void createOrg(String orgName,String assignedTo, String industry,String orgAddress)
	{
		orgNameEdt.sendKeys(orgName);
		Select s = new Select(industrySlEl);
		s.selectByValue(industry);
		Select s1 = new Select(assignedToSlEle);
		s1.selectByContainsVisibleText(assignedTo);
		orgAddrEdt.sendKeys(orgAddress);
		saveBtn.click();
	}
	
	//Create Org with OrgName,Assigned To ,Industry ,Phone Number and Organization Address createOrg(Overloaded Method)
		public void createOrg(String orgName,String assignedTo, String industry,String phoneNumber,String orgAddress)
		{
			orgNameEdt.sendKeys(orgName);
			Select s = new Select(industrySlEl);
			s.selectByValue(industry);
			Select s1 = new Select(assignedToSlEle);
			s1.selectByContainsVisibleText(assignedTo);
			phoneNumEdt.sendKeys(phoneNumber);
			orgAddrEdt.sendKeys(orgAddress);
			saveBtn.click();
		}
	

}
