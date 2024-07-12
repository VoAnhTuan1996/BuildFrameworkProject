package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import pageUIs.bankguru.NewAccountPageUI;

public class NewAccountPageObject extends BaseActions{
	public WebDriver driver;

	public NewAccountPageObject(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	public void enterCustomerID(String cusID) {
		waitForElementVisible(driver,NewAccountPageUI.CUSTOMER_ID_TXTBOX);
		sendKeyToElement(driver,NewAccountPageUI.CUSTOMER_ID_TXTBOX,cusID);
	}
	
	public void selectAccountTypeDropdown(String itemName) {
		waitForElementClickable(driver,NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN_PARENT,itemName);
		selectItemInDefaultDropdown(driver,NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN_PARENT,itemName);
	}
	
	public void enterInitialDeposit(String amount) {
		waitForElementVisible(driver,NewAccountPageUI.INITIAL_DEPOSIT_TXTBOX);
		sendKeyToElement(driver,NewAccountPageUI.INITIAL_DEPOSIT_TXTBOX,amount);
	}
	
	public void clickSubmitButton() {
		waitForElementClickable(driver, NewAccountPageUI.SUBMIT_BUTTON);
		clickToElement(driver, NewAccountPageUI.SUBMIT_BUTTON);
	}

	public String getAccountIDText() {
		return getElementText(driver, NewAccountPageUI.ACCOUNT_ID_TEXT);
	}
}
