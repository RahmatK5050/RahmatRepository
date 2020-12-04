package com.facebook.testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.facebook.base.TestBase;

public class TestData extends TestBase {

	public static String path1 = System.getProperty("user.dir") + "/drivers/TestData.xlsx";
	public static String UserName;
	public static String Password;
	public static String WrongUserName;
	public static String WrongPassword;
	
	public static void ReadData() throws IOException {
		FileInputStream fis = new FileInputStream(path1);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sh1 = wb.getSheetAt(0);

		UserName = sh1.getRow(1).getCell(0).getStringCellValue();

		Password = sh1.getRow(1).getCell(1).getStringCellValue();

		WrongUserName = sh1.getRow(1).getCell(2).getStringCellValue();

		WrongPassword = sh1.getRow(1).getCell(3).getStringCellValue();

		
		

	}

}
