package com.jquery;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.datatable.HomePageObject;
import pageObjects.jquery.datatable.PageGenerator;

public class Data_Grid_Table extends BaseTest {
	WebDriver driver;
	// private String projectPath = System.getProperty("user.dir");
	HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);
		/*
		 * System.out.println("Run on "+ browserName); homePage =
		 * PageGeneratorManager.getUserHomePage(driver);
		 */
	}

	// @Test
	public void Table_01() {
		homePage.openPagingByNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		homePage.openPagingByNumber("20");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("20"));
		homePage.openPagingByNumber("7");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("7"));
		homePage.openPagingByNumber("18");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("18"));
	}

	// @Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);

		homePage.enterToHeaderTextBoxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextBoxByLabel("Females", "338282");
		homePage.enterToHeaderTextBoxByLabel("Males", "349238");
		homePage.enterToHeaderTextBoxByLabel("Total", "687522");
		homePage.sleepInSecond(3);
		homePage.enterToHeaderTextBoxByLabel("Country", "Angola");
		homePage.enterToHeaderTextBoxByLabel("Females", "276880");
		homePage.enterToHeaderTextBoxByLabel("Males", "276472");
		homePage.enterToHeaderTextBoxByLabel("Total", "553353");
		homePage.sleepInSecond(3);
	}

	// @Test
	public void Table_03_Enter_To_Header() {
		homePage.getValueEachRowAtAllPage();
	}

	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		homePage.clickLoadButton();
		homePage.sleepInSecond(5);

		homePage.enterToTextboxByColumnNameAtRowNumber("Company", "2", "Mercedes");
		homePage.sleepInSecond(3);

		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "3", "Michael Bloom");
		homePage.sleepInSecond(3);

		homePage.selectDropdownByColumnNameAtRowNumer("Country", "1", "Germany");
		homePage.sleepInSecond(3);

		homePage.selectDropdownByColumnNameAtRowNumer("Country", "5", "Hong Kong");
		homePage.sleepInSecond(3);

		
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?","3");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?","6");
		homePage.sleepInSecond(3);
		
		homePage.unCheckToCheckboxByColumnNameAtRowNumber("NPO?","1");
		homePage.unCheckToCheckboxByColumnNameAtRowNumber("NPO?","4");
		homePage.sleepInSecond(3);
		
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.clickToIconByRowNumber("2", "Insert Row Above");
		homePage.clickToIconByRowNumber("3", "Move Up");
		homePage.clickToIconByRowNumber("5", "Remove Current Row");
		   
		 
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
