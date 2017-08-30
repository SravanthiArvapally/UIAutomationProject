package com.test.automation.UIautomation.excelReader;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.helpers.XSSFRowShifter;

public class Excel_Reader {

	public String path; 
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	//C:\Users\saikrishna\git\UIAutomationProject\
	
	//src\main\java\com\test\automation\UIautomation\data\Testdata.xlsx
	
	public Excel_Reader(String path) //Supplying path of excel doc here in the constructor of the class
	{
		this.path=path; //since local and global var are of same name.
		 try{
			 //To read data file input stream class from java.So it takes the path of excel sheet to read data from sheet.
			 fis=new FileInputStream(path); //Here now we can communicate to excel workbook.
			 
			 //Then its time to create object for workbook once we can communicate with workbook as below
			 workbook=new XSSFWorkbook(fis);
			 
		 }
		 catch(Exception e){
			 
			 e.printStackTrace();
			 
		 }
	 }
	
	//This method will return data for each record in excel sheet
	
	public String[][] getDataFromSheet(String sheetName)
	{
		String dataSets[][]=null;
		try{
		//Get sheet from excel workbook
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		//Get total number of rows in the sheet
		int totalRows=sheet.getLastRowNum()+1;//since row number starts from 0,1,2,..
		
		//Get total number of columns in the sheet
		int totalcols=sheet.getRow(0).getLastCellNum();
		
		//Initializing one string array to store the data
		
		dataSets=new String[totalRows-1][totalcols];
		
		for(int i=1;i<totalRows;i++) //i=1 because first row containing headings. Data starts from second row of excel sheet
		{
			XSSFRow row=sheet.getRow(i);
			
			for(int j=0;j<totalcols;j++) //j=0 because col starts from 0(means from first column in excel sheet)
			{
				XSSFCell cell=row.getCell(j);
				
				if(cell.getCellType()==Cell.CELL_TYPE_STRING)
					dataSets[i-1][j]=cell.getStringCellValue();
				else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
					dataSets[i-1][j]=String.valueOf(cell.getNumericCellValue());
				else if(cell.getCellType()==Cell.CELL_TYPE_BOOLEAN)
					dataSets[1-1][j]=String.valueOf(cell.getBooleanCellValue());
			}
		}
		return dataSets;
		}
		catch(Exception e){
			e.printStackTrace();
		
	}
		return null;	
				
				
}	
		
	//Method to read only one cell data based on the input
		
		public String getCellData(String SheetName, int rowNum, String colName){
			int colNum=0;
			try{
			XSSFSheet sheet=workbook.getSheet(SheetName);
			
			XSSFRow row=sheet.getRow(0);
			
			for(int i=0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().equals(colName))
				{
					colNum=i;
					break;
				}		
			}
			
			row=sheet.getRow(rowNum-1);
			XSSFCell cell=row.getCell(colNum);
			if(cell.getCellType()==Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
				return String.valueOf(cell.getBooleanCellValue());
			
			
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
		}
			return null
					;
		
		
		
		
		
		
		
		
	}
}
