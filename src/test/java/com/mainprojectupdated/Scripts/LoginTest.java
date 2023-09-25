package com.mainprojectupdated.Scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.mainprojectupdated.Utilities.DateUtilities;
import com.mainprojectupdated.Constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class LoginTest {

	public static WebDriver driver=null;
	public static Properties prop=null;

	public static void testBase() throws IOException
	{
		try
		{
			prop=new Properties();
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources"+"\\Config.properties");
			prop.load(ip);
		}

		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		testBase();
		String baseUrl=prop.getProperty("baseUrl");
		driver.get(baseUrl);
		driver.manage().window().maximize();
		takeScreenshotOn("Home");
	}

	@AfterMethod
	public void afterMethod(ITestResult iTestResult) {

		if(iTestResult.getStatus()==iTestResult.SUCCESS||iTestResult.getStatus()==iTestResult.FAILURE)
		{
			takeScreenshotOn(iTestResult.getName());
		}
	}

	public void takeScreenshotOn(String name) {

		//String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		String dateName=DateUtilities.getCurrentDateStr();
		Shutterbug.shootPage(driver, Capture.FULL,true).save(System.getProperty("user.dir")+"\\target\\Screenshots\\"+name+dateName+".png");


	}

	@Parameters({"browsers"})
	@BeforeTest
	public void beforeTest(String browser) throws IOException {

		getBrowser(browser);

	}

	public void getBrowser(String browser) {

		if(browser.equalsIgnoreCase(Constants.CHROMEBROWSER))
		{

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}

		else if(browser.equalsIgnoreCase(Constants.EDGEBROWSER))
		{
			System.setProperty(Constants.EDGEDRIVER, System.getProperty("user.dir")+"\\src\\main\\resources"+"\\Drivers\\msedgedriverlatest.exe");
			driver=new EdgeDriver();
		}
	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
