package com.mainprojectupdated.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	@FindBy(name="userName")
	WebElement usernameElem;

	@FindBy(xpath="//input[@name='password']")
	WebElement passwordElem;

	@FindBy(xpath="//input[@name='submit']")
	WebElement submitBtnElem;

	@FindBy(xpath="//h3[text()='Login Successfully']")
	WebElement confirmMsgElem;

	@FindBy(name="userName")
	WebElement usernameElemChrome;

	@FindBy(xpath="//input[@name='password']")
	WebElement passwordElemChrome;

	@FindBy(xpath="//input[@name='submit']")
	WebElement submitBtnElemChrome;

	@FindBy(xpath="//h3[text()='Login Successfully']")
	WebElement confirmMsgElemChrome;
	
	@FindBy(name="userName")
	WebElement usernameElemEdge;

	@FindBy(xpath="//input[@name='password']")
	WebElement passwordElemEdge;

	@FindBy(xpath="//input[@name='submit']")
	WebElement submitBtnElemEdge;

	@FindBy(xpath="//h3[text()='Login Successfully']")
	WebElement confirmMsgElemEdge;

	String loginTitle;

	String confirmMsgTextChrome;
	String confirmMsgTextEdge;
	String confirmMsgText;


	public LoginPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	public void setUserName(String username) {

		usernameElem.sendKeys(username);

	}

	public void setPassword(String password) {

		passwordElem.sendKeys(password);

	}

	public void loginFunc() {

		submitBtnElem.click();
	}
	
	public String getConfirmMsgText()
	{
		confirmMsgText=confirmMsgElem.getText();
		return confirmMsgText;
	}


	public void setUserNameChrome(String username) {

		usernameElemChrome.sendKeys(username);

	}

	public void setPasswordChrome(String password) {

		passwordElemChrome.sendKeys(password);

	}

	public void loginFuncChrome() {

		submitBtnElemChrome.click();
	}
	
	public String getConfirmMsgTextChrome()
	{
		confirmMsgTextChrome=confirmMsgElemChrome.getText();
		return confirmMsgTextChrome;
	}

	public void setUserNameEdge(String username) {

		usernameElemEdge.sendKeys(username);

	}

	public void setPasswordEdge(String password) {

		passwordElemEdge.sendKeys(password);

	}

	public void loginFuncEdge() {

		submitBtnElemEdge.click();
	}

	public String getLoginTitle()
	{
		loginTitle=driver.getTitle();
		return loginTitle;
	}

	public String getConfirmMsgTextEdge()
	{
		confirmMsgTextEdge=confirmMsgElemEdge.getText();
		return confirmMsgTextEdge;
	}






}
