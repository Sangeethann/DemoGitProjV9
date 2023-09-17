package com.mainprojectupdated.Scripts;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mainprojectupdated.Constants.Constants;
import com.mainprojectupdated.Pages.LoginPage;
import com.mainprojectupdated.Utilities.ExcelUtilitiesLoginUsingDPUsingJXL;
import com.mainprojectupdated.Utilities.ExcelWriteUtilitiesChrome;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginTestDPUsingJXL extends TestBase {

	static Sheet sh;
	static Workbook w;
	XSSFRow row;
	Boolean verifyConfirmMsg;
	int count=-1;
	ExcelWriteUtilitiesChrome exw;


	LoginPage obj;

	@Test(priority=0,dataProvider="dp")
	public void login(String username, String password) throws IOException  {

		obj=new LoginPage(driver);
		obj.setUserName(username);
		obj.setPassword(password);
		obj.loginFunc();

		try
		{
			verifyConfirmMsg = (obj.getConfirmMsgText()).equals(Constants.LOGINCONFIRMMSG);
			exw= new ExcelWriteUtilitiesChrome();
			exw.writePassValueExcel(++count);
		}
		catch(NoSuchElementException e)
		{
			exw= new ExcelWriteUtilitiesChrome();
			exw.writeFailValueExcel(++count);
		}
	}

	@DataProvider
	public Object[][] dp() throws BiffException, IOException {

		Object[][] testObjArray=ExcelUtilitiesLoginUsingDPUsingJXL.getExcelData();
		return testObjArray;

	}


}
