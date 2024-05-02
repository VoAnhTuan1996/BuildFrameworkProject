package com.saucelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

import pageObjects.sauceLab.LoginPageObject;
import pageObjects.sauceLab.PageGeneratorManager;
import pageObjects.sauceLab.ProductPageObject;


public class Sort_and_Desc extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	ProductPageObject productPage;
	@Parameters({"browser","appUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String sauceUrl) {
		driver = getBrowserDriver(browserName,sauceUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		loginPage.enterUsernameTextbox("standard_user");
		loginPage.enterPasswordTextbox("secret_sauce");
		productPage = loginPage.clickLoginButton();
		
	}
	
	@Test
	public void Sort_Name() {
		// Ascending
		productPage.selectItemInProductSortDropdown("Name (A to Z)");
		productPage.sleepInSecond(3);
		Assert.assertTrue(productPage.isProductNameSortByAscending());
		// Descending
		productPage.selectItemInProductSortDropdown("Name (Z to A)");
		productPage.sleepInSecond(3); 
		Assert.assertTrue(productPage.isProductNameSortByDescending());
		
	}
	
	@Test
	public void Sort_Price() {		
		//Ascending
		productPage.selectItemInProductSortDropdown("Price (low to high)");
		productPage.sleepInSecond(3);
		Assert.assertTrue(productPage.isProductPriceSortByAscending());
		//Descending
		productPage.selectItemInProductSortDropdown("Price (high to low)");
		productPage.sleepInSecond(3);
		Assert.assertTrue(productPage.isProductPriceSortByDescending());
	}
	

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
