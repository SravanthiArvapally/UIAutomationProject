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
		
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("12334h6345@gmail.com");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		driver.findElement(By.xpath("(//div[@class='radio-inline']/label/div/span)[2]")).click();
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("sdgasfhadfhasd");
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("dghsdywerasf");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("password1");
		
		/*Select days=new Select(driver.findElement(By.id("days")));
		days.selectByVisibleText("13  ");
		
		Select months=new Select(driver.findElement(By.id("months")));
		months.selectByVisibleText("April ");
		
		Select years=new Select(driver.findElement(By.id("years")));
		years.selectByVisibleText("1998  ");*/
		
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Mumbai");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("city is also Mumbai");
		Select state=new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("Alaska");
		driver.findElement(By.id("postcode")).sendKeys("35346");
		driver.findElement(By.id("phone_mobile")).sendKeys("364575678456");
		driver.findElement(By.id("alias")).sendKeys("India Mumbai");
		driver.findElement(By.id("submitAccount")).click();
		
		
	}
	
	@AfterClass
	public void tear()
	{
		driver.quit();
	}


}
