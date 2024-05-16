package com.nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;
import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;

import pageObjects.nopCommerce.portal.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import ultilities.DataHelper;
import ultilities.Environment;


public class Multiple_Environment_Owner extends BaseTest {
	WebDriver driver;
	//private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private String firstName, lastName, emailAddress, password;
	private String date,month,year;
	UserDataMapper userData;
	
	Environment environment;
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		environment = ConfigFactory.create(Environment.class);
		
		driver = getBrowserDriver(browserName, environment.appUrl());
		
		System.out.println(environment.appUrl());
		System.out.println(environment.appPassword());
		System.out.println(environment.appUsername());
		System.out.println(environment.dbHostname());
		System.out.println(environment.dbPassword());
		System.out.println(environment.dbUsername());
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		//dataFaker = DataHelper.getDataHelper();
		userData = UserDataMapper.getUserData();
		emailAddress = userData.getEmailAddress();

		firstName = userData.getFirstName();
		lastName = userData.getLastName();
		emailAddress = userData.getEmailAddress();
		password = userData.getPassword();
		date = userData.getDate();
		month = userData.getMonth();
		year = userData.getYear();
	}
	
	@Test
	public void User01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRadioButtonByLabel(driver, "Female");
		
		log.info("Register - Step 02: Enter to all fields information");
		registerPage.inputToTextboxByID(driver,"FirstName", firstName);
		
		//registerPage.inputToTextboxByID(driver, "FirstName",userData.getLoginUsername());
		//registerPage.inputToTextboxByID(driver, "FirstName",userData.getLoginPassword());
		
		registerPage.inputToTextboxByID(driver,"LastName", lastName);
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", date);
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);
		
		registerPage.inputToTextboxByID(driver,"Email", emailAddress);
		
		registerPage.clickToCheckboxByLabel(driver, "Newsletter");
		
		registerPage.inputToTextboxByID(driver,"Password", password);
		registerPage.inputToTextboxByID(driver,"ConfirmPassword", password);
		
		registerPage.sleepInSecond(3);
		
		log.info("Register - Step 03: Click to Register button");
		registerPage.clickToButtonByText(driver, "Register");
		showBrowserConsoleLogs(driver);
		log.info("Register - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		log.info("Register - Step 05: Click to logout");
		homePage = registerPage.clickLinkLogout();
		 
	}
	
	@Test
	public void User_02_Login() {		
		log.info("Login - Step 01: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Enter to email and password textbox");
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);
		
		log.info("Login - Step 03: Click to login button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		showBrowserConsoleLogs(driver);
		log.info("Login - Step 04: Verify my account link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed()); //My account
		customerInfoPage = homePage.openMyAccountPage();
		verifyTrue(customerInfoPage.isCustomerInfoDisplayed());
	}
	

	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
