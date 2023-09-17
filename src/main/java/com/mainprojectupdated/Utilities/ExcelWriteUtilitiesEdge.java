package com.mainprojectupdated.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//https://www.youtube.com/watch?v=6IigtmfpsmI
//https://dumbitdude.com/how-to-write-data-into-excel-sheet-using-selenium-webdriver/
//https://www.toolsqa.com/selenium-webdriver/excel-in-selenium/
//https://dumbitdude.com/how-to-write-data-into-excel-sheet-using-selenium-webdriver/
//https://www.toolsqa.com/selenium-webdriver/data-driven-testing-excel-poi/
public class ExcelWriteUtilitiesEdge {

	XSSFSheet sh;
	XSSFWorkbook w;
	
	public ExcelWriteUtilitiesEdge() throws IOException
	{
		FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources"+"\\Excel\\ExcelEdge.xlsx");
		w=new XSSFWorkbook(f);
		sh=w.getSheet("Sheet1");
		f.close();
	}
	
	
	public void writePassValueExcel(int count) throws IOException
	{
	
		sh.getRow(count).createCell(2).setCellValue("Pass");
		FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\resources"+"\\Excel\\ExcelEdge.xlsx");
		w.write(outputStream);
		outputStream.close();
		
	}

	public void writeFailValueExcel(int count) throws IOException
	{
		sh.getRow(count).createCell(2).setCellValue("Fail");
		FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\resources"+"\\Excel\\ExcelEdge.xlsx");
		w.write(outputStream);
		outputStream.close();

	}
}
