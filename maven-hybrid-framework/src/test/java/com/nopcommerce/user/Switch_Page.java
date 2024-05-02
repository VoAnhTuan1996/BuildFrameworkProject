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

public class Switch_Page extends BaseTest {
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
	public void User01_Register() {
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
		//Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.print("Pre-Condition - Step 05: Click to logout");
		homePage = registerPage.clickLinkRegister();
		
	}
	
	@Test
	public void User_02_Login() {		
		loginPage = homePage.clickToLoginLink();
		
		loginPage.enterToEmailTextbox("anhtuan123@gmail.com");
		loginPage.enterToPasswordTextbox("123456");
		
		loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
	}
	
	@Test
	public void User_03_My_Account() {
		customerInfoPage = homePage.openMyAccountPage();
		Assert.assertTrue(customerInfoPage.isCustomerInfoDisplayed());
	}
	
	@Test
	public void User_04_SwitchPage() {
		//Customer Info -> Address
		addressPage = customerInfoPage.openAddressPage(driver);
		System.out.println("Customer Info -> Address");
		//Address -> My Product Review
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		System.out.println("Address -> My Product Review");
		//My Product Review -> Reward Point
		rewardPointPage = myProductReviewPage.openRewardPoint(driver);
		System.out.println("My Product Review -> Reward Point");
		//Reward Point-> Address
		addressPage = rewardPointPage.openAddressPage(driver);
		System.out.println("Reward Point-> Address");
		//Address -> Reward Point
		rewardPointPage = addressPage.openRewardPoint(driver);
		System.out.println("Address -> Reward Point");
		//Reward Point -> My Product Review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		System.out.println("Reward Point -> My Product Review");
		//My Product Review -> Address
		addressPage = myProductReviewPage.openAddressPage(driver);
		System.out.println("My Product Review -> Address");
		customerInfoPage = addressPage.openCustomerInfoPage(driver);
		System.out.println("Address -> Customer Info");
		myProductReviewPage = customerInfoPage.openMyProductReviewPage(driver);
		System.out.println("Customer Info -> My Product Review");
	}
	
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
