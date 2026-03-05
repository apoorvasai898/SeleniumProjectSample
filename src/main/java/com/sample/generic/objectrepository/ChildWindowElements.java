package com.sample.generic.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ChildWindowElements {
	@FindBy(id="search_txt")
	private WebElement searchEd;
	
	@FindBy(name="search_field")
	private WebElement inSl;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	public ChildWindowElements(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchEd() {
		return searchEd;
	}

	public WebElement getInSl() {
		return inSl;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	public void clickOnResult(WebDriver driver,String orgName) {
		driver.findElement(By.xpath("//tr//td//a[contains(text(),'"+orgName+"')]")).click();
	}

	public void selectTheIn(String value)
	{
		Select s = new Select(inSl);
		s.selectByContainsVisibleText(value);
	}
	
}
