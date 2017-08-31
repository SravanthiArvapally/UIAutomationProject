package com.test.automation.UIautomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.automation.UIautomation.excelReader.Excel_Reader;

public class TestBase {
	
	public static final Logger log=Logger.getLogger(TestBase.class.getName());//this log will give name of the class
	
	public WebDriver driver;
	public String url="http://automationpractice.com/index.php";
	public String browser="chrome";
	Excel_Reader excel;
	
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
	
	

}
