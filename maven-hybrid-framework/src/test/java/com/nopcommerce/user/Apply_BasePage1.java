package com.nopcommerce.user;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Apply_BasePage1 {
	WebDriver driver;

	BasePage basePage;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		//Initial (khởi tạo)
		basePage = BasePage.getBasePageObject();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}
	
	@Test
	public void TC01() {
		basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.waitForElementClickable(driver,"//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver,"//span[@id='FirstName-error']"),"First name is required.");
		Assert.assertEquals(basePage.getElementText(driver,"//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']"), "Password is required.");
	}
	
	@Test
	public void TC02() {
		basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		
		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.sendKeyToElement(driver, "//input[@id='Email']","123@456#%*");
		basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']","123456");
		
		basePage.waitForElementClickable(driver,"//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Email-error']"), "Wrong email");
	}
	@Test
	public void TC03() {
		basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		
		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.sendKeyToElement(driver, "//input[@id='Email']",generateEmail());
		basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']","123456");
		
		basePage.waitForElementClickable(driver,"//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(basePage.getElementText(driver,"//div[@class='result']"), "Your registration completed");
		
		basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
	}
	@Test
	public void TC04() {
		basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		
		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.sendKeyToElement(driver, "//input[@id='Email']","anhtuan123@gmail.com");
		basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']","123456");
		
		basePage.waitForElementClickable(driver,"//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(basePage.getElementText(driver,"//div[contains(@class,'message-error')]//li"),"The specified email already exists");
	}
	@Test
	public void TC05() {
		basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		
		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.sendKeyToElement(driver, "//input[@id='Email']",generateEmail());
		basePage.sendKeyToElement(driver, "//input[@id='Password']", "123");
		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']","123");
		
		basePage.waitForElementClickable(driver,"//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"),"Password must meet the following rules:\nmust have at least 6 characters");
	}
	@Test
	public void TC06() {
		basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		
		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.sendKeyToElement(driver, "//input[@id='Email']",generateEmail());
		basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']","123654");
		
		basePage.waitForElementClickable(driver,"//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
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
