package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement header;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement actOrgName;
	
	@FindBy(xpath = "//span[@id='dtlview_Industry']/font")
	private WebElement actIndustryName;
	
	@FindBy(id="dtlview_Phone")
	private WebElement actPhoneNum;
	
	@FindBy(xpath="//a[text()='Organizations' and contains(@href,'parenttab=Marketing')]")
	private WebElement organizationsLink;
	
	@FindBy(xpath= "//a[text()='Contacts' and @href='index.php?module=Contacts&action=index']")
	private WebElement contactsLink;
	
	public WebElement getHeader() {
		return header;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getActOrgName() {
		return actOrgName;
	}

	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}
	
	public void checkOrgCreated(String orgName)//wrt name
	{
		if(header.getText().contains(orgName))
		{
			System.out.println("Org is verified === PASS");
		}
		else {
			System.out.println("Org is verified === FAIL");
		}
		
	}
	
	public void checkOrgCreated(String orgName,String industry)//wrt Industry
	{
		if((header.getText().contains(orgName)) && (actIndustryName.getText().contains(industry)))
		{
			System.out.println("Org with Industry is verified === PASS");
		}
		else {
			System.out.println("Org with Industry is verified === FAIL");
		}
		
	}
	
	public void checkOrgCreated(String orgName,String industry,String phoneNumber)//wrt Industry
	{
		if((header.getText().contains(orgName)) && (actIndustryName.getText().contains(industry)) && (actPhoneNum.getText().contains(phoneNumber)))
		{
			System.out.println("Org with Industry and Phone Number is verified === PASS");
		}
		else {
			System.out.println("Org with Industry and PhoneNumber is verified === FAIL");
		}
		
	}
	
	
	

}
