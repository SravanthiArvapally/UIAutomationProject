package com.test.automation.UIautomation.productDetailsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.UIautomation.testBase.TestBase;

public class ProductPageActions extends TestBase{
	WebDriver driver;
	
	@FindBy(xpath="//p[@id='add_to_cart']/button")
	WebElement cartButtonOnProductPage;
	
	@FindBy(xpath="//p[@id='quantity_wanted_p']/a/span/i[@class='icon-plus']")
	WebElement incQuantity;
	
	@FindBy(xpath="//p[@id='quantity_wanted_p']/a/span/i[@class='icon-minus']")
	WebElement decQuantity;
	
	@FindBy(xpath="//input[@id='quantity_wanted']")
	WebElement quantityValue;
	
	@FindBy(xpath="//div[@class='clearfix']/div[starts-with(@class,'layer_cart_cart')]")
	WebElement checkoutPopupOnProductPage;
	
	@FindBy(xpath="//div[@class='button-container']/a/span")
	WebElement checkoutButtonOnProductPage;
	
	public ProductPageActions(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public final String printedDress="Printed Dress";
	public final String shortSleevTshirt="Faded Short Sleeve T-shirts";
	
	//To select particular product by name
	public void selectProduct(String ProductName)
	{
		try
		{
			if(driver.findElement(By.xpath("//div[@class='product-container']/div[@class='right-block']/h5//a[@title='"+ProductName+"']")).isDisplayed())
			{
				driver.findElement(By.xpath("//div[@class='product-container']/div[@class='right-block']/h5//a[@title='"+ProductName+"']")).click();
			}
					
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}		
	}
	public void verifyCartButtonOnProductPage()
	{
		cartButtonOnProductPage.isDisplayed();
	}
	
	public void clickOnCartButtonOnProductPage()
	{
		cartButtonOnProductPage.click();
	}
	
	public int getQuantity()
	{
		String Quantity=quantityValue.getAttribute("value");
		int Quantityvalue=Integer.parseInt(Quantity);
		System.out.println("Quantity is:"+ Quantityvalue);
		return Quantityvalue;
		
	}
	
	//Method to increase quantity on product page
	public void increaseQuantityOnProductPage(int Quantity)
	{
		int oldQuantity=getQuantity();
		for(int i=oldQuantity;i<Quantity;i++)
		{
			incQuantity.click();
		}
	}
	public void decreaseQuantityOnProductPage(int Quantity)
	{
		int oldQuantity=getQuantity();
		
		for(int i=oldQuantity;i>Quantity;i--)
		{
			decQuantity.click();
		}
	}
	public void checkoutOnProductPage()throws Exception
	{
		Thread.sleep(1000);
		//waitForElement(checkoutPopupOnProductPage, 60);
		checkoutButtonOnProductPage.click();
	}
	
	
}
