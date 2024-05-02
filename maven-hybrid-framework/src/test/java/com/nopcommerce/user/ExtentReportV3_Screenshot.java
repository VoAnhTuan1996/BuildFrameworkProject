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
import pageObjects.nopCommerce.portal.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;

public class ExtentReportV3_Screenshot extends BaseTest {
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
	}
	
	@Test
	public void User01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		log.info("Register - Step 02: Enter to all fields information");
		System.out.println("Pre-Condition - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox("Automation");
		registerPage.inputToLastnameTextbox("FC");
		registerPage.inputToEmailTextbox("anhtuan12@gmail.com");
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		log.info("Register - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		log.info("Register - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		log.info("Register - Step 05: Click to logout");
		homePage = registerPage.clickLinkRegister();
		 
	}
	
	@Test
	public void User_02_Login() {		
		log.info("Login - Step 01: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Enter to email and password textbox");
		loginPage.enterToEmailTextbox("anhtuan12@gmail.com");
		loginPage.enterToPasswordTextbox("123456");
		
		log.info("Login - Step 03: Click to login button");
		loginPage.clickToLoginButton();
		
		log.info("Login - Step 04: Verify my account link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed()); //My account
		customerInfoPage = homePage.openMyAccountPage();
		verifyTrue(customerInfoPage.isCustomerInfoDisplayed());
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
