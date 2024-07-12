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
import pageObjects.bankguru.EditCustomerPageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.PageGeneratorManager;

public class editCustomerTest extends BaseTest {
	private WebDriver driver;
	private String browserName, userName, passWord, customerID;
	private String customerName, gender, dateOfBirth, address, city, state, pin, phone, email;
	private LoginPageObject loginPage;
	private DashboardPageObject dashboardPage;
	private EditCustomerPageObject editCustomerPage;
	
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
		editCustomerPage = dashboardPage.openEditCustomerPage();
		
	}
	
	@Test (priority = 1)
	public void verifyCustomerID() {
		customerID = "";
		editCustomerPage.enterCustomerIDTxtbox(customerID);
		Assert.assertEquals(editCustomerPage.getMessageErrorCustomerIDText(),"Customer ID is required");
		customerID = "1234Acc";
		editCustomerPage.enterCustomerIDTxtbox(customerID);
		Assert.assertEquals(editCustomerPage.getMessageErrorCustomerIDText(),"Characters are not allowed");
		customerID = "123!@#";
		editCustomerPage.enterCustomerIDTxtbox(customerID);
		Assert.assertEquals(editCustomerPage.getMessageErrorCustomerIDText(),"Special characters are not allowed");
		customerID = "84207";
		editCustomerPage.enterCustomerIDTxtbox(customerID);
		editCustomerPage.clickToSubmitButton1();
		Assert.assertTrue(editCustomerPage.isTitleEditCustomerDisplayed());
	}
	
	@Test (priority = 2)
	public void verifyAddressField() {
		address= "";
		editCustomerPage.editAddressArea(address);
		Assert.assertEquals(editCustomerPage.getMessageErrorAddressAreaText(),"Address Field must not be blank");
	}
	
	@Test (priority = 3)
	public void verifyCityField() {
		city="";
		editCustomerPage.editCityTxtbox(city);
		Assert.assertEquals(editCustomerPage.getMessageErrorCityTxtboxText(),"City Field must not be blank");
		city="city123";
		editCustomerPage.editCityTxtbox(city);
		Assert.assertEquals(editCustomerPage.getMessageErrorCityTxtboxText(),"Numbers are not allowed");
		city="city!@#";
		editCustomerPage.editCityTxtbox(city);
		Assert.assertEquals(editCustomerPage.getMessageErrorCityTxtboxText(),"Special characters are not allowed");
	}
	
	@Test (priority = 4)
	public void verifyStateField() {
		state="";
		editCustomerPage.editStateTxtbox(state);
		Assert.assertEquals(editCustomerPage.getMessageErrorStateTxtboxText(),"State must not be blank");
		state="abc123";
		editCustomerPage.editStateTxtbox(state);
		Assert.assertEquals(editCustomerPage.getMessageErrorStateTxtboxText(),"Numbers are not allowed");
		state="abc!@!xyz";
		editCustomerPage.editStateTxtbox(state);
		Assert.assertEquals(editCustomerPage.getMessageErrorStateTxtboxText(),"Special characters are not allowed");
	}
	
	@Test (priority = 5)
	public void verifyPINField() {
		pin="";
		editCustomerPage.editPINTxtbox(pin);
		Assert.assertEquals(editCustomerPage.getMessageErrorPINTxtboxText(),"PIN Code must not be blank");
		pin="123";
		editCustomerPage.editPINTxtbox(pin);
		Assert.assertEquals(editCustomerPage.getMessageErrorPINTxtboxText(),"PIN Code must have 6 Digits");
		pin="123!@#";
		editCustomerPage.editPINTxtbox(pin);
		Assert.assertEquals(editCustomerPage.getMessageErrorPINTxtboxText(),"Special characters are not allowed");
		pin=""+Keys.SPACE;
		editCustomerPage.editPINTxtbox(pin);
		Assert.assertEquals(editCustomerPage.getMessageErrorPINTxtboxText(),"First character can not have space");
	}
	
	@Test(priority = 6)
	public void verifyPhoneField() {
		phone="";
		editCustomerPage.editPhoneTxtbox(phone);
		Assert.assertEquals(editCustomerPage.getMessageErrorPhoneTxtboxText(),"Mobile no must not be blank");
		phone=""+Keys.SPACE;
		editCustomerPage.editPhoneTxtbox(phone);
		Assert.assertEquals(editCustomerPage.getMessageErrorPhoneTxtboxText(),"First character can not have space");
		phone="123 123123";
		editCustomerPage.editPhoneTxtbox(phone);
		Assert.assertEquals(editCustomerPage.getMessageErrorPhoneTxtboxText(),"Characters are not allowed");
		phone="123!@#123";
		editCustomerPage.editPhoneTxtbox(phone);
		Assert.assertEquals(editCustomerPage.getMessageErrorPhoneTxtboxText(),"Special characters are not allowed");
	}
	
	@Test(priority = 7)
	public void verifyEmailField() {
		email="";
		editCustomerPage.editEmailTxtbox(email);
		Assert.assertEquals(editCustomerPage.getMessageErrorEmailTxtboxText(),"Email-ID must not be blank");
		email="anhtuan123@gmail";
		editCustomerPage.editEmailTxtbox(email);
		Assert.assertEquals(editCustomerPage.getMessageErrorEmailTxtboxText(),"Email-ID is not valid");
		email=""+Keys.SPACE;
		editCustomerPage.editEmailTxtbox(email);
		Assert.assertEquals(editCustomerPage.getMessageErrorEmailTxtboxText(),"First character can not have space");
	}
	
	@Test (priority = 8)
	public void Verify_Field_Labels() {
		editCustomerPage.isLabelNameIsDisplayed("Customer Name");
		editCustomerPage.isLabelNameIsDisplayed("Gender");
		editCustomerPage.isLabelNameIsDisplayed("Date of Birth");
		editCustomerPage.isLabelNameIsDisplayed("Address");
		editCustomerPage.isLabelNameIsDisplayed("City");
		editCustomerPage.isLabelNameIsDisplayed("State");
		editCustomerPage.isLabelNameIsDisplayed("State");
		editCustomerPage.isLabelNameIsDisplayed("PIN");
		editCustomerPage.isLabelNameIsDisplayed("Mobile Number");
		editCustomerPage.isLabelNameIsDisplayed("E-mail");
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
