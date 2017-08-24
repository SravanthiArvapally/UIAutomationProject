package com.test.automation.UIautomation.Homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class verifyLoginwithInvalidCredentials {
	WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Driver/geckodriver.exe");
		String directory=System.getProperty("user.dir");
		System.out.println("Directory is" +System.getProperty("user.dir"));
		driver=new FirefoxDriver();
	}
	
	@AfterTest
	public void tear()
	{
		
	}
	
	@Test
	public void launchURL()
	{
		driver.findElement(By.xpath("//div[@class=\"header_user_info\"]/a[@class=\"login\"]")).click();
	}
	@Test
	public void invalidLogin() {
		
	}

}
