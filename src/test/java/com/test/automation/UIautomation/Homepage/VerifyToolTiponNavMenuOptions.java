package com.test.automation.UIautomation.Homepage;
import org.openqa.selenium.By;
/*
 * Test script to verify the tool tips present on navigation bar on Home page
 */
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.UIautomation.homePageActions.Homepage;
import com.test.automation.UIautomation.testBase.TestBase;

public class VerifyToolTiponNavMenuOptions extends TestBase{
	@BeforeClass
	public void setUp()throws Exception
	{
		init();
	}
	
	@Test
	public void verifyTooltiponNavMenus() throws Exception
	{
		Homepage homepage=new Homepage(driver);
		/*homepage.navMenusOnHomePage(driver,homepage.womenText);
		homepage.getTooltipTextforNavMenuonHomePage(homepage.womenText);
		homepage.navMenusOnHomePage(driver,homepage.dressesText);
		homepage.getTooltipTextforNavMenuonHomePage(homepage.dressesText);
		homepage.navMenusOnHomePage(driver,homepage.tshirtsText);
		homepage.getTooltipTextforNavMenuonHomePage(homepage.tshirtsText);
		homepage.subNavMenu(homepage.womenText,homepage.blouses);*/
		
	}
	
	@AfterClass
	public void tear()
	{
		closeBrowser();
	}
}
