package com.facebook.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.facebook.base.TestBase;

public class TestUtil extends TestBase {

	public TestUtil() throws IOException {
		super();
		
	}

	static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public static long PAGE_LOAD_TIMEOUT =120;
	public static long IMPLICIT_WAIT = 30;

	public static void scroll()
	{
		js.executeScript("window.scrollBy(0,800)");
	}
	
	public static void select(WebElement Element,String value)
	{
		Select select = new Select(driver.findElement(By.xpath("Element")));
		select.selectByVisibleText(value);
	}
}
