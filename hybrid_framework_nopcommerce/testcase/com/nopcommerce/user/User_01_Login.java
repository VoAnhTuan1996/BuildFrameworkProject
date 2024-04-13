package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import commons.BasePage;
import pageObjects.nopCommerce.portal.HomePageObject;
import pageObjects.nopCommerce.portal.LoginPageObject;
import pageObjects.nopCommerce.portal.RegisterPageObject;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User_01_Login extends BasePage {
	WebDriver driver;
	//private String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	@BeforeClass
	public void beforeClass() {
		//System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//Initial (khởi tạo)
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		
		System.out.println("Pre-Condition - Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
		System.out.println("Pre-Condition - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox("Automation");
		registerPage.inputToLastnameTextbox("FC");
		registerPage.inputToEmailTextbox("anhtuan111@gmail.com");
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		
		System.out.println("Pre-Condition - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		homePage = new HomePageObject(driver);
	}
	
	@Test
	public void TC01() {
		//waitForElementClickable(driver,"//a[contains(text(),'Log in')]");
		//clickToElement(driver,"//a[contains(text(),'Log in')]");
		System.out.println("TC1");
		System.out.println("Click Login link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		System.out.println("Click login Button");
		loginPage.clickToLoginButton();
		System.out.println("Verify error email");
		Assert.assertEquals(loginPage.getErrorEmailTxtbox(),"Please enter your email" );
		sleepInSecond(3);
	}
	
	@Test
	public void TC02() {
		System.out.println("TC2");
		System.out.println("Click Login link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		System.out.println("Enter input");
		loginPage.enterToEmailTextbox("abc123");
		loginPage.enterToPasswordTextbox("123456");
		System.out.println("Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Verify error email");
		Assert.assertEquals(loginPage.getErrorEmailTxtbox(), "Wrong email");
		sleepInSecond(3);
	}
	
	@Test
	public void TC03() {
		System.out.println("TC3");
		System.out.println("Click Login link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		System.out.println("Enter input");
		loginPage.enterToEmailTextbox("abc123@gmail.com");
		loginPage.enterToPasswordTextbox("123456");
		System.out.println("Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Verify error message");
		Assert.assertEquals(loginPage.getMessageError(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		sleepInSecond(3);
	}
	
	@Test
	public void TC04() {
		System.out.println("TC4");
		System.out.println("Click Login link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		System.out.println("Enter input");
		loginPage.enterToEmailTextbox("anhtuan111@gmail.com");
		loginPage.enterToPasswordTextbox("");
		System.out.println("Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Verify error message");
		Assert.assertEquals(loginPage.getMessageError(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		sleepInSecond(3);
	}
	
	@Test
	public void TC05() {
		System.out.println("TC5");
		System.out.println("Click Login link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		System.out.println("Enter input");
		loginPage.enterToEmailTextbox("anhtuan111@gmail.com");
		loginPage.enterToPasswordTextbox("12345");
		System.out.println("Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Verify error message");
		Assert.assertEquals(loginPage.getMessageError(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect" );
		sleepInSecond(3);
	}
	
	@Test
	public void TC06() {
		System.out.println("TC6");
		System.out.println("Click Login link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		System.out.println("Enter input");
		loginPage.enterToEmailTextbox("anhtuan111@gmail.com");
		loginPage.enterToPasswordTextbox("123456");
		System.out.println("Login Button");
		loginPage.clickToLoginButton();
		Assert.assertEquals(getPageTitle(driver), "nopCommerce demo store");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
