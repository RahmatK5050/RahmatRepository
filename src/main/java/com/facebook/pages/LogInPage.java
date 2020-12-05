package com.facebook.pages;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.ini4j.InvalidFileFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.facebook.base.TestBase;
import com.facebook.testdata.TestData;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class LogInPage extends TestBase {
	public static ExtentReports extent;
	public static ExtentTest extenttest;

	// Page Factory
	@FindBy(xpath="//input[@name=\"email\"]")
	WebElement Email;
	
	@FindBy(xpath="//input[@name=\"pass\"]")
	WebElement Password;
	
	@FindBy(xpath="//button[@name=\"login\"]")
	WebElement LogInButton;

	@FindBy(xpath="//div[contains(@class,'_9ay7')]")
	WebElement ErrorMsg;
	
	@FindBy(xpath="//html[@id='facebook']/body/div[1]/div/div[1]/div[1]/div[3]/div/div/div[1]//div[@role='navigation']/div/div/div[1]/div/div/div[@class='buofh1pr']/ul/li/div/a[@role='link']/div[1]/div[2]/div")
	WebElement Name;

	public LogInPage() {
		PageFactory.initElements(driver, this);
	}

	public void EnteringUsername(String username)
	{
		Email.click();
		Email.sendKeys(username);	
	}
	
	public void EnteringPassword(String password)
	{
		Password.click();
		Password.sendKeys(password);	
	}
	
	public void ClickOnLogInButton()
	{
		LogInButton.click();
	}

	public String ErrorMsgGetText()
	{
		return ErrorMsg.getText();
	}
	
	public String NameGetText()
	{
		return Name.getText();
	}
}
