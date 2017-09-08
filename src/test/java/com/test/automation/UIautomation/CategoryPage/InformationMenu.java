package com.test.automation.UIautomation.CategoryPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.automation.UIautomation.categoryPageActions.CategoryPage;
import com.test.automation.UIautomation.testBase.TestBase;

public class InformationMenu extends TestBase{
	CategoryPage catPage;
	@BeforeClass
	public void setUp()throws Exception
	{
		init();
	}
	
	@Test
	public void informationMenuOnCategoryPage()
	{
		catPage=new CategoryPage(driver);
		catPage.informationBlockMenu(catPage.delivery);
		catPage.deliveryPageVerification();
		navigateBack();
		catPage.informationBlockMenu(catPage.legal_Notice);
		catPage.legalpageVerification();
		navigateBack();
		catPage.informationBlockMenu(catPage.terms_and_conditions);
		catPage.termsAndConditionsPageVerification();
		navigateBack();
		catPage.informationBlockMenu(catPage.about_us);
		catPage.aboutUsPageVerification();
		navigateBack();
		catPage.informationBlockMenu(catPage.secure_Payment);
		catPage.securePaymentPageVerification();
		navigateBack();
		catPage.informationBlockMenu(catPage.our_Stores);
		catPage.ourStoresPageVerification();
		navigateBack();
		
	}

	@AfterClass
	public void tear()
	{
		closeBrowser();
	}
	

}
