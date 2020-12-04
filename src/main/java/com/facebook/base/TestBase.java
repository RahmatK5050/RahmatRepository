package com.facebook.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.facebook.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static String path = System.getProperty("user.dir") + "/drivers";
	public static String pathff = System.getProperty("user.dir") + "/drivers";
	public static String configpath = System.getProperty("user.dir")
			+ "/src/main/java/com/facebook/config/config.properties";
	public Properties prop;
	public static String BrowserCheck;
	public static WebDriver driver;
	public static String url;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fp = new FileInputStream(configpath);
			prop.load(fp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void intialization() throws InterruptedException {
		BrowserCheck = prop.getProperty("browser");
		if (BrowserCheck.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", path + "\\chromedriver (84).exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BrowserCheck.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", pathff + "\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		url = prop.getProperty("url");
		driver.get(url);
		

	}

}
