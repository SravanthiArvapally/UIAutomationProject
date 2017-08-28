package com.test.automation.UIautomation.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class TestBase {
	
	public WebDriver driver;
	String url="http://automationpractice.com/index.php";
	
	
	public void selectBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"));
		{
		//For Windows
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Driver/geckodriver.exe");
				//For Mac
				
				//System.setProperty("webdriver.firefox,marionette", System.getProperty("user.dir")+"/Driver/geckodriver");
			}
	}
	
	public void getUrl()
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	

}
