package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.ImigrationPageUI;

public class ImigrationPageObject extends BaseActions{
	private WebDriver driver;

	public ImigrationPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterNumberTextbox(String number) {
		waitForElementVisible(driver, ImigrationPageUI.NUMBER_TEXTBOX);
		sendKeyToElement(driver, ImigrationPageUI.NUMBER_TEXTBOX,number);
	}
	
	public void enterToIssuedDate_DP(String issuedDate) {
		waitForElementVisible(driver, ImigrationPageUI.ISSUED_DATE_DATETIME_PICKER);
		sendKeyToElement(driver, ImigrationPageUI.ISSUED_DATE_DATETIME_PICKER,issuedDate);
	}

	public void enterToExpiryDate_DP(String expiryDate) {
		waitForElementVisible(driver, ImigrationPageUI.EXPIRY_DATE_DATETIME_PICKER);
		sendKeyToElement(driver, ImigrationPageUI.EXPIRY_DATE_DATETIME_PICKER, expiryDate);
	}

	public void enterEligibleStatusTxtbox(String eligibleStatus) {
		waitForElementVisible(driver, ImigrationPageUI.ELIGIBLE_STATUS_TXTBOX);
		sendKeyToElement(driver, ImigrationPageUI.ELIGIBLE_STATUS_TXTBOX, eligibleStatus);
	}
	
	public void clickItemIssuedByDropdown(String issuedBy) {
		waitForElementClickable(driver, ImigrationPageUI.ISSUED_BY_DROPDOWN_PARENT);
		selectItemInDropdown(driver, ImigrationPageUI.ISSUED_BY_DROPDOWN_PARENT, ImigrationPageUI.ISSUED_BY_DROPDOWN_CHILD, issuedBy);
	}

	public void enterEligibleReviewDate_DP(String eligibleReviewDate) {
		waitForElementVisible(driver, ImigrationPageUI.ELIGIBLE_REVIEW_DATE_DATETIME_PICKER);
		sendKeyToElement(driver, ImigrationPageUI.ELIGIBLE_REVIEW_DATE_DATETIME_PICKER, eligibleReviewDate);
	}
	
	public String getIssuedByDropdownSelectedText() {
		return getElementText(driver, ImigrationPageUI.ISSUED_BY_DROPDOWN_SELECTED_TEXT);
	}
}
