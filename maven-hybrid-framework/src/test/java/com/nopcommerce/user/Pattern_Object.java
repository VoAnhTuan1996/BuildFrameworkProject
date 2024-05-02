package com.nopcommerce.user;

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


public class Pattern_Object extends BaseTest {
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
		homePage = PageGeneratorManager.getUserHomePage(driver);
		showBrowserConsoleLogs(driver);
	}
	
	@Test
	public void User01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRadioButtonByLabel(driver, "Female");
		
		log.info("Register - Step 02: Enter to all fields information");
		registerPage.inputToTextboxByID(driver,"FirstName", "Automation");
		registerPage.inputToTextboxByID(driver,"LastName", "FC");
		
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", "10");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", "August");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", "1996");
		
		registerPage.inputToTextboxByID(driver,"Email", "anhtuan123@gmail.com");
		
		registerPage.clickToCheckboxByLabel(driver, "Newsletter");
		
		registerPage.inputToTextboxByID(driver,"Password", "123456");
		registerPage.inputToTextboxByID(driver,"ConfirmPassword", "123456");
		
		registerPage.sleepInSecond(3);
		
		log.info("Register - Step 03: Click to Register button");
		registerPage.clickToButtonByText(driver, "Register");
		showBrowserConsoleLogs(driver);
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
		loginPage.enterToEmailTextbox("anhtuan123@gmail.com");
		loginPage.enterToPasswordTextbox("123456");
		
		log.info("Login - Step 03: Click to login button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		showBrowserConsoleLogs(driver);
		log.info("Login - Step 04: Verify my account link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed()); //My account
		customerInfoPage = homePage.openMyAccountPage();
		verifyTrue(customerInfoPage.isCustomerInfoDisplayed());
	}
	
	@Test
	public void User_03_MyAccount() {
		log.info("MyAccount - Step 01: Navigate to 'My Account' page");
		customerInfoPage = homePage.openMyAccountPage();
		
		log.info("MyAccount - Step 02: Verify 'Customer Info' page is displayed");
		Assert.assertTrue(customerInfoPage.isCustomerInfoDisplayed());
		
		log.info("MyAccount - Step 03: Verify 'First Name' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), "Automation");
		
		log.info("MyAccount - Step 04: Verify 'Last Name' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), "FC");
		
		log.info("MyAccount - Step 03: Verify 'Email' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), "anhtuan123@gmail.com");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
