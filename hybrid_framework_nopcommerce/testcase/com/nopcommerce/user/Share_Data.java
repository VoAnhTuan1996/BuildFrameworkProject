package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_Register_Cookies;
import com.nopcommerce.common.Common_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import pageObjects.nopCommerce.portal.UserRewardPointPageObject;

public class Share_Data extends BaseTest {
	WebDriver driver;
	//private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private String emailAddress, validPassword;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		emailAddress = Common_Register_End_User.emailAddress;
		validPassword = Common_Register_End_User.password;
		
		log.info("Login - Step 01: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Enter to email and password textbox");
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(validPassword);
		
		log.info("Login - Step 03: Click to login button");
		loginPage.clickToLoginButton();
		
		/*
		 * log.info("Login - Step 04: Set cookie and reload page");
		 * loginPage.setCookies(driver, Common_Register_Cookies.loggedCookies);
		 * for(Cookie cookie: Common_Register_Cookies.loggedCookies) {
		 * System.out.println("Cookie at: "+ cookie); }
		 * loginPage.refreshCurrentPage(driver);
		 */
		
		log.info("Login - Step 05: Verify my account link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed()); //My account

	}
	

	
	@Test
	public void Search() {
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
