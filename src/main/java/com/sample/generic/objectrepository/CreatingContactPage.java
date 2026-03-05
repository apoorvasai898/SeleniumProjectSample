package com.sample.generic.objectrepository;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingContactPage {
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/..//img[@title='Select']")
	private WebElement selectOrgBtn;
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	
	@FindBy(id="jscal_field_support_start_date")
	private WebElement startDateEdt;
	
	@FindBy(id="jscal_field_support_end_date")
	private WebElement endDateEdt;
	
	public CreatingContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSelectOrgBtn() {
		return selectOrgBtn;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getStartDateEdt() {
		return startDateEdt;
	}

	public WebElement getEndDateEdt() {
		return endDateEdt;
	}
	
	public void switchToChildWin(WebDriver driver, String partialUrl)
	{
		Set<String> winIds = driver.getWindowHandles();
		for(String id:winIds)
		{
			driver.switchTo().window(id);
			String currUrl = driver.getCurrentUrl();
			if(currUrl.contains(partialUrl))
			{
				break;
			}
		}
	}
	
	public void switchToParentWin(WebDriver driver, String partialUrl)
	{
		Set<String> winIds = driver.getWindowHandles();
		for(String id:winIds)
		{
			driver.switchTo().window(id);
			String currUrl = driver.getCurrentUrl();
			if(currUrl.contains(partialUrl))
			{
				break;
			}
		}
	}

}
