package pageUIs.orangehrm;

public class ContactDetailPageUI {
	public static final String STREET1_TXTBOX = "xpath=//label[text()='Street 1']/parent::div/following-sibling::div/input";
	public static final String STREET2_TXTBOX = "xpath=//label[text()='Street 2']/parent::div/following-sibling::div/input";
	public static final String CITY_TXTBOX = "xpath=//label[text()='City']/parent::div/following-sibling::div/input";
	public static final String STATE_TXTBOX = "xpath=//label[text()='State/Province']/parent::div/following-sibling::div/input";
	public static final String ZIPCODE_TXTBOX = "xpath=//label[text()='Zip/Postal Code']/parent::div/following-sibling::div/input";
	public static final String COUNTRY_DROPDOWN_PARENT = "xpath=//label[text()='Country']/parent::div/following-sibling::div//i";
	public static final String COUNTRY_DROPDOWN_CHILD = "xpath=//label[text()='Country']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
	public static final String COUNTRY_DROPDOWN_SELECTED_TEXT = "xpath=//label[text()='Country']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	public static final String MOBILE_PHONE_TEXTBOX = "xpath=//label[text()='Mobile']/parent::div/following-sibling::div/input";
	public static final String WORK_EMAIL_TEXTBOX = "xpath=//label[text()='Work Email']/parent::div/following-sibling::div/input";
	public static final String SAVE_BUTTON_AT_CONTACT_DETAILS = "xpath=//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button";
	
	public static final String EMERGENCY_CONTACTS_BUTTON = "xpath=//a[contains(text(),'Emergency Contacts')]";
}
