package com.test.automation.UIautomation.productPageTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.UIautomation.homePageActions.Homepage;
import com.test.automation.UIautomation.productDetailsPage.ProductPageActions;
import com.test.automation.UIautomation.testBase.TestBase;

public class VerifyAddtoCartOnProductPage extends TestBase{

	@BeforeClass
	public void setUp()throws Exception
	{
		init();
	}
	
	@Test
	public void verifyAddtoCart() throws Exception
	{
		Homepage homepage=new Homepage(driver);
		//homepage.navMenusOnHomePage(driver, homepage.dressesText);
		
		homepage.subMenuNavforWomen(homepage.womenText,homepage.dresses,homepage.casualDresses);
		Thread.sleep(500);
		ProductPageActions productPage=new ProductPageActions(driver);
		productPage.selectProduct(productPage.printedDress);
		productPage.verifyCartButtonOnProductPage();
		productPage.increaseQuantityOnProductPage(3);
		Thread.sleep(500);
		productPage.clickOnCartButtonOnProductPage();
		productPage.checkoutOnProductPage();
		Thread.sleep(500);
		
	}
	
	@AfterClass
	public void tear()
	{
		closeBrowser();
	}
}
