package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;
import pageUIs.nopEcommerce.admin.DashboardPageUI;

public class DashboardObject extends BasePage{
	WebDriver driver;

	public DashboardObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isDashboardHeaderIsDisplayed() {
		waitForElementVisible(driver,DashboardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver,DashboardPageUI.DASHBOARD_HEADER);
	}
	
}
