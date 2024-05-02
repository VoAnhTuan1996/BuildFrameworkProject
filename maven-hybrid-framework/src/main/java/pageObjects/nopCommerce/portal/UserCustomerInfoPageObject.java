package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopEcommerce.user.CustomerPageUI;

public class UserCustomerInfoPageObject extends BasePage{
	WebDriver driver;
	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isCustomerInfoDisplayed() {
		waitForElementVisible(driver, CustomerPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver, CustomerPageUI.CUSTOMER_INFO_HEADER);
	}
	

}
