package com.mainprojectupdated.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelUtilitiesLoginUsingDPUsingJXL {

	//Refer the usage of dataprovider in program: https://www.toolsqa.com/testng/testng-data-provider-excel/

	//This is a Data Provider Program using JXL
	//JXL is now JExcel.
	//Perhaps the most significant difference between Apache POI and JXL is that Java JXL does not support the Excel 2007+ ".xlsx" format; 
	//JXL only supports the old BIFF (binary) ".xls" format. Apache POI supports both with a common design.
	//Apache POI is preferred over JXL
	//You should use Apache POI because JExcel does not support .xlsx format.
	//JXL library doesnot support .csv and .xslx formats, which is the format used by Excel-2010. hence, use Excel 97-2003 which is .xls foramatted and is supported by JXL library. 
	//or else if you want to use excel-2010, use APACHE POI(XSSFWorkbooks) instead of JXL. For using .csv format, google for CSVReader libraries.

	//You will get this error "java.lang.RuntimeException: jxl.read.biff.BiffException: Unable to recognize OLE stream" if you try to save the Excel file
	// in .xlsx format because JXL does not support the Excel 2007+ ".xlsx" format
	
	//It will show OLE Exception when trying to open the Excel.xls file because there is no OLE Editor so use Apache POI(XSSFWorkbook) which supports .xlsx format
	//and we will be able to open the .xlsx files

	static Sheet sh;
	static Workbook w;


	public static Object[][] getExcelData() throws BiffException, IOException
	{
		FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources"+"\\Excel\\Excel.xls");

		w=Workbook.getWorkbook(f);
		sh=w.getSheet("Sheet1");

		int r=sh.getRows();
		int c=sh.getColumns();
		String input[][]=new String[r][c];
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				Cell cc=sh.getCell(j, i);
				input[i][j]=cc.getContents();
			}
		}
		return input;


	}


}
