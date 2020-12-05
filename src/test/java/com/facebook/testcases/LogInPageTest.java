package com.facebook.testcases;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.facebook.TestMethod.TestMethod;
import com.facebook.base.TestBase;
import com.facebook.pages.LogInPage;
import com.facebook.testdata.TestData;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LogInPageTest extends TestBase {
	LogInPage loginpage;
	public static ExtentReports extent;
	public static ExtentTest extenttest;
	

	public LogInPageTest() {
		super();
	}

	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/LoginPageTest.html", true);
		extent.addSystemInfo("Host Name", "User01");
		extent.addSystemInfo("UserName", "User");
		extent.addSystemInfo("environment", "Windows");
		
	}

	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		intialization();
		loginpage = new LogInPage();
		TestData.ReadData();
	}
	
	@Test(priority = 1)
	public void LogInTestForCorrectUserNameAndPassword() throws InterruptedException {
		extenttest = extent.startTest("LogInTestForCorrectUserNameAndPassword");
		
		// ENTER YOUR FACEBOOK USERNAME AND PASSWORD IN FacebookTask >> drivers >> TestData File FOR LOGIN TEST.
		
		extenttest.log(LogStatus.INFO, "Entering Correct UserName");
		loginpage.EnteringUsername(TestData.UserName);
		extenttest.log(LogStatus.INFO, "Entering Correct Password");
		loginpage.EnteringPassword(TestData.Password);
		extenttest.log(LogStatus.INFO, "Clicking On LogIn Button");
		loginpage.ClickOnLogInButton();
		extenttest.log(LogStatus.INFO, "Verifying Username");
		String Actualname = loginpage.NameGetText();
		
		//Enter Your UserName for Verification
		
		Assert.assertEquals(Actualname, "Enter Your UserName for Verification");
		
	}

	@Test(priority = 2)
	public void LogInTestForWrongUserNameAndWrongPassword() throws InterruptedException {
		extenttest = extent.startTest("LogInTestForWrongUserNameAndWrongPassword");
		extenttest.log(LogStatus.INFO, "Entering Wrong UserName");
		loginpage.EnteringUsername(TestData.WrongUserName);
		extenttest.log(LogStatus.INFO, "Entering Wrong Password");
		loginpage.EnteringPassword(TestData.WrongPassword);
		extenttest.log(LogStatus.INFO, "Clicking On LogIn Button");
		loginpage.ClickOnLogInButton();
		Thread.sleep(2000);
		extenttest.log(LogStatus.INFO, "Verifying Error Msg");
		String ErrorMsg = loginpage.ErrorMsgGetText();
		Assert.assertEquals(ErrorMsg, "The password that you've entered is incorrect. Forgotten password?");
				
	}

	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			extenttest.log(LogStatus.FAIL, "Test Case Failed Is:" + result.getName());
			extenttest.log(LogStatus.FAIL, "Test Case Failed Is:" + result.getThrowable());
			String screnshotpath = TestMethod.getScreenshot(driver, result.getName());
			extenttest.log(LogStatus.FAIL, extenttest.addScreenCapture(screnshotpath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			extenttest.log(LogStatus.SKIP, "Test Case Skipped Is:" + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extenttest.log(LogStatus.PASS, "Test Case Passed Is:" + result.getName());
		}

		extent.endTest(extenttest);
		driver.quit();
	}
	

}
