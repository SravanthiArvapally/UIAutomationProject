package com.test.automation.UIautomation.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.test.automation.UIautomation.excelReader.Excel_Reader;

public class TestBase {
	
	public static final Logger log=Logger.getLogger(TestBase.class.getName());//this log will give name of the class
	
	public WebDriver driver;
	public String url="http://automationpractice.com/index.php";
	public String browser="chrome";
	Excel_Reader excel;
	WebDriverWait wait;
	
	public void init() {
		selectBrowser(browser);
		getUrl();
		String log4jConfPath="log4j.properties"; //Registering log4j file
		PropertyConfigurator.configure(log4jConfPath);//PropertyConfigurator is a class provided by log4j
	}
		
	public void selectBrowser(String browser)
	{
		
		if(browser.equalsIgnoreCase("chrome"))
		{
				
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver/chromedriver.exe");
			log.info("Creating object of"+ browser);//To print which browser the object is getting created
	
			driver=new ChromeDriver();
				
			}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			//For Windows
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Driver/geckodriver.exe");
			//For Mac
			//System.setProperty("webdriver.firefox,marionette", System.getProperty("user.dir")+"/Driver/geckodriver");
		}
	}
			
	public void getUrl()
	{
		log.info("Navigating to"+ url);
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("window maximized");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}
	
	public String[][] getExcelData(String excelName, String sheetName)
	{
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\automation\\UIautomation\\data\\"+excelName;
		//C:\Users\srarvapa\git\UIAutomationProject\src\main\java\com\test\automation\UIautomation\data\Testdata.xlsx
		excel=new Excel_Reader(path);
		//String data[][]=excel.getDataFromSheet(sheetName,excelName);
		String[][] data=excel.getDataFromSheet(sheetName,excelName);
		return data;
	}
	
	public String getExcelData(String excelName, String sheetName, int rowNum, String colName)
	{
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\automation\\UIautomation\\data\\"+excelName;
		excel=new Excel_Reader(path);
		String cellData=excel.getCellData(sheetName, rowNum, colName);
		System.out.println("Cell data is"+ cellData);
		return cellData;
	
	}
	
	public void waitForElement(WebElement element,int timeOutInSeconds)
	{
		wait=new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));//visibilityOfElementLocated((By) element));

	}
	
	public void getScreenshot(String name)
	{
		Calendar calender=Calendar.getInstance();
		SimpleDateFormat sid=new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
		
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try
		{
		String reportDirectory=System.getProperty("user.dir")+"src/main/java/com/test/automation/UIautomation/screenshot/";
			
		File destfile=new File((String)reportDirectory+ name + "-"+ sid.format(calender.getTime())+".png");
		FileUtils.copyFile(srcfile, destfile);
			
		//This will help  us to link screenshot in testNG report
		
		Reporter.log("<a href= '" + destfile.getAbsolutePath() + "'> <img src='" +destfile.getAbsolutePath()+"'height='100' width='100'/></a>");
		
		//here to convert destfile.getabsolute path to string we have to mention ' followed by " and " followed by '
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
			
	}
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public void navigateBack()
	{
		driver.navigate().back();
	}
	
	public void moveToElement(WebDriver driver,WebElement element)
	{
		
		Actions action=new Actions(driver);
	    action.moveToElement(element).build().perform();
	}
	
	public String getTitle(WebDriver driver)
	{
		String title=driver.getTitle();
		return title;
	}
	
	}
