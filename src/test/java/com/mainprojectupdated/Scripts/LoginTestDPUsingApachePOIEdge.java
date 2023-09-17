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
import com.mainprojectupdated.Utilities.ExcelWriteUtilitiesEdge;
import com.mainprojectupdated.Utilities.ExcelUtilitiesLoginUsingDPUsingApachePOI;
import com.mainprojectupdated.Utilities.ExcelUtilitiesLoginUsingDPUsingApachePOIEdge;

import jxl.read.biff.BiffException;

//This class is created For parallel testing of 2 browsers for login concept-->Excel read of large set of user names and passwords using dataprovider

public class LoginTestDPUsingApachePOIEdge extends TestBaseEdge {

	LoginPage obj;
	Boolean verifyConfirmMsg=false;
	int count=-1;
	ExcelWriteUtilitiesEdge exw;


	@Test(priority=0,dataProvider="dpEdge")
	public void loginEdge(String username, String password) throws IOException {


		obj=new LoginPage(driver);
		obj.setUserNameEdge(username);
		obj.setPasswordEdge(password);
		System.out.println(username);
		System.out.println(password);
		obj.loginFuncEdge();


		try
		{
			verifyConfirmMsg = (obj.getConfirmMsgTextEdge()).equals(Constants.LOGINCONFIRMMSG);
			Assert.assertTrue(verifyConfirmMsg);
			exw= new ExcelWriteUtilitiesEdge();
			exw.writePassValueExcel(++count);
		}
		catch(NoSuchElementException e)
		{

			exw= new ExcelWriteUtilitiesEdge();
			exw.writeFailValueExcel(++count);
		}



	}

	@DataProvider
	public Object[][] dpEdge() throws BiffException, IOException {

		Object[][] testObjArray=ExcelUtilitiesLoginUsingDPUsingApachePOIEdge.getExcelData();
		return testObjArray;

	}


}
