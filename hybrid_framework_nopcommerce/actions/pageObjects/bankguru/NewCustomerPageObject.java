package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.NewCustomerPageUI;

public class NewCustomerPageObject extends BaseActions{
	public WebDriver driver;

	public NewCustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void enterCustomerNameTxtbox(String customerName) {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TXTBOX,customerName);
		switchToNextField(driver);
	}
	
	
	public void clickMaleGenderRadioButtonByLabel(String gender) {
		waitForElementClickable(driver, NewCustomerPageUI.MALE_RADIO_BUTTON);
		clickToElement(driver, NewCustomerPageUI.MALE_RADIO_BUTTON);
	}
	
	public void clickFemaleGenderRadioButtonByLabel(String gender) {
		waitForElementClickable(driver, NewCustomerPageUI.FEMALE_RADIO_BUTTON);
		clickToElement(driver, NewCustomerPageUI.FEMALE_RADIO_BUTTON);
	}
	
	public void enterDOBDateTimePicker(String doB) {
		waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_DATETIME_PICKER);
		sendKeyToElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_DATETIME_PICKER,doB);
	}
	
	public void enterAddressTxtArea(String address) {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA,address);
		switchToNextField(driver);
	}
	
	public void enterCityTxtbox(String cityName) {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CITY_TEXTBOX,cityName);
		switchToNextField(driver);
	}
	
	public void enterStateTxtbox(String state) {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.STATE_TEXTBOX,state);
		switchToNextField(driver);
	}
	
	public void enterPINTxtbox(String pin) {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.PIN_TEXTBOX,pin);
		switchToNextField(driver);
	}
	
	public void enterPhoneTxtbox(String phone) {
		waitForElementVisible(driver, NewCustomerPageUI.PHONE_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.PHONE_TEXTBOX,phone);
		switchToNextField(driver);
	}
	
	public void enterEmailTxtbox(String email) {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX,email);
		switchToNextField(driver);
	}
	
	public void enterPasswordTxtbox(String password) {
		waitForElementVisible(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.PASSWORD_TEXTBOX,password);
	}
	
	public void clickSubmitButton() {
		waitForElementClickable(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, NewCustomerPageUI.SUBMIT_BUTTON);
	}
	
	public void clickResetButton() {
		waitForElementClickable(driver, NewCustomerPageUI.RESET_BUTTON);
		clickToElement(driver, NewCustomerPageUI.RESET_BUTTON);
	}
	
	public String getMessageErrorCustomerNameText() {
		waitForElementClickable(driver, NewCustomerPageUI.MESSAGE_ERROR_CUSTOMER_NAME);
		return getElementText(driver, NewCustomerPageUI.MESSAGE_ERROR_CUSTOMER_NAME);
	}
	
	public String getMessageErrorAddressText() {
		waitForElementClickable(driver, NewCustomerPageUI.MESSAGE_ERROR_ADDRESS_FIELD);
		return getElementText(driver, NewCustomerPageUI.MESSAGE_ERROR_ADDRESS_FIELD);
	}
	
	public String getMessageErrorCityText() {
		waitForElementClickable(driver, NewCustomerPageUI.MESSAGE_ERROR_CITY_FIELD);
		return getElementText(driver, NewCustomerPageUI.MESSAGE_ERROR_CITY_FIELD);
	}
	
	public String getMessageErrorStateText() {
		waitForElementClickable(driver, NewCustomerPageUI.MESSAGE_ERROR_STATE_FIELD);
		return getElementText(driver, NewCustomerPageUI.MESSAGE_ERROR_STATE_FIELD);
	}

	public String getMessageErrorPinText() {
		waitForElementClickable(driver, NewCustomerPageUI.MESSAGE_ERROR_PIN_FIELD);
		return getElementText(driver, NewCustomerPageUI.MESSAGE_ERROR_PIN_FIELD);
	}
	
	public String getMessageErrorPhoneText() {
		waitForElementClickable(driver, NewCustomerPageUI.MESSAGE_ERROR_PHONE_FIELD);
		return getElementText(driver, NewCustomerPageUI.MESSAGE_ERROR_PHONE_FIELD);
	}

	public String getMessageErrorEmailText() {
		waitForElementVisible(driver, NewCustomerPageUI.MESSAGE_ERROR_EMAIL_FIELD);
		return getElementText(driver, NewCustomerPageUI.MESSAGE_ERROR_EMAIL_FIELD);
	}

	public String getMessageSuccessfulText() {
		waitForElementVisible(driver, NewCustomerPageUI.MESSAGE_REGISTERED_SUCCESSFULLY);
		return getElementText(driver, NewCustomerPageUI.MESSAGE_REGISTERED_SUCCESSFULLY);
	}
	
	public String getCustomerIDText() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_ID_TEXT);
		return getElementText(driver, NewCustomerPageUI.CUSTOMER_ID_TEXT);
	}
	
	public String getCustomerNameText() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXT);
		return getElementText(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXT);
	}
	
	public String getAddressText() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXT);
		return getElementText(driver, NewCustomerPageUI.ADDRESS_TEXT);
	}
	
	public String getBirthDateText() {
		waitForElementVisible(driver, NewCustomerPageUI.BIRTH_DATE_TEXT);
		return getElementText(driver, NewCustomerPageUI.BIRTH_DATE_TEXT);
	}
	
	public String getCityText() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXT);
		return getElementText(driver, NewCustomerPageUI.CITY_TEXT);
	}
	
	public String getStateText() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXT);
		return getElementText(driver, NewCustomerPageUI.STATE_TEXT);
	}
	
	public String getPinText() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXT);
		return getElementText(driver, NewCustomerPageUI.PIN_TEXT);
	}
	
	public String getPhoneText() {
		waitForElementVisible(driver, NewCustomerPageUI.PHONE_TEXT);
		return getElementText(driver, NewCustomerPageUI.PHONE_TEXT);
	}
	
	public String getEmailText() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXT);
		return getElementText(driver, NewCustomerPageUI.EMAIL_TEXT);
	}
	
}
