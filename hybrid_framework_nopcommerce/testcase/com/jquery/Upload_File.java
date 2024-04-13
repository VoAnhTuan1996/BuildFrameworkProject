package com.jquery;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.uploadFile.HomePageObject;
import pageObjects.jquery.uploadFile.PageGenerator;

public class Upload_File extends BaseTest {
	WebDriver driver;
	//private String projectPath = System.getProperty("user.dir");
	HomePageObject homePage;
	
	String cSharpFileName = "csharp.png";
	String javaFileName = "java.jpg";
	String pythonFileName = "python.png";
	String rubyFileName = "ruby.jpq";
	
	String[] multipleFileNames = {cSharpFileName, javaFileName, pythonFileName, rubyFileName};
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
		/*
		 * System.out.println("Run on "+ browserName); homePage =
		 * PageGeneratorManager.getUserHomePage(driver);
		 */
	}
	
	@Test
	public void UploadFile_01_One_File_Per_Time() {
		//1. Load single file
		homePage.uploadMultipleFiles(driver, cSharpFileName);
		//2. Verify single file loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(cSharpFileName));
		//3. Click start button
		homePage.clickToStartButton();
		//4. Verify single file link uploaded success
		Assert.assertTrue(homePage.isFileLinkUploadedByName(cSharpFileName));
		//5. Verify single file image uploaded success
		Assert.assertTrue(homePage.isFileImageUploadedByName(cSharpFileName));
	}
	
	@Test
	public void UploadFile_02_M_Per_Time() {		
		homePage.refreshCurrentPage(driver);
		//1. Load multiple file
		homePage.uploadMultipleFiles(driver, multipleFileNames);
		//2. Verify single file loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(cSharpFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(rubyFileName));
		//3. Click start button
		homePage.clickToStartButton();
		//4. Verify single file link uploaded success
		Assert.assertTrue(homePage.isFileLinkUploadedByName(cSharpFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(rubyFileName));
		//5. Verify single file image uploaded success
		Assert.assertTrue(homePage.isFileImageUploadedByName(cSharpFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(rubyFileName));
	}
	
	
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
