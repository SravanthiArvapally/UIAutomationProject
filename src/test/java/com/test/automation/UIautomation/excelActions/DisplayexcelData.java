package com.test.automation.UIautomation.excelActions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.test.automation.UIautomation.testBase.TestBase;

public class DisplayexcelData extends TestBase {

	@BeforeClass
	public void setUp1()throws Exception
	{
		System.out.println("Executing excel method to print all data of excel");
	}
		
	@Test()
	@Parameters
	public void displayexcelData() {
		getExcelData("Testdata.xlsx", "LoginTestdata");
		getExcelData("Testdata.xlsx", "LoginTestdata", 4, "Username");
	}	
	
	@AfterClass
	public void tear1()
	{
		System.out.println("Successfully displayed excel data");
	}
	
	
}
