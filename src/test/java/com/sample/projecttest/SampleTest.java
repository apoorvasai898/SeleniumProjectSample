package com.sample.projecttest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.sample.generic.fileutility.ExcelUtility;
import com.sample.generic.fileutility.FileUtility;
import com.sample.generic.webdriverutility.JavaUtility;
import com.sample.generic.webdriverutility.WebDriverUtility;

public class SampleTest {
	@Test
	public void createContactTest() throws IOException {

		// Objects of the UtilityClass
		FileUtility flUtility = new FileUtility();
		WebDriverUtility wbUtility = new WebDriverUtility();
		ExcelUtility exUtility = new ExcelUtility();
		JavaUtility jUtility = new JavaUtility();

//		Open the Browser // navigate to URL // Login
		String BROWSER = flUtility.getDataFromPropertyFile("browser");
		String URL = flUtility.getDataFromPropertyFile("url");
		String USERNAME = flUtility.getDataFromPropertyFile("username");
		String PASSWORD = flUtility.getDataFromPropertyFile("password");
		String timeOut = flUtility.getDataFromPropertyFile("timeOut");

		// Get data from the Excel
		int randomNumber = jUtility.getRandomNumber();
		String lastName = exUtility.getDataFromExcel("con", 1, 2) + randomNumber;

		String assignedTo = exUtility.getDataFromExcel("org", 1, 3);

		WebDriver driver = null;
		// Open browser
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}

		// Navigat to the URL
		wbUtility.maximize(driver);
		wbUtility.waitForPageToLoad(driver, timeOut);
		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

//		Create Con
		driver.findElement(By.xpath("//td[@class='small']/descendant::a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[contains(@alt,'Create Con')]")).click();

		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		WebElement assigned_Drpdown = driver.findElement(By.xpath("//select[@name='assigned_user_id']"));
		wbUtility.select(assigned_Drpdown, assignedTo);

		driver.findElement(By.xpath(
				"//input[@type='file']/ancestor::tr[@style='height:25px']/following-sibling::tr//input[@title='Save [Alt+S]']"))
				.click();

//		Verify
		// Verify last name
		if (driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText()
				.contains(driver.findElement(By.id("dtlview_Last Name")).getText())) {
			System.out.println("Contact created with lastname: " + lastName + " successfully ===PASS");
		} else {
			System.out.println("Failed to create contact with lastname: " + lastName + " ===FAIL");
		}
	}
}
