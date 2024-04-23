package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;

public class Common_Register_Cookies extends BaseTest {
	public static String emailAddress;
	public static String password;
	public static Set<Cookie> loggedCookies;
	WebDriver driver;
	//private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	
	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all Classes Test")
	
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		String firstName = "Automation";
		String lastName = "FC";
		emailAddress = "anhtuan120@gmail.com";
		password = "123456";
		
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		log.info("Register - Step 02: Enter to all fields information");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		log.info("Register - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		loggedCookies = homePage.getAllCookies(driver);		
		log.info("Register - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		log.info("Register - Step 05: Click to logout");
		homePage = registerPage.clickLinkRegister();
		
		 
	}
	
	
	@AfterTest
	public void afterClass() {
		driver.quit();
	}
}
