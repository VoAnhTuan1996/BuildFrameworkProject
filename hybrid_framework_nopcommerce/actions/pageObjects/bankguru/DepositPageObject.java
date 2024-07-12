package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import pageUIs.bankguru.DepositPageUI;

public class DepositPageObject extends BaseActions{
	public WebDriver driver;

	public DepositPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void enterAccountNo(String accountNo) {
		waitForElementVisible(driver, DepositPageUI.ACCOUNT_NO_TXTBOX);
		sendKeyToElement(driver, DepositPageUI.ACCOUNT_NO_TXTBOX,accountNo);
	}

	public void enterAmount(String amount) {
		waitForElementVisible(driver, DepositPageUI.AMOUNT_TXTBOX);
		sendKeyToElement(driver, DepositPageUI.AMOUNT_TXTBOX,amount);
	}

	public void enterDescription(String description) {
		waitForElementVisible(driver, DepositPageUI.DESCRIPTION_TXTBOX);
		sendKeyToElement(driver, DepositPageUI.DESCRIPTION_TXTBOX,description);
		
	}

	public void clickSubmitButton() {
		waitForElementClickable(driver, DepositPageUI.SUBMIT_BUTTON);
		clickToElement(driver, DepositPageUI.SUBMIT_BUTTON);
	}
	
	
}
