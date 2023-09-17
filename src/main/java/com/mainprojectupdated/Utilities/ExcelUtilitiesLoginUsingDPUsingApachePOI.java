package com.mainprojectupdated.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.read.biff.BiffException;

//HSSFWorkbook- These class methods are used to read/write data to Microsoft Excel file in .xls format. It is compatible with MS-Office versions 97–2003.
//XSSFWorkbook- These class methods are used to read-write data to Microsoft Excel in .xls or .xlsx format. It is compatible with MS-Office versions 2007 or later.

//IF the Excel sheet is in .xls format, it supports the HSSFWorkbook

//https://www.toolsqa.com/selenium-webdriver/excel-in-selenium/

//Refer: https://medium.com/geekculture/how-to-read-data-from-excel-file-using-apache-poi-95b8a4aa3909
//https://www.toolsqa.com/testng/testng-data-provider-excel/
public class ExcelUtilitiesLoginUsingDPUsingApachePOI {

	
	public static Object[][] getExcelData() throws BiffException, IOException
	{
		
		FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources"+"\\Excel\\Excel.xlsx");

		XSSFWorkbook w=new XSSFWorkbook(f);
		XSSFSheet sh=w.getSheet("Sheet1");
		int noOfRows = sh.getLastRowNum()+1;
		int noOfColumns = sh.getRow(0).getLastCellNum();
		String[][] dataTable = new String[noOfRows][noOfColumns];
		System.out.println("FirstRowNum= "+sh.getFirstRowNum());
		System.out.println("LastRowNum= "+sh.getLastRowNum());
		for (int i = sh.getFirstRowNum(); i <sh.getLastRowNum() + 1; i++) {

			Row row = sh.getRow(i);
		
			for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				dataTable[i][j] = cell.getStringCellValue();
			}

		}
		return dataTable;

	}




}


