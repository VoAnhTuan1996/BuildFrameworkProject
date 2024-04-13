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

public class Assert_Verify extends BaseTest {
	WebDriver driver;
	//private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		System.out.println("Run on "+ browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	}
	
	@Test
	public void User01_Register_Login() {
		System.out.println("Pre-Condition - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		System.out.println("Pre-Condition - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox("Automation");
		registerPage.inputToLastnameTextbox("FC");
		registerPage.inputToEmailTextbox("anhtuan123@gmail.com");
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		
		System.out.println("Pre-Condition - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Pre-Condition - Step 04: Verify success message displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.print("Pre-Condition - Step 05: Click to logout");
		homePage = registerPage.clickLinkRegister();
		
		loginPage = homePage.clickToLoginLink();
		
		loginPage.enterToEmailTextbox("anhtuan123@gmail.com");
		loginPage.enterToPasswordTextbox("123456");
		
		loginPage.clickToLoginButton();
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		//My account
		customerInfoPage = homePage.openMyAccountPage();
		verifyTrue(customerInfoPage.isCustomerInfoDisplayed());
	}
	

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
