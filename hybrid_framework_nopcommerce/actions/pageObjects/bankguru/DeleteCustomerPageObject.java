package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import pageUIs.bankguru.DeleteCustomerPageUI;

public class DeleteCustomerPageObject extends BaseActions{
	public WebDriver driver;

	public DeleteCustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterCustomerIDTxtbox(String customerID) {
		waitForElementVisible(driver,DeleteCustomerPageUI.CUSTOMER_ID_TXTBOX);
		sendKeyToElement(driver,DeleteCustomerPageUI.CUSTOMER_ID_TXTBOX,customerID);
		switchToNextField(driver);
	}

	public String getMessageErrorCustomerIDText() {
		return getElementText(driver,DeleteCustomerPageUI.MESSAGE_ERROR_CUSTOMER_ID);
	}
	
	
	
}
