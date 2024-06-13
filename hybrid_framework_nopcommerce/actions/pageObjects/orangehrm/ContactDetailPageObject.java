package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.ContactDetailPageUI;

public class ContactDetailPageObject extends BaseActions{
	private WebDriver driver;

	public ContactDetailPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterStreet1Textbox(String street1) {
		waitForElementVisible(driver, ContactDetailPageUI.STREET1_TXTBOX);
		sendKeyToElement(driver, ContactDetailPageUI.STREET1_TXTBOX, street1);		
	}

	public void enterStreet2Textbox(String street2) {
		waitForElementVisible(driver, ContactDetailPageUI.STREET2_TXTBOX);
		sendKeyToElement(driver, ContactDetailPageUI.STREET2_TXTBOX, street2);
	}

	public void enterCityTextbox(String city) {
		waitForElementVisible(driver, ContactDetailPageUI.CITY_TXTBOX);
		sendKeyToElement(driver, ContactDetailPageUI.CITY_TXTBOX, city);
	}

	public void enterStateTextbox(String state) {
		waitForElementVisible(driver, ContactDetailPageUI.STATE_TXTBOX);
		sendKeyToElement(driver, ContactDetailPageUI.STATE_TXTBOX, state);
	}

	public void enterZipCodeTextbox(String zipCode) {
		waitForElementVisible(driver, ContactDetailPageUI.ZIPCODE_TXTBOX);
		sendKeyToElement(driver, ContactDetailPageUI.ZIPCODE_TXTBOX, zipCode);
	}

	public void selectCountryDropdown(String country) {
		waitForElementVisible(driver, ContactDetailPageUI.COUNTRY_DROPDOWN_PARENT);
		selectItemInDropdown(driver, ContactDetailPageUI.COUNTRY_DROPDOWN_PARENT, ContactDetailPageUI.COUNTRY_DROPDOWN_CHILD,country);
	}
	
	public String getCountryDropdownSelectText() {
		return getElementText(driver, ContactDetailPageUI.COUNTRY_DROPDOWN_SELECTED_TEXT);
	}

	public void enterMobilePhoneTextbox(String mobilePhone) {
		waitForElementVisible(driver, ContactDetailPageUI.MOBILE_PHONE_TEXTBOX);
		sendKeyToElement(driver, ContactDetailPageUI.MOBILE_PHONE_TEXTBOX, mobilePhone);
	}

	public void enterWorkEmailTextbox(String workEmail) {
		waitForElementVisible(driver, ContactDetailPageUI.WORK_EMAIL_TEXTBOX);
		sendKeyToElement(driver, ContactDetailPageUI.WORK_EMAIL_TEXTBOX, workEmail);		
	}
	
	public void clickSaveButtonAtContactDetails() {
		waitForElementClickable(driver, ContactDetailPageUI.SAVE_BUTTON_AT_CONTACT_DETAILS);
		clickToElement(driver, ContactDetailPageUI.SAVE_BUTTON_AT_CONTACT_DETAILS);
	}

	public EmergencyContactPageObject clickToEmergencyContactsButton() {
		waitForElementClickable(driver, ContactDetailPageUI.EMERGENCY_CONTACTS_BUTTON);
		clickToElement(driver, ContactDetailPageUI.EMERGENCY_CONTACTS_BUTTON);
		waitForSpinnerIconInvisible();
		return PageGeneratorManager.getEmergencyContactPage(driver);
	}
}
