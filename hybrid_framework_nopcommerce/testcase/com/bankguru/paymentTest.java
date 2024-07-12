package com.bankguru;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.bankguru.DashboardPageObject;
import pageObjects.bankguru.DeleteCustomerPageObject;
import pageObjects.bankguru.DepositPageObject;
import pageObjects.bankguru.EditAccountPageObject;
import pageObjects.bankguru.EditCustomerPageObject;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.NewAccountPageObject;
import pageObjects.bankguru.NewCustomerPageObject;
import pageObjects.bankguru.PageGeneratorManager;

public class paymentTest extends BaseTest {
	private WebDriver driver;
	private String browserName, userName, passWord; 
	private String customerID, customerName, accountNo, dateOfBirth, address, city, state, pin, mobileNumber, email, passCustomer, amount, description;
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int USERNAME_LENGTH = 10;
    private static final String DOMAIN = "gmail.com";
	private LoginPageObject loginPage;
	private DashboardPageObject dashboardPage;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editCustomerPage;
	private DeleteCustomerPageObject deleteCustomerPage;
	private NewAccountPageObject newAccountPage;
	private EditAccountPageObject editAccountPage;
	private DepositPageObject depositPage;
	
	@Parameters({"url","browser"})
	@BeforeClass
	public void beforeClass(String url, String browserName) {
		driver = getBrowserDriver(browserName, url);
		this.browserName = browserName;
		userName = "mngr578302";
		passWord = "dYtYmem";
		customerName="AUTOMATION TESTING";
		dateOfBirth = "01/01/1989";
		address = "PO Box 911 8331 Duis Avenue";
		city = "Tampa";
		state = "FL";
		pin = "466250";
		mobileNumber = "4555442776";
		email = randomEmail();
		passCustomer = "automation";
		amount = "5000";
		description = "deposit";
		
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
	
	@Test
	public void TC01() {
		newCustomerPage.enterCustomerNameTxtbox(customerName);
		newCustomerPage.enterDOBDateTimePicker(dateOfBirth);
		newCustomerPage.enterAddressTxtArea(address);
		newCustomerPage.enterCityTxtbox(city);
		newCustomerPage.enterStateTxtbox(state);
		newCustomerPage.enterPhoneTxtbox(mobileNumber);
		newCustomerPage.enterPINTxtbox(pin);
		newCustomerPage.enterEmailTxtbox(email);
		newCustomerPage.enterPasswordTxtbox(passCustomer);
		newCustomerPage.clickSubmitButton();
		newCustomerPage.sleepInSecond(5);
		Assert.assertEquals(newCustomerPage.getMessageSuccessfulText(),"Customer Registered Successfully!!!");
		Assert.assertEquals(newCustomerPage.getCustomerNameText(), customerName);
		Assert.assertEquals(newCustomerPage.getAddressText(),address);
		Assert.assertEquals(newCustomerPage.getBirthDateText(),"1989-01-01");
		Assert.assertEquals(newCustomerPage.getCityText(),city);
		Assert.assertEquals(newCustomerPage.getStateText(),state);
		Assert.assertEquals(newCustomerPage.getPhoneText(),mobileNumber);
		Assert.assertEquals(newCustomerPage.getPinText(),pin);
		Assert.assertEquals(newCustomerPage.getEmailText(),email);
	}
	
	//@Test
	public void TC02() {
		customerID = newCustomerPage.getCustomerIDText();
		newCustomerPage.clickDynamicPageByLabelName("Edit Customer");
		editCustomerPage = PageGeneratorManager.getEditCustomerPage(driver);
		editCustomerPage.enterCustomerIDTxtbox(customerID);
		editCustomerPage.clickToSubmitButton1();
		editCustomerPage.editAddressArea("1883 Cursus Avenue");
		editCustomerPage.editCityTxtbox("Houston");
		editCustomerPage.editStateTxtbox("Texas");
		editCustomerPage.editPINTxtbox("166455");
		editCustomerPage.clickToSubmitButton2();
	}
	
	@Test
	public void TC03() {
		customerID = newCustomerPage.getCustomerIDText();
		newCustomerPage.clickDynamicPageByLabelName("New Account");
		newAccountPage = PageGeneratorManager.getNewAccountPage(driver);
		newAccountPage.enterCustomerID(customerID);
		newAccountPage.selectAccountTypeDropdown("Savings");
		newAccountPage.sleepInSecond(3);
		newAccountPage.enterInitialDeposit("50000");
		newAccountPage.clickSubmitButton();
		Assert.assertEquals(newAccountPage.getDynamicMessageSuccessful(), "Account Generated Successfully!!!");
	}
	
	@Test
	public void TC04() {
		accountNo = newAccountPage.getAccountIDText();
		newAccountPage.clickDynamicPageByLabelName("Edit Account");
		editAccountPage = PageGeneratorManager.getEditAccountPage(driver);
		editAccountPage.enterAccountNo(accountNo);
		editAccountPage.clickSubmitButton();
	}
	
	@Test
	public void TC05() {
		/*accountNo = newAccountPage.getAccountIDText();*/
		editAccountPage.clickDynamicPageByLabelName("Deposit");
		depositPage = PageGeneratorManager.getDepositPage(driver);
		depositPage.enterAccountNo(accountNo);
		depositPage.enterAmount(amount);
		depositPage.enterDescription(description);
		depositPage.clickSubmitButton();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
