package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewProductPage {
	@FindBy(name="productname")
	private WebElement productNameEdt;
	
	@FindBy(xpath = "//textarea[@class='detailedViewTextBox']/ancestor::tr[@style='height:25px']/following-sibling::tr/descendant::input[@title='Save [Alt+S]']")
	private WebElement saveProdBtn;
	
	@FindBy(name="sales_start_date")
	private WebElement salesStartDateEd;
	
	@FindBy(name="sales_end_date")
	private WebElement salesEndDateEd;
	
	@FindBy(name="start_date")
	private WebElement supportStartDateEd;
	
	@FindBy(name="expiry_date")
	private WebElement supportEndDateEd;
	
	@FindBy(name="assigned_user_id")
	private WebElement handlerSelect;

	@FindBy(name="productcategory")
	private WebElement prodCateSelect;

	public WebElement getSaveProdBtn() {
		return saveProdBtn;
	}

	public WebElement getSalesStartDateEd() {
		return salesStartDateEd;
	}

	public WebElement getSalesEndDateEd() {
		return salesEndDateEd;
	}

	public WebElement getSupportStartDateEd() {
		return supportStartDateEd;
	}

	public WebElement getSupportEndDateEd() {
		return supportEndDateEd;
	}

	public WebElement getHandlerSelect() {
		return handlerSelect;
	}
	
	public WebElement getProdCateSelect() {
		return prodCateSelect;
	}
	
	public CreatingNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductNameEdt() {
		return productNameEdt;
	}

	public WebElement getsaveProdBtn() {
		return saveProdBtn;
	}
	
	public void selectHandler(String value)
	{
        WebDriverUtility wdUtility = new WebDriverUtility();
        wdUtility.select(handlerSelect, value);
        
	}
	
	public void selectProdCat(String value)
	{
        WebDriverUtility wdUtility = new WebDriverUtility();
        wdUtility.select(prodCateSelect, value);
        
	}
	public void createProd(String productName)
	{
		productNameEdt.sendKeys(productName);
		saveProdBtn.click();		
	}

}
