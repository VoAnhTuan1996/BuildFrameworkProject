package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class User_02_My_Account extends BasePage{
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//Initial (khởi tạo)
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}
	
	//@Test
	public void TC01() {
		waitForElementClickable(driver,"//a[contains(text(),'Log in')]");
		clickToElement(driver,"//a[contains(text(),'Log in')]");
		sendKeyToElement(driver,"//input[@id='Email']","automationfc.vn@gmail.com");
		sendKeyToElement(driver,"//input[@id='Password']","123456");
		clickToElement(driver,"//button[contains(text(),'Log in')]");
		waitForElementClickable(driver,"//a[text()='My account']");
		clickToElement(driver,"//a[text()='My account']");
		sleepInSecond(2);
		clickToElement(driver,"//input[@id='gender-female']");
		selectItemInDefaultDropdown(driver,"//select[@name='DateOfBirthYear']","1999");
		sendKeyToElement(driver,"//input[@id='Company']","Automation FC");
		clickToElement(driver,"//button[@id='save-info-button']");
		Assert.assertEquals(getElementText(driver,"//div[@id='bar-notification']//p"),"The customer info has been updated successfully.");
		sleepInSecond(2);
	}
	//@Test
	public void TC02() {
		waitForElementClickable(driver,"//li[contains(@class,'customer-addresses')]//a");
		clickToElement(driver,"//li[contains(@class,'customer-addresses')]//a");
		waitForElementClickable(driver,"//button[contains(text(),'Add new')]");
		clickToElement(driver,"//button[contains(text(),'Add new')]");
		sendKeyToElement(driver,"//input[@id='Address_FirstName']","Automation");
		sendKeyToElement(driver,"//input[@id='Address_LastName']","FC");
		sendKeyToElement(driver,"//input[@id='Address_Email']","automationfc.vn@gmail.com");
		sendKeyToElement(driver,"//input[@id='Address_Company']","Automation FC");
		scrollToElement(driver,"//select[@id='Address_CountryId']");
		selectItemInDefaultDropdown(driver,"//select[@id='Address_CountryId']","82");
		sendKeyToElement(driver,"//input[@id='Address_City']","Da Nang");
		sendKeyToElement(driver,"//input[@id='Address_Address1']","123 Le Loi");
		sendKeyToElement(driver,"//input[@id='Address_Address2']","234/05 Hai Phong");
		sendKeyToElement(driver,"//input[@id='Address_ZipPostalCode']","550000");
		sendKeyToElement(driver,"//input[@id='Address_PhoneNumber']","0123456789");
		sendKeyToElement(driver,"//input[@id='Address_FaxNumber']","0987654321");
		waitForElementClickable(driver,"//button[contains(text(),'Save')]");
		clickToElement(driver,"//button[contains(text(),'Save')]");
		Assert.assertEquals(getElementText(driver,"//div[@id='bar-notification']//p"),"The new address has been added successfully.");
		sleepInSecond(2);
	}
	//@Test
	public void TC03() {
		waitForElementClickable(driver,"//a[contains(text(),'Change password')]");
		clickToElement(driver,"//a[contains(text(),'Change password')]");
		sendKeyToElement(driver,"//input[@id='OldPassword']","123456");
		sendKeyToElement(driver,"//input[@id='NewPassword']","12345678");
		sendKeyToElement(driver,"//input[@id='ConfirmNewPassword']","12345678");
		waitForElementClickable(driver,"//button[contains(text(),'Change password')]");
		clickToElement(driver,"//button[contains(text(),'Change password')]");
		Assert.assertEquals(getElementText(driver,"//div[@id='bar-notification']//p"),"Password was changed");
		sleepInSecond(2);
	}
	@Test
	public void TC04() {
		waitForElementClickable(driver,"//a[contains(text(),'Log in')]");
		clickToElement(driver,"//a[contains(text(),'Log in')]");
		sendKeyToElement(driver,"//input[@id='Email']","anhtuan123@gmail.com");
		sendKeyToElement(driver,"//input[@id='Password']","12345678");
		clickToElement(driver,"//button[contains(text(),'Log in')]");
		waitForElementClickable(driver,"//a[text()='My account']");
		clickToElement(driver,"//a[text()='My account']");
		waitForElementClickable(driver,"//ul[contains(@class,'notmobile')]//a[@href='/computers']");
		clickToElement(driver,"//ul[contains(@class,'notmobile')]//a[@href='/computers']");
		waitForElementClickable(driver,"//div[@class='picture']//a[@href='/desktops']");
		clickToElement(driver,"//div[@class='picture']//a[@href='/desktops']");
		waitForElementClickable(driver,"//img[@alt='Picture of Digital Storm VANQUISH 3 Custom Performance PC']");
		clickToElement(driver,"//img[@alt='Picture of Digital Storm VANQUISH 3 Custom Performance PC']");
		waitForElementClickable(driver,"//a[contains(text(),'Add your review')]");
		clickToElement(driver,"//a[contains(text(),'Add your review')]");
		sendKeyToElement(driver,"//input[@id='AddProductReview_Title']","review cpu");
		sendKeyToElement(driver,"//textarea[@id='AddProductReview_ReviewText']","very good");
		clickToElement(driver,"//button[contains(text(),'Submit review')]");
		waitForElementClickable(driver,"//a[text()='My account']");
		clickToElement(driver,"//a[text()='My account']");
		clickToElement(driver,"//a[contains(text(),'My product reviews')]");
		Assert.assertTrue(getWebElement(driver,"//div[@class='review-info']").isDisplayed(),"true");
	}
	
	@AfterClass()
	public void afterClass() {
		driver.quit();
	}
}
