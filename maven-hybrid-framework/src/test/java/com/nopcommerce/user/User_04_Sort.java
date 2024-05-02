package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class User_04_Sort extends BasePage{
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
		waitForElementClickable(driver,"//ul[contains(@class,'notmobile')]//a[@href='/computers']");
		clickToElement(driver,"//ul[contains(@class,'notmobile')]//a[@href='/computers']");
		waitForElementClickable(driver,"//div[@class='picture']//a[@href='/notebooks']");
		clickToElement(driver,"//div[@class='picture']//a[@href='/notebooks']");
		waitForElementClickable(driver,"//select[@id='products-orderby']");
		selectItemInDefaultDropdown(driver,"//select[@id='products-orderby']","5");
		sleepInSecond(2);
	}
	//@Test
	public void TC02() {
		selectItemInDefaultDropdown(driver,"//select[@id='products-orderby']","6");
		sleepInSecond(2);
	}
	//@Test
	public void TC03() {
		selectItemInDefaultDropdown(driver,"//select[@id='products-orderby']","10");
		sleepInSecond(2);
	}
	//@Test
	public void TC04() {
		selectItemInDefaultDropdown(driver,"//select[@id='products-orderby']","11");
		sleepInSecond(2);
	}
	@Test
	public void TC05() {
		selectItemInDefaultDropdown(driver,"//select[@id='products-pagesize']","3");
		sleepInSecond(1);
		int productCount = getListWebElement(driver,"//div[@class='item-box']").size();
		System.out.println(productCount);
		Assert.assertTrue(productCount<=3,"true");
		Assert.assertTrue(getWebElement(driver,"//a[contains(text(),'Next')]").isDisplayed(),"true");
		clickToElement(driver,"//a[contains(text(),'Next')]");
		Assert.assertTrue(getWebElement(driver,"//a[contains(text(),'Previous')]").isDisplayed(),"true");
		sleepInSecond(3);		
	}
	@Test
	public void TC06() {
		selectItemInDefaultDropdown(driver,"//select[@id='products-pagesize']","6");
		sleepInSecond(1);
		int productCount = getListWebElement(driver,"//div[@class='item-box']").size();
		System.out.println(productCount);
		Assert.assertTrue(productCount<=6,"true");
		//Assert.assertTrue(getWebElement(driver,"//div[@class='pager']//ul").isDisplayed(),"false");
	}
	@Test
	public void TC07() {
		selectItemInDefaultDropdown(driver,"//select[@id='products-pagesize']","9");
		sleepInSecond(1);
		int productCount = getListWebElement(driver,"//div[@class='item-box']").size();
		System.out.println(productCount);
		Assert.assertTrue(productCount<=9,"true");
		//Assert.assertTrue(getWebElement(driver,"//div[@class='pager']//ul").isDisplayed(),"false");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
