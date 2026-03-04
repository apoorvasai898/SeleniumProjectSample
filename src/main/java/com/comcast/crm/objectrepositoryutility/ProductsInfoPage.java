package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsInfoPage {
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement header;
	
	@FindBy(xpath = "//span[@id='dtlview_Product Name']")
	private WebElement prodNameEl;
	
	public ProductsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getHeader() {
		return header;
	}

	public WebElement getProdNameEl() {
		return prodNameEl;
	}
	
	public void checkCreationOfProduct()
	{
		if(header.getText().contains(prodNameEl.getText()))
		{
			System.out.println("Product Created ===PASS");
		}
		else {
			System.out.println("Product is not Created ====FAIL");
		}
	}
	

}
