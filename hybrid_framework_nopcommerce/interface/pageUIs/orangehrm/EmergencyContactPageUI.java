package pageUIs.orangehrm;

public class EmergencyContactPageUI {
	public static final String BUTTON_ADD_AT_ASSIGNED = "xpath=//h6[text()='Assigned Emergency Contacts']/following-sibling::button";
	public static final String NAME_TXTBOX = "xpath=//label[text()='Name']/parent::div/following-sibling::div/input";
	public static final String RELATIONSHIP_TEXTBOX = "xpath=//label[text()='Relationship']/parent::div/following-sibling::div/input";
	public static final String MOBILE_TXTBOX = "xpath=//label[text()='Mobile']/parent::div/following-sibling::div/input";
	public static final String SAVE_BUTTON_AT_SAVE_EMERGENCY = "xpath=//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit']";
	public static final String DEPENDENTS_BUTTON = "xpath=//a[contains(text(),'Dependents')]";
}
