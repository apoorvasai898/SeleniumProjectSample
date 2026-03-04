package com.comcast.crm.generic.baseutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.CommonElements;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	public WebDriver driver = null;
	public FileUtility fUtility = new FileUtility();
	@BeforeSuite(groups = {"ST","RT"})
	public void connectDb()
	{
		System.out.println("Connected to DataBase");
	}
	
	@BeforeClass(groups = {"ST","RT"})
	public void launchBrowser() throws IOException
	{
		String BROWSER = fUtility.getDataFromPropertyFile("browser");
		String URL = fUtility.getDataFromPropertyFile("url");
		String timeOut = fUtility.getDataFromPropertyFile("timeout");
		int timeOutInt = Integer.parseInt(timeOut);
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOutInt));
		driver.get(URL);
		
	}
	
	@BeforeMethod(groups = {"ST","RT"})
	public void login() throws IOException
	{
		String USERNAME = fUtility.getDataFromPropertyFile("username");
		String PASSWORD = fUtility.getDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.usernameEdt.sendKeys(USERNAME);
		lp.passwordEdt.sendKeys(PASSWORD);
		lp.loginBtn.click();
	}
	
	@AfterSuite(groups = {"ST","RT"})
	public void disconnectDb()
	{
		System.out.println("Closed the DB Connection");
	}
	
	@AfterClass(groups = {"ST","RT"})
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@AfterMethod(groups = {"ST","RT"})
	public void logout()
	{
		CommonElements ce = new CommonElements(driver);
		ce.signOutofApp();
	}

}
