package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class ImigrationPageObject extends BaseActions{
	private WebDriver driver;

	public ImigrationPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
