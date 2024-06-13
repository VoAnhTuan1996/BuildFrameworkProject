package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.PersonalDetailPageUI;

public class PersonalDetailPageObject extends BaseActions{
	private WebDriver driver;

	public PersonalDetailPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getFirstNameValue() {
		waitForElementVisible(driver, PersonalDetailPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, PersonalDetailPageUI.FIRST_NAME_TEXTBOX,"value");
	}

	public String getLastNameValue() {
		waitForElementVisible(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX,"value");
	}

	public String getEmployeeIDValue() {
		waitForElementVisible(driver, PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX);
		return getElementAttribute(driver, PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX,"value");
	}

	public EmployeeListPageObject clickToEmployeeListButton() {
		waitForElementClickable(driver, PersonalDetailPageUI.EMPLOYEE_LIST_BUTTON);
		clickToElement(driver, PersonalDetailPageUI.EMPLOYEE_LIST_BUTTON);
		return PageGeneratorManager.getEmployeeListPage(driver);
	}
	
	public boolean isPersonalDetailsHeaderDisplayed() {
		waitForElementVisible(driver, PersonalDetailPageUI.PERSONAL_DETAILS_PAGE_HEADER);
		return isElementDisplayed(driver, PersonalDetailPageUI.PERSONAL_DETAILS_PAGE_HEADER);
	}

	public void enterToNicknameTextbox(String nickName) {
		waitForElementVisible(driver, PersonalDetailPageUI.NICKNAME_TEXTBOX);
		sendKeyToElement(driver, PersonalDetailPageUI.NICKNAME_TEXTBOX,nickName);
	}

	public void enterToDriverLicenseNumberTextbox(String driverLicense) {
		waitForElementVisible(driver, PersonalDetailPageUI.DRIVER_LICENSE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, PersonalDetailPageUI.DRIVER_LICENSE_NUMBER_TEXTBOX, driverLicense);
	}

	public void enterToLicenseExpiryDatePicker(String driverLicenseExpiry) {
		waitForElementVisible(driver, PersonalDetailPageUI.DRIVER_EXPIRY_DATE_PICKER);
		sendKeyToElement(driver, PersonalDetailPageUI.DRIVER_EXPIRY_DATE_PICKER, driverLicenseExpiry);
	}

	public void enterToSocialSecurityNumberTextbox(String ssn) {
		waitForElementVisible(driver, PersonalDetailPageUI.SOCIAL_SECURITY_NUMBER_TEXTBOX);
		sendKeyToElement(driver, PersonalDetailPageUI.SOCIAL_SECURITY_NUMBER_TEXTBOX,ssn);
	}

	public void enterToSocialInsuranceNumberTextbox(String sin) {
		waitForElementVisible(driver, PersonalDetailPageUI.SOCIAL_INSURANCE_NUMVER_TEXTBOX);
		sendKeyToElement(driver, PersonalDetailPageUI.SOCIAL_INSURANCE_NUMVER_TEXTBOX,sin);
	}

	public void selectToNationalityDropdown(String nationalityName) {
		waitForElementClickable(driver, PersonalDetailPageUI.NATIONALITY_DROPDOWN_PARENT);
		selectItemInDropdown(driver, PersonalDetailPageUI.NATIONALITY_DROPDOWN_PARENT, PersonalDetailPageUI.NATIONALITY_DROPDOWN_CHILD, nationalityName);
	}

	public void selectToMaritalStatusDropdown(String maritalStatus) {
		waitForElementClickable(driver, PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_PARENT);
		selectItemInDropdown(driver, PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_CHILD, maritalStatus);
	}

	public void enterToDateOfBirthDatePicker(String dateOfBirth) {
		waitForElementVisible(driver, PersonalDetailPageUI.DATE_OF_BIRTH_PICKER);
		sendKeyToElement(driver, PersonalDetailPageUI.DATE_OF_BIRTH_PICKER,dateOfBirth);
	}

	public void clickToSaveButtonAtPersonalDetailPart() {
		waitForElementClickable(driver, PersonalDetailPageUI.SAVE_BUTTON_AT_PERSONAL_DETAIL);
		clickToElement(driver, PersonalDetailPageUI.SAVE_BUTTON_AT_PERSONAL_DETAIL);
	}
	
	public void selectToBloodTypeDropdown(String bloodType) {
		waitForElementClickable(driver, PersonalDetailPageUI.BLOOD_TYPE_DROPDOWN_PARENT);
		selectItemInDropdown(driver, PersonalDetailPageUI.BLOOD_TYPE_DROPDOWN_PARENT, PersonalDetailPageUI.BLOOD_TYPE_DROPDOWN_CHILD,bloodType);
	}
	
	public void enterTestField(String test) {
		waitForElementVisible(driver, PersonalDetailPageUI.TEXT_FIELD);
		sendKeyToElement(driver, PersonalDetailPageUI.TEXT_FIELD, test);
	}
	
	public void clickToSaveButtonAtCustomField() {
		waitForElementClickable(driver, PersonalDetailPageUI.SAVE_BUTTON_AT_CUSTOM_FIELDS);
		clickToElement(driver, PersonalDetailPageUI.SAVE_BUTTON_AT_CUSTOM_FIELDS);
	}
	
	public String getNationalityDropdownSelectedText() {
		return getElementText(driver, PersonalDetailPageUI.NATIONALITY_DROPDOWN_SELECTED_TEXT);
	}

	public String getMaritalStatusDropdownSelectedText() {
		return getElementText(driver, PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_SELECTED_TEXT);
	}
	
	public String getBloodTypeDropdownSelectedText() {
		return getElementText(driver, PersonalDetailPageUI.BLOOD_TYPE_DROPDOWN_SELECTED_TEXT);
	}

	public ContactDetailPageObject clickToContactDetailsButton() {
		waitForElementClickable(driver, PersonalDetailPageUI.CONTACT_DETAILS_BUTTON);
		clickToElement(driver, PersonalDetailPageUI.CONTACT_DETAILS_BUTTON);
		waitForSpinnerIconInvisible();
		return PageGeneratorManager.getContactDetailsPage(driver);
	}

}
