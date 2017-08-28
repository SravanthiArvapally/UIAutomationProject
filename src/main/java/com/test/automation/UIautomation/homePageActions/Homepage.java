package com.test.automation.UIautomation.homePageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='header_user_info']/a[@class='login'")
	WebElement signIn;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement loginEmailAddress;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement loginPassword;
	
	@FindBy(xpath="//button[@id='SubmitLogin']/span/i")
	WebElement submitButton;
	
	@FindBy(xpath="//div[@id='center_column']/div/ol/li")
	WebElement authenticationFailed;
	
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void logIntoApplication(String emailAddress, String password)
	{
		signIn.click();
		loginEmailAddress.sendKeys(emailAddress);
		loginPassword.sendKeys(password);
		submitButton.click();
	}
	
	public String getInvalidLoginText()
	{
		return authenticationFailed.getText();
	}
	
	}
