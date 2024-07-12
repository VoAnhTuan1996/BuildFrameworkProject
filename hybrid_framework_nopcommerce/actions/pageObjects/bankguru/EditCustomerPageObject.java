package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.EditCustomerPageUI;

public class EditCustomerPageObject extends BaseActions{
	public WebDriver driver;

	public EditCustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterCustomerIDTxtbox(String customerID) {
		waitForElementVisible(driver,EditCustomerPageUI.CUSTOMER_ID_TXTBOX);
		sendKeyToElement(driver,EditCustomerPageUI.CUSTOMER_ID_TXTBOX,customerID);
		switchToNextField(driver);
	}

	public String getMessageErrorCustomerIDText() {
		waitForElementVisible(driver,EditCustomerPageUI.MESSAGE_ERROR_CUSID);
		return getElementText(driver,EditCustomerPageUI.MESSAGE_ERROR_CUSID);
	}

	public void clickToSubmitButton1() {
		waitForElementClickable(driver,EditCustomerPageUI.SUBMIT_BUTTON_1);
		clickToElement(driver,EditCustomerPageUI.SUBMIT_BUTTON_1);
	}
	
	public void clickToSubmitButton2() {
		waitForElementClickable(driver,EditCustomerPageUI.SUBMIT_BUTTON_2);
		clickToElement(driver,EditCustomerPageUI.SUBMIT_BUTTON_2);
	}
	
	public boolean isTitleEditCustomerDisplayed() {
		return isElementDisplayed(driver,EditCustomerPageUI.TITLE_EDIT_CUSTOMER);
	}

	public void editAddressArea(String address) {
		waitForElementVisible(driver,EditCustomerPageUI.ADDRESS_AREA);
		sendKeyToElement(driver,EditCustomerPageUI.ADDRESS_AREA,address);
		
	}

	public String getMessageErrorAddressAreaText() {
		return getElementText(driver,EditCustomerPageUI.MESSAGE_ERROR_ADDRESS);
	}

	public void editCityTxtbox(String city) {
		waitForElementVisible(driver,EditCustomerPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver,EditCustomerPageUI.CITY_TEXTBOX,city);
	}

	public String getMessageErrorCityTxtboxText() {
		return getElementText(driver,EditCustomerPageUI.MESSAGE_ERROR_CITY_FIELD);
	}

	public void editStateTxtbox(String state) {
		waitForElementVisible(driver,EditCustomerPageUI.STATE_TEXTBOX);
		sendKeyToElement(driver,EditCustomerPageUI.STATE_TEXTBOX,state);
	}

	public String getMessageErrorStateTxtboxText() {
		return getElementText(driver,EditCustomerPageUI.MESSAGE_ERROR_STATE_FIELD);
	}
	
	public void editPINTxtbox(String pin) {
		waitForElementVisible(driver,EditCustomerPageUI.PIN_TEXTBOX);
		sendKeyToElement(driver,EditCustomerPageUI.PIN_TEXTBOX,pin);
	}

	public String getMessageErrorPINTxtboxText() {
		return getElementText(driver,EditCustomerPageUI.MESSAGE_ERROR_PIN_FIELD);
	}
	
	public void editPhoneTxtbox(String phone) {
		waitForElementVisible(driver,EditCustomerPageUI.PHONE_TEXTBOX);
		sendKeyToElement(driver,EditCustomerPageUI.PHONE_TEXTBOX,phone);
	}

	public String getMessageErrorPhoneTxtboxText() {
		return getElementText(driver,EditCustomerPageUI.MESSAGE_ERROR_PHONE_FIELD);
	}
	
	
	public void editEmailTxtbox(String email) {
		waitForElementVisible(driver,EditCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver,EditCustomerPageUI.EMAIL_TEXTBOX,email);
	}

	public String getMessageErrorEmailTxtboxText() {
		return getElementText(driver,EditCustomerPageUI.MESSAGE_ERROR_EMAIL_FIELD);
	}
	
}
