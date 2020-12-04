package com.facebook.TestMethod;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.facebook.base.TestBase;
import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestMethod extends TestBase{
	public static ExtentReports extent;
	public static ExtentTest extenttest;


	public static String getScreenshot(WebDriver driver, String screenshotname) throws IOException {
		String datename = new SimpleDateFormat("yyyymmddhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/test-output/FailureScreenShot" + screenshotname
				+ datename + ".png";
		File finaldestination = new File(destination);
		Files.copy(source, finaldestination);
		return destination;
	}
	
	
	public static WebElement waitToLoadPage(By ele, String selectorName) {
		WebElement rClientElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10500);
			rClientElement = wait.until((ExpectedConditions.presenceOfElementLocated(ele)));

		} catch (Exception e) {
			System.out.println("ERROR: Element " + selectorName + "  not found");
		}

		return rClientElement;
	}
	
	
}


