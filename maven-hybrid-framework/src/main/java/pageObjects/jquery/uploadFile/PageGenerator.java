package pageObjects.jquery.uploadFile;

import org.openqa.selenium.WebDriver;

import pageObjects.jquery.uploadFile.HomePageObject;

public class PageGenerator {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
}
