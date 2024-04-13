package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstant;
import commons.PageGeneratorManager;
import pageObjects.admin.nopCommerce.AdminLoginPageObject;
import pageObjects.admin.nopCommerce.DashboardObject;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import pageObjects.nopCommerce.portal.UserRewardPointPageObject;

public class SwitchRole extends BaseTest{
	WebDriver driver;
	//private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private DashboardObject adminDashboardPage;
	private String userEmailAddress, userPassword, adminEmailAddress, adminPassword;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		userEmailAddress = "automationfc1611@gmail.com.vn";
		userPassword = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
	}
	
	@Test(priority = 1)
	public void UsertoAdmin() throws InterruptedException {
		userLoginPage = userHomePage.clickToLoginLink();
		//Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		// Home Page -> customer info
		
		userHomePage.openMyAccountPage();
		// Customer Info -> click logout -> HomePage
		userHomePage.clickToLogoutAtUserPage(driver);
		//User Home Page -> Open admin page -> login (admin)
		userHomePage.openPageUrl(driver, GlobalConstant.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		//Login as Admin role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderIsDisplayed());
		Assert.assertTrue(adminDashboardPage.areJQueryAndJSLoadedSuccess(driver));
		//Dashboard page -> click logout -> login page(admin)
		adminLoginPage = adminDashboardPage.clickToLogoutAtAdminPage(driver);
		Thread.sleep(3000);
	}
	
	@Test(priority = 2)
	public void AdmintoUser() {
		//Login Page(admin) -> open user url -> home page(user)
		
		adminLoginPage.openPageUrl(driver, GlobalConstant.PORTAL_PAGE_URL);
	
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		//Home Page -> Login Page(user)
		userLoginPage = userHomePage.clickToLoginLink();
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());	
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
