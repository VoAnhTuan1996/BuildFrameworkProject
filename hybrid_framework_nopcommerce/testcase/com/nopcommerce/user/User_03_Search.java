package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class User_03_Search extends BasePage{
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
	@Test
	public void TC01() {
		waitForElementClickable(driver,"//a[contains(text(),'Log in')]");
		clickToElement(driver,"//a[contains(text(),'Log in')]");
		sendKeyToElement(driver,"//input[@id='Email']","automationfc.vn@gmail.com");
		sendKeyToElement(driver,"//input[@id='Password']","123456");
		clickToElement(driver,"//button[contains(text(),'Log in')]");
		scrollToBottomPage(driver);
		waitForElementClickable(driver,"//a[contains(text(),'Search')]");
		clickToElement(driver,"//a[contains(text(),'Search')]");
		clickToElement(driver,"//div[@class='buttons']//button");
		Assert.assertEquals(getElementText(driver,"//div[@class='warning']"),"Search term minimum length is 3 characters");
		sleepInSecond(3);
	}
	@Test
	public void TC02() {
		sendKeyToElement(driver,"//input[@id='q']","Macbook Pro 2050");
		clickToElement(driver,"//div[@class='buttons']//button");
		Assert.assertEquals(getElementText(driver,"//div[@class='no-result']"),"No products were found that matched your criteria.");
		sleepInSecond(3);
	}
	@Test
	public void TC03() {
		sendKeyToElement(driver,"//input[@id='q']","Lenovo");
		clickToElement(driver,"//div[@class='buttons']//button");
		Assert.assertTrue(getWebElement(driver,"//div[@class='product-item']").isDisplayed(),"true");
		sleepInSecond(3);
	}
	@Test
	public void TC04() {
		sendKeyToElement(driver,"//input[@id='q']","Thinkpad x1 carbon");
		clickToElement(driver,"//div[@class='buttons']//button");
		Assert.assertEquals(getElementText(driver,"//h2[@class='product-title']//a"), "Lenovo Thinkpad X1 Carbon Laptop");
		sleepInSecond(3);
	}
	@Test
	public void TC05() {
		sendKeyToElement(driver,"//input[@id='q']","apple macbook pro");
		clickToElement(driver,"//div[@class='buttons']//button");
		checkToDefaultCheckboxRadio(driver,"//input[@id='advs']");
		selectItemInDefaultDropdown(driver,"//select[@id='cid']","1");
		clickToElement(driver,"//div[@class='buttons']//button");
		Assert.assertEquals(getElementText(driver,"//div[@class='no-result']"),"No products were found that matched your criteria.");
		sleepInSecond(3);
	}
	@Test
	public void TC06() {
		checkToDefaultCheckboxRadio(driver,"//input[@id='isc']");
		clickToElement(driver,"//div[@class='buttons']//button");
		Assert.assertEquals(getElementText(driver,"//h2[@class='product-title']//a"), "Apple MacBook Pro 13-inch");
		sleepInSecond(3);	
	}
	@Test
	public void TC07() {
		selectItemInDefaultDropdown(driver,"//select[@id='mid']","2");
		clickToElement(driver,"//div[@class='buttons']//button");
		Assert.assertEquals(getElementText(driver,"//div[@class='no-result']"),"No products were found that matched your criteria.");
		sleepInSecond(3);
	}
	@Test
	public void TC08() {
		selectItemInDefaultDropdown(driver,"//select[@id='mid']","1");
		clickToElement(driver,"//div[@class='buttons']//button");
		Assert.assertEquals(getElementText(driver,"//h2[@class='product-title']//a"), "Apple MacBook Pro 13-inch");
		sleepInSecond(3);
	}
	@AfterClass()
	public void afterClass() {
		driver.quit();
	}
}
