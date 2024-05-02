package TestNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserHomePageObject;


public class ParallelClass_01 extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	}
	
	@Test
	public void TC_01_New_Account() {
		
	}
	
	@Test
	public void TC_02_Edit_Account() {
		
	}
	
	@Test
	public void TC_03_View_Account() {
		
	}
	
	@Test
	public void TC_04_Search_Account() {
		
	}
	
	@Test
	public void TC_05_Delete_Account() {
		
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
