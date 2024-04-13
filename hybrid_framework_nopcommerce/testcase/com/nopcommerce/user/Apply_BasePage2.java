package com.nopcommerce.user;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopCommerce.portal.HomePageObject;
import pageObjects.nopCommerce.portal.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Apply_BasePage2 extends BaseTest{
	WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		System.out.println("Run on "+ browserName);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
		homePage = new HomePageObject(driver);
		
	}
	
	@Test
	public void TC01() throws InterruptedException {
		
		homePage.clickToRegisterLink();
		
		//click register link -> nhảy qua trang register
		registerPage = new RegisterPageObject(driver);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(),"First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConPasswordTextbox(), "Password is required.");
		Thread.sleep(3000);
	}
	
	@Test
	public void TC02() throws InterruptedException {
		homePage.clickToRegisterLink();
		//click register link -> nhảy qua trang register
		registerPage = new RegisterPageObject(driver);
		
		registerPage.inputToFirstnameTextbox("Automation");
		registerPage.inputToLastnameTextbox("FC");
		registerPage.inputToEmailTextbox("123@456#%*");
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
		Thread.sleep(3000);
	}
	@Test
	public void TC03() throws InterruptedException {
		homePage.clickToRegisterLink();
		//click register link -> nhảy qua trang register
		registerPage = new RegisterPageObject(driver);
		
		registerPage.inputToFirstnameTextbox("Automation");
		registerPage.inputToLastnameTextbox("FC");
		registerPage.inputToEmailTextbox(generateEmail());
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		Thread.sleep(2000);
		registerPage.clickLinkRegister();
		Thread.sleep(3000);
	}
	//@Test
	public void TC04() throws InterruptedException {
		homePage.clickToRegisterLink();	
		//click register link -> nhảy qua trang register
		registerPage = new RegisterPageObject(driver);
		
		registerPage.inputToFirstnameTextbox("Automation");
		registerPage.inputToLastnameTextbox("FC");
		registerPage.inputToEmailTextbox("anhtuan123@gmail.com");
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(),"The specified email already exists");
		Thread.sleep(3000);
	}
	//@Test
	public void TC05() throws InterruptedException {
		homePage.clickToRegisterLink();
		//click register link -> nhảy qua trang register
		registerPage = new RegisterPageObject(driver);
		
		registerPage.inputToFirstnameTextbox("Automation");
		registerPage.inputToLastnameTextbox("FC");
		registerPage.inputToEmailTextbox(generateEmail());
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password must meet the following rules:\nmust have at least 6 characters");
		Thread.sleep(3000);
	}
	//@Test
	public void TC06() throws InterruptedException {
		homePage.clickToRegisterLink();	
		//click register link -> nhảy qua trang register
		registerPage = new RegisterPageObject(driver);
		
		registerPage.inputToFirstnameTextbox("Automation");
		registerPage.inputToLastnameTextbox("FC");
		registerPage.inputToEmailTextbox(generateEmail());
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123654");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessageAtConPasswordTextbox(), "The password and confirmation password do not match.");
		Thread.sleep(3000);
	}
	
	private static final String[] DOMAINS = { "gmail.com", "yahoo.com", "hotmail.com", "outlook.com" };
    public static String generateEmail() {
        Random random = new Random();

        // Generate a random username
        StringBuilder username = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            username.append(randomChar);
        }

        // Add the domain
        StringBuilder email = new StringBuilder();
        email.append(username);
        email.append("@");
        int domainIndex = random.nextInt(DOMAINS.length);
        email.append(DOMAINS[domainIndex]);

        return email.toString();
    }
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
