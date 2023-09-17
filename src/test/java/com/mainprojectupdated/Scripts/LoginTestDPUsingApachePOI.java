package com.mainprojectupdated.Scripts;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mainprojectupdated.Constants.Constants;
import com.mainprojectupdated.Pages.LoginPage;
import com.mainprojectupdated.Utilities.ExcelUtilitiesLoginUsingDPUsingJXL;
import com.mainprojectupdated.Utilities.ExcelWriteUtilitiesChrome;
import com.mainprojectupdated.Utilities.ExcelUtilitiesLoginUsingDPUsingApachePOI;

import jxl.read.biff.BiffException;

public class LoginTestDPUsingApachePOI extends TestBase {

	LoginPage obj;
	Boolean verifyConfirmMsg=false;
	int count=-1;
	ExcelWriteUtilitiesChrome exw;


	@Test(priority=0,dataProvider="dp")
	public void login(String username, String password) throws IOException {


		obj=new LoginPage(driver);
		obj.setUserName(username);
		obj.setPassword(password);
		System.out.println(username);
		System.out.println(password);
		obj.loginFunc();


//		try
//		{
//			verifyConfirmMsg = (obj.getConfirmMsgText()).equals(Constants.LOGINCONFIRMMSG);
//			Assert.assertTrue(verifyConfirmMsg);
//			exw= new ExcelWriteUtilities();
//			exw.writePassValueExcel(++count);
//		}
//		catch(NoSuchElementException e)
//		{
//
//			exw= new ExcelWriteUtilities();
//			exw.writeFailValueExcel(++count);
//		}



	}

	@DataProvider
	public Object[][] dp() throws BiffException, IOException {

		Object[][] testObjArray=ExcelUtilitiesLoginUsingDPUsingApachePOI.getExcelData();
		return testObjArray;

	}


}
