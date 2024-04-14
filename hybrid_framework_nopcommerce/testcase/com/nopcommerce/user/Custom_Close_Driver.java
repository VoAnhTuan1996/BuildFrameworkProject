package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import pageObjects.nopCommerce.portal.UserRewardPointPageObject;

public class Custom_Close_Driver extends BaseTest {
	WebDriver driver;
	//private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		System.out.println("Run on "+ browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		log.info("Register - Step 02: Enter to all fields information");
		registerPage.inputToFirstnameTextbox("Automation");
		registerPage.inputToLastnameTextbox("FC");
		registerPage.inputToEmailTextbox("anhtuan12@gmail.com");
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		log.info("Register - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		log.info("Register - Step 04: Verify success message displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");
		log.info("Register - Step 05: Click to logout");
		homePage = registerPage.clickLinkRegister();
		
		log.info("Login - Step 06: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 07: Enter to email and password textbox");
		loginPage.enterToEmailTextbox("anhtuan12@gmail.com");
		loginPage.enterToPasswordTextbox("123456");
		
		log.info("Login - Step 08: Click to login button");
		loginPage.clickToLoginButton();
	}
	
	@Test
	public void Search_Name() {
		
		 
	}
	
	@Test
	public void Search_Address() {		
		
		
		
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
