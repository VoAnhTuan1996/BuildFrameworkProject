package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import pageUIs.bankguru.EditAccountPageUI;

public class EditAccountPageObject extends BaseActions {
	public WebDriver driver;

	public EditAccountPageObject(WebDriver driver){
		super(driver);
		this.driver = driver;
	}

	public void enterAccountNo(String accountNo) {
		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_NO_TXTBOX);
		sendKeyToElement(driver, EditAccountPageUI.ACCOUNT_NO_TXTBOX, accountNo);
	}

	public void clickSubmitButton() {
		waitForElementClickable(driver, EditAccountPageUI.SUBMIT_BUTTON);
		clickToElement(driver, EditAccountPageUI.SUBMIT_BUTTON);
	}
}
