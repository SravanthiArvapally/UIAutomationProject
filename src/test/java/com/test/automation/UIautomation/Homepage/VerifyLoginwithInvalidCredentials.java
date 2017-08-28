package com.test.automation.UIautomation.Homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.UIautomation.homePageActions.Homepage;

public class VerifyLoginwithInvalidCredentials {
	
	WebDriver driver;
	
	Homepage homepage;
	
	@BeforeTest
	public void setUp()
	{
		//For Windows
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Driver/geckodriver.exe");
		//For Mac
		//System.setProperty("webdriver.firefox,marionette", System.getProperty("user.dir")+"/Driver/geckodriver");
		String directory=System.getProperty("user.dir");
		driver=new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
		
	}
	
	@Test
	public void invalidLogin() {
		homepage=new Homepage(driver);
		homepage.logIntoApplication("test@gmail.com", "password123");
		Assert.assertEquals(homepage.getInvalidLoginText(), "Authentication failed.");
	}
	
	@AfterTest
	public void tear()
	{
		driver.close();
	}

}
