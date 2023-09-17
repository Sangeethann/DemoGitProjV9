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
import com.mainprojectupdated.Utilities.ExcelUtilitiesLoginUsingDPUsingApachePOIChrome;

import jxl.read.biff.BiffException;

//This class is created For parallel testing of 2 browsers for login concept-->Excel read of large set of user names and passwords using dataprovider

public class LoginTestDPUsingApachePOIChrome extends TestBaseChrome {

	LoginPage obj;
	Boolean verifyConfirmMsg=false;
	int count=-1;
	ExcelWriteUtilitiesChrome exw;


	@Test(priority=0,dataProvider="dpChrome")
	public void loginChrome(String username, String password) throws IOException {


		obj=new LoginPage(driver);
		obj.setUserNameChrome(username);
		obj.setPasswordChrome(password);
		System.out.println(username);
		System.out.println(password);
		obj.loginFuncChrome();

		//For Excel write we have to use two seperate ExcelWriteUtilities classes for Chrome and Edge and seperate Excel files

		try
		{
			verifyConfirmMsg = (obj.getConfirmMsgTextChrome()).equals(Constants.LOGINCONFIRMMSG);
			Assert.assertTrue(verifyConfirmMsg);
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
	public Object[][] dpChrome() throws BiffException, IOException {

		Object[][] testObjArray=ExcelUtilitiesLoginUsingDPUsingApachePOIChrome.getExcelData();
		return testObjArray;

	}


}
