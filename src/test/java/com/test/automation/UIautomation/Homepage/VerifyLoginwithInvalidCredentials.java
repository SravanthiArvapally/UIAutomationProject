package com.test.automation.UIautomation.Homepage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import com.test.automation.UIautomation.homePageActions.Homepage;
import com.test.automation.UIautomation.testBase.TestBase;

public class VerifyLoginwithInvalidCredentials extends TestBase{
	
	public static final Logger log=Logger.getLogger(VerifyLoginwithInvalidCredentials.class.getName());
	
	@BeforeClass
	public void setUp()throws Exception
	{
		init();
	}
	
	@Test
	public void loginwithInvalidCredentials() {
		log.info("===Starting LoginwithInvalidCredentials Test===");
		Homepage homepage=new Homepage(driver);
		homepage.clickOnSignIN();
		homepage.logIntoApplication("test@gmail.com", "password123");
		AssertJUnit.assertEquals(homepage.getInvalidLoginText(), "Authentication failed.");
		log.info("===Finished LoginwithInvalidCredentials Test===");
	}
	
	@AfterClass
	public void tear()
	{
		driver.quit();
	}

}
