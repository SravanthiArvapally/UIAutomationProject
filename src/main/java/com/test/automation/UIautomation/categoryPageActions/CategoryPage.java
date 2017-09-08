package com.test.automation.UIautomation.categoryPageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.UIautomation.testBase.TestBase;

import junit.framework.Assert;

public class CategoryPage extends TestBase{
	
	WebDriver driver;
	
	public final String delivery="Delivery";
	public final String legal_Notice="Legal Notice";
	public final String terms_and_conditions="Terms and conditions of use";
	public final String about_us="About us";
	public final String secure_Payment="Secure payment";
	public final String our_Stores="Our stores";
	public final String delivery_Header_Text="Shipments and returns";
	public final String legal_Header_Text="Legal";
	public final String terms_And_Conditions_Header_Text="Terms and conditions of use";
	public final String about_Us_Header_Text="About us";
	public final String secure_Payment_Header_Text="Secure payment";
	public final String our_Stores_Header_Text="Our store(s)!";
	
	
	/*@FindBy(xpath="//div[@class='block_content list-block']/ul/li/a[@title='\"+menuName+\"']")
	WebElement informationMenu;*/
	public CategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void informationBlockMenu(String menuName)
	{
		driver.get("http://automationpractice.com/index.php?id_category=5&controller=category");
		//informationMenu.click();
		driver.findElement(By.xpath("//div[@class='block_content list-block']/ul/li/a[@title='"+menuName+"']")).click();
		
	}
	
	public void deliveryPageVerification()
	{
		Assert.assertTrue(driver.getPageSource().contains(delivery_Header_Text));
				
	}
	
	public void legalpageVerification()
	{
		Assert.assertTrue(driver.getPageSource().contains(legal_Header_Text));
	}
	
	public void termsAndConditionsPageVerification()
	{
		Assert.assertTrue(driver.getPageSource().contains(terms_And_Conditions_Header_Text));
		
	}
	public void aboutUsPageVerification()
	{
		Assert.assertTrue(driver.getPageSource().contains(about_Us_Header_Text));
	}
	
	public void securePaymentPageVerification()
	{
		Assert.assertTrue(driver.getPageSource().contains(secure_Payment_Header_Text));
	}
	
	public void ourStoresPageVerification()
	{
		Assert.assertTrue(driver.getPageSource().contains(our_Stores_Header_Text));
	}
}
