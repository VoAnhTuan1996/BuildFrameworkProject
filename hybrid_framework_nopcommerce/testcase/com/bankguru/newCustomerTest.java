package com.bankguru;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.bankguru.DashboardPageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.NewCustomerPageObject;
import pageObjects.bankguru.PageGeneratorManager;

public class newCustomerTest extends BaseTest{
	private WebDriver driver;
	private String browserName, userName, passWord; 
	private String customerName, gender, dateOfBirth, address, city, state, pin, mobileNumber, email;
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int USERNAME_LENGTH = 10;
    private static final String DOMAIN = "example.com";
	private LoginPageObject loginPage;
	private DashboardPageObject dashboardPage;
	private NewCustomerPageObject newCustomerPage;
	
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
		newCustomerPage = dashboardPage.openNewCustomerPage();
		
	}
	
	public static String randomEmail() {
		StringBuilder username = new StringBuilder();
        Random random = new Random();
        
        for (int i = 0; i < USERNAME_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            username.append(CHARACTERS.charAt(index));
        }

        return username.toString() + "@" + DOMAIN;
	}
	
	
	@Test (priority=1)
	public void Verify_Name_Field() {
		customerName="";
		newCustomerPage.enterCustomerNameTxtbox(customerName);
		Assert.assertEquals(newCustomerPage.getMessageErrorCustomerNameText(),"Customer name must not be blank");
		newCustomerPage.sleepInSecond(1);
		customerName="1234";
		newCustomerPage.enterCustomerNameTxtbox(customerName);
		Assert.assertEquals(newCustomerPage.getMessageErrorCustomerNameText(),"Numbers are not allowed");
		newCustomerPage.sleepInSecond(1);
		customerName="name123";
		newCustomerPage.enterCustomerNameTxtbox(customerName);
		Assert.assertEquals(newCustomerPage.getMessageErrorCustomerNameText(),"Numbers are not allowed");
		newCustomerPage.sleepInSecond(1);
		customerName="name!@#";
		newCustomerPage.enterCustomerNameTxtbox(customerName);
		Assert.assertEquals(newCustomerPage.getMessageErrorCustomerNameText(),"Special characters are not allowed");
		newCustomerPage.sleepInSecond(1);
		customerName=""+Keys.SPACE;
		newCustomerPage.enterCustomerNameTxtbox(customerName);
		Assert.assertEquals(newCustomerPage.getMessageErrorCustomerNameText(),"First character can not have space");
		newCustomerPage.sleepInSecond(1);
	}
	
	@Test (priority=2)
	public void Verify_Address_Field() {
		address="";
		newCustomerPage.enterAddressTxtArea(address);
		Assert.assertEquals(newCustomerPage.getMessageErrorAddressText(),"Address Field must not be blank");
		newCustomerPage.sleepInSecond(1);
		address=""+Keys.SPACE;
		newCustomerPage.enterAddressTxtArea(address);
		Assert.assertEquals(newCustomerPage.getMessageErrorAddressText(),"First character can not have space");
		newCustomerPage.sleepInSecond(1);
	}
	
	@Test (priority=3)
	public void Verify_City_Field() {
		city="";
		newCustomerPage.enterCityTxtbox(city);
		Assert.assertEquals(newCustomerPage.getMessageErrorCityText(),"City Field must not be blank");
		city="city123";
		newCustomerPage.enterCityTxtbox(city);
		Assert.assertEquals(newCustomerPage.getMessageErrorCityText(), "Numbers are not allowed");
		city="City!@#";
		newCustomerPage.enterCityTxtbox(city);
		Assert.assertEquals(newCustomerPage.getMessageErrorCityText(), "Special characters are not allowed");
		city=""+Keys.SPACE;
		newCustomerPage.enterCityTxtbox(city);
		Assert.assertEquals(newCustomerPage.getMessageErrorCityText(),"First character can not have space");
		newCustomerPage.sleepInSecond(1);
	}
	
	@Test (priority=4)
	public void Verify_State_Field() {
		state="";
		newCustomerPage.enterStateTxtbox(state);
		Assert.assertEquals(newCustomerPage.getMessageErrorStateText(),"State must not be blank");
		state="State123";
		newCustomerPage.enterStateTxtbox(state);
		Assert.assertEquals(newCustomerPage.getMessageErrorStateText(), "Numbers are not allowed");
		state="State!@#";
		newCustomerPage.enterStateTxtbox(state);
		Assert.assertEquals(newCustomerPage.getMessageErrorStateText(), "Special characters are not allowed");
		state=""+Keys.SPACE;
		newCustomerPage.enterStateTxtbox(state);
		Assert.assertEquals(newCustomerPage.getMessageErrorStateText(),"First character can not have space");
		newCustomerPage.sleepInSecond(1);
	}
	
	@Test (priority=5)
	public void Verify_PIN_Field() {
		pin="";
		newCustomerPage.enterPINTxtbox(pin);
		Assert.assertEquals(newCustomerPage.getMessageErrorPinText(),"PIN Code must not be blank");
		pin="1234PIN";
		newCustomerPage.enterPINTxtbox(pin);
		Assert.assertEquals(newCustomerPage.getMessageErrorPinText(),"Characters are not allowed");
		pin="123";
		newCustomerPage.enterPINTxtbox(pin);
		Assert.assertEquals(newCustomerPage.getMessageErrorPinText(),"PIN Code must have 6 Digits");
		pin="123!@#";
		newCustomerPage.enterPINTxtbox(pin);
		Assert.assertEquals(newCustomerPage.getMessageErrorPinText(),"Special characters are not allowed");
		pin=""+Keys.SPACE;
		newCustomerPage.enterPINTxtbox(pin);
		Assert.assertEquals(newCustomerPage.getMessageErrorPinText(),"First character can not have space");
		newCustomerPage.sleepInSecond(1);
	}
	
	@Test (priority=6)
	public void Verify_Phone_Field() {
		mobileNumber="";
		newCustomerPage.enterPhoneTxtbox(mobileNumber);
		Assert.assertEquals(newCustomerPage.getMessageErrorPhoneText(),"Mobile no must not be blank");
		mobileNumber="123 123";
		newCustomerPage.enterPhoneTxtbox(mobileNumber);
		Assert.assertEquals(newCustomerPage.getMessageErrorPhoneText(),"Characters are not allowed");
		mobileNumber="8866!@#123";
		newCustomerPage.enterPhoneTxtbox(mobileNumber);
		Assert.assertEquals(newCustomerPage.getMessageErrorPhoneText(),"Special characters are not allowed");
		mobileNumber=""+Keys.SPACE;
		newCustomerPage.enterPhoneTxtbox(mobileNumber);
		Assert.assertEquals(newCustomerPage.getMessageErrorPhoneText(),"First character can not have space");
		newCustomerPage.sleepInSecond(1);
	}
	
	@Test (priority=7)
	public void Verify_Email_Field() {
		email="";
		newCustomerPage.enterEmailTxtbox(email);
		Assert.assertEquals(newCustomerPage.getMessageErrorEmailText(),"Email-ID must not be blank");
		email="guru99@gmail";
		newCustomerPage.enterEmailTxtbox(email);
		Assert.assertEquals(newCustomerPage.getMessageErrorEmailText(),"Email-ID is not valid");
		email="guru99gmail";
		newCustomerPage.enterEmailTxtbox(email);
		Assert.assertEquals(newCustomerPage.getMessageErrorEmailText(),"Email-ID is not valid");
		email="guru99";
		newCustomerPage.enterEmailTxtbox(email);
		Assert.assertEquals(newCustomerPage.getMessageErrorEmailText(),"Email-ID is not valid");
		email="guru99@";
		newCustomerPage.enterEmailTxtbox(email);
		Assert.assertEquals(newCustomerPage.getMessageErrorEmailText(),"Email-ID is not valid");
		email=""+Keys.SPACE;
		newCustomerPage.enterEmailTxtbox(email);
		Assert.assertEquals(newCustomerPage.getMessageErrorEmailText(),"First character can not have space");
	}
	
	@Test(priority=8)
	public void Verify_Field_Labels() {
		newCustomerPage.isLabelNameIsDisplayed("Customer Name");
		newCustomerPage.isLabelNameIsDisplayed("Gender");
		newCustomerPage.isLabelNameIsDisplayed("Date of Birth");
		newCustomerPage.isLabelNameIsDisplayed("Address");
		newCustomerPage.isLabelNameIsDisplayed("City");
		newCustomerPage.isLabelNameIsDisplayed("State");
		newCustomerPage.isLabelNameIsDisplayed("State");
		newCustomerPage.isLabelNameIsDisplayed("PIN");
		newCustomerPage.isLabelNameIsDisplayed("Mobile Number");
		newCustomerPage.isLabelNameIsDisplayed("E-mail");
		newCustomerPage.isLabelNameIsDisplayed("Password");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
