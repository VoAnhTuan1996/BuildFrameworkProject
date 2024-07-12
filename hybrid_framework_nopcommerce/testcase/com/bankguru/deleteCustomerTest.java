package com.bankguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.bankguru.DashboardPageObject;
import pageObjects.bankguru.DeleteCustomerPageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.PageGeneratorManager;

public class deleteCustomerTest extends BaseTest{
	private WebDriver driver;
	private String browserName, userName, passWord,customerID;
	private LoginPageObject loginPage;
	private DashboardPageObject dashboardPage;
	private DeleteCustomerPageObject deleteCustomerPage;
	
	@Parameters({"url","browser"})
	@BeforeClass
	public void beforeClass(String url, String browserName) {
		driver = getBrowserDriver(browserName, url);
		this.browserName = browserName;
		userName = "mngr578302";
		passWord = "dYtYmem";
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToUserNameTextbox(userName);
		loginPage.enterToPasswordTextbox(passWord);
		dashboardPage = loginPage.clickLoginButton();
		deleteCustomerPage = dashboardPage.openDeleteCustomerPage();
	}
	
	@Test (priority = 1)
	public void VerifyCustomerID() {
		customerID = "";
		deleteCustomerPage.enterCustomerIDTxtbox(customerID);
		Assert.assertEquals(deleteCustomerPage.getMessageErrorCustomerIDText(),"Customer ID is required");
		customerID = "Acc123";
		deleteCustomerPage.enterCustomerIDTxtbox(customerID);
		Assert.assertEquals(deleteCustomerPage.getMessageErrorCustomerIDText(),"Characters are not allowed");
		customerID = "123 123";
		deleteCustomerPage.enterCustomerIDTxtbox(customerID);
		Assert.assertEquals(deleteCustomerPage.getMessageErrorCustomerIDText(),"Characters are not allowed");
		customerID = "123!@#";
		deleteCustomerPage.enterCustomerIDTxtbox(customerID);
		Assert.assertEquals(deleteCustomerPage.getMessageErrorCustomerIDText(),"Special characters are not allowed");
		customerID = ""+Keys.SPACE;
		deleteCustomerPage.enterCustomerIDTxtbox(customerID);
		Assert.assertEquals(deleteCustomerPage.getMessageErrorCustomerIDText(),"First character can not have space");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
