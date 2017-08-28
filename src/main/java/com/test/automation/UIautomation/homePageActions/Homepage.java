package com.test.automation.UIautomation.homePageActions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Homepage {
	
	public static final Logger log=Logger.getLogger(Homepage.class.getName());
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='header_user_info']/a[@class='login']")
	WebElement signIn;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement loginEmailAddress;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement loginPassword;
	
	@FindBy(xpath="//button[@id='SubmitLogin']/span/i")
	WebElement submitButton;
	
	@FindBy(xpath="//div[@id='center_column']/div/ol/li")
	WebElement authenticationFailed;
	
	@FindBy(xpath="//input[@id='email_create")
	WebElement email_SignUP;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement createAnAccount_Button;
	
	@FindBy(xpath="(//div[@class='radio-inline']/label/div/span)[2]")
	WebElement mrs_RadioButton;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement address;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(id="postcode")
	WebElement postcode;
	
	@FindBy(id="phone_mobile")
	WebElement mobile_Phone;
	
	@FindBy(id="alias")
	WebElement alternate_Address;
	
	@FindBy(id="submitAccount")
	WebElement submit_SignUP;
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSignIN()
	{
		signIn.click();
		log.info("Clicked on Sign In and object is:"+signIn.toString());
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}
	
	public void logIntoApplication(String emailAddress, String password)
	{
			
		log.info("Entered email address is:"+emailAddress+"and object is "+loginEmailAddress.toString());
		loginEmailAddress.sendKeys(emailAddress);
		
		log.info("Entered password is:"+password+"and object is "+loginPassword.toString());
		loginPassword.sendKeys(password);
		
		log.info("Clicked on submit button and the object is:"+submitButton.toString());
		submitButton.click();
	}
	
	public String getInvalidLoginText()
	{
		log.info("Error message is"+authenticationFailed.getText());
		return authenticationFailed.getText();
	}
	
	public void registerUser()
	{
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
	
	}
