package com.nopcommerce.user;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Register {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}
	
	//@Test
	public void TC01() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(), "Last name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "Password is required.");
	}
	
	//@Test
	public void TC02() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Automation");
		driver.findElement(By.id("LastName")).sendKeys("FC");
		driver.findElement(By.id("Email")).sendKeys("1234@456$$");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");
	}
	@Test
	public void TC03() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Automation");
		driver.findElement(By.id("LastName")).sendKeys("FC");
		driver.findElement(By.id("Email")).sendKeys(generateEmail());
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".result")).getText(), "Your registration completed");
		driver.findElement(By.cssSelector("a.ico-register")).click();
	}
	//@Test
	public void TC04() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Automation");
		driver.findElement(By.id("LastName")).sendKeys("FC");
		driver.findElement(By.id("Email")).sendKeys("anhtuan123@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error li")).getText(),"The specified email already exists");
	}
	//@Test
	public void TC05() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Automation");
		driver.findElement(By.id("LastName")).sendKeys("FC");
		driver.findElement(By.id("Email")).sendKeys(generateEmail());
		driver.findElement(By.id("Password")).sendKeys("123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("span[id='Password-error'] p")).isDisplayed()&&driver.findElement(By.cssSelector("span[id='Password-error'] ul li")).isDisplayed(), "true");
	}
	//@Test
	public void TC06() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Automation");
		driver.findElement(By.id("LastName")).sendKeys("FC");
		driver.findElement(By.id("Email")).sendKeys(generateEmail());
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("#ConfirmPassword-error")).getText(),"The password and confirmation password do not match.");
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
