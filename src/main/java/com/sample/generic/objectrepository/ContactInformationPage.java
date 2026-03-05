package com.sample.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerEl;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastNameEl;
	
	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']//a")
	private WebElement orgNameEl;

	@FindBy(id = "mouseArea_Support Start Date")
	private WebElement suppStartDateEl;
	
	@FindBy(id = "mouseArea_Support End Date")
	private WebElement suppEndDateEl;

	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderEl() {
		return headerEl;
	}
	public WebElement getOrgNameEl() {
		return orgNameEl;
	}

	public WebElement getSuppStartDateEl() {
		return suppStartDateEl;
	}

	public WebElement getSuppEndDateEl() {
		return suppEndDateEl;
	}

	public WebElement getLastNameEl() {
		return lastNameEl;
	}
	
	public void verifyContactLastName()
	{
		if(headerEl.getText().contains(lastNameEl.getText()))
		{
			System.out.println("Contact Creation Verfied === PASS");
		}
		else {
			System.out.println("Contact Creation Verified === FAIL");
		}
		
	}
	
	public void verifyContactWithSupDate(String suppStDate, String suppEndDate) {
		
		//SupportDate verify
		
		String spStrDate = suppStartDateEl.getText().strip();
		String spEndDate = suppEndDateEl.getText().strip();
		if((headerEl.getText().contains(lastNameEl.getText())) && (spStrDate.contains(suppStDate) && spEndDate.contains(suppEndDate)))
		{
			System.out.println("Contact with Support Start Date :" +suppStDate+ " and Support EndDate :" +suppEndDate+ " is created  === PASS");
		}
		else {
			System.out.println("Contact with Support Start Date :" +suppStDate+ " and Support EndDate :" +suppEndDate+ " is not created  === FAIL");
			System.out.println(suppStartDateEl.getText());
			System.out.println(suppEndDateEl.getText());
			
			System.out.println(suppStDate);
			System.out.println(suppEndDate);

		}
	}
	
	public void verifyContactWithOrg(String orgName,String lastName)
	{
		if((headerEl.getText().contains(lastName)) && orgNameEl.getText().contains(orgName))
		{
			System.out.println("Contact with lastname "+lastName+" and Organization "+orgName+ " is created === PASS");
		}
		else {
			System.out.println("Contact with lastname "+lastName+" and Organization "+orgName+ " is not created === FAIL");
		}
	}
	
}
