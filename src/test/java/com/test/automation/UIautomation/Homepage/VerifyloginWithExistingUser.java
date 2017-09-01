package com.test.automation.UIautomation.Homepage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.UIautomation.homePageActions.Homepage;
import com.test.automation.UIautomation.testBase.TestBase;

public class VerifyloginWithExistingUser extends TestBase{
	@BeforeClass
	public void setUp()throws Exception
	{
		init();
	}
	
	@DataProvider(name="login")
    public Object[][] getTestData()
    {
		Object[][] testRecords=getExcelData("Testdata.xlsx", "ExistingUser");
		return testRecords;
    }
	
	@Test(dataProvider="login")
	public void loginWithExistingUser(String emailaddress, String password)
	{
		Homepage homepage=new Homepage(driver);
		homepage.clickOnSignIN();
		System.out.println("email address is "+ emailaddress + "password is " + password);
		homepage.logIntoApplication(emailaddress, password);
		homepage.verifySignoutLink();
	}
	
	@AfterClass
	public void tear()
	{
		driver.quit();
	}
	

}
