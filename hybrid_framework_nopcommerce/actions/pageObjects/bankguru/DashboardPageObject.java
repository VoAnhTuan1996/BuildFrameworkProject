package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.DashboardPageUI;

public class DashboardPageObject extends BasePage{
	
	private WebDriver driver;
	
	public DashboardPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public NewCustomerPageObject openNewCustomerPage() {
		waitForElementClickable(driver, DashboardPageUI.NEW_CUSTOMER_MODULE);
		clickToElement(driver, DashboardPageUI.NEW_CUSTOMER_MODULE);
		return PageGeneratorManager.getNewCustomerPage(driver);
	}
	
	public EditCustomerPageObject openEditCustomerPage() {
		waitForElementClickable(driver, DashboardPageUI.EDIT_CUSTOMER_MODULE);
		clickToElement(driver, DashboardPageUI.EDIT_CUSTOMER_MODULE);
		return PageGeneratorManager.getEditCustomerPage(driver);
	}
	
	public DeleteCustomerPageObject openDeleteCustomerPage() {
		waitForElementClickable(driver, DashboardPageUI.DELETE_CUSTOMER_MODULE);
		clickToElement(driver, DashboardPageUI.DELETE_CUSTOMER_MODULE);
		return PageGeneratorManager.getDeleteCustomerPage(driver);
	}

}
