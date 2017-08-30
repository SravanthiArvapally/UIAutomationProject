package com.test.automation.UIautomation.Homepage;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.UIautomation.homePageActions.Homepage;
import com.test.automation.UIautomation.testBase.TestBase;

public class VerifySignUpFunctionality extends TestBase{
	
	@BeforeClass
	public void setUp()throws Exception
	{
		init();
	}
	
	@Test
	public void signUp()
	{
		Homepage homepage=new Homepage(driver);
		homepage.clickOnSignIN();
		homepage.registerUser();
				
	}
	
	@AfterClass
	public void tear()
	{
		driver.quit();
	}


}
