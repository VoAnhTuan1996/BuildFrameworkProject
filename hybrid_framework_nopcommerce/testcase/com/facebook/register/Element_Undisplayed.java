package com.facebook.register;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;


public class Element_Undisplayed extends BaseTest {
	WebDriver driver;
	private LoginPageObject loginPage;
	
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		/*
		 * System.out.println("Run on "+ browserName); homePage =
		 * PageGeneratorManager.getUserHomePage(driver);
		 */
	}
	
	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();
		// Nếu 1 cái hàm chỉ mong đợi để verify element displayed thôi - kết hợp cả wait + isDisplayed
		// waitForElementVisible
		// isElementDisplayed
		
		// Verify true - mong đợi confirm email displayed (true)
		loginPage.enterToEmailAddressTextbox("automationfc@gmail.com");
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());
	}
	
	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		// Nếu như mình mong đợi 1 cái hàm vùa verify displayed/ undisplayed thì ko được kết hợp wait
		// isElementDisplayed
		
		// Verify false - mong đợi confirm email displayed (false)
		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(3);
		System.out.println("Result: "+loginPage.isConfirmEmailAddressTextboxDisplayed());
		verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
	}
		
	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickCloseIconAtRegisterForm();
		loginPage.sleepInSecond(3);
		// Verify false - mong đợi confirm email undisplayed (false)
		// isDisplayed: bản chất ko kiểm tra 1 element ko có trong DOM được
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
