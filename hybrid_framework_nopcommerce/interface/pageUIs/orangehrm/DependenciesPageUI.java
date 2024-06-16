package pageUIs.orangehrm;

public class DependenciesPageUI {
	public static final String BUTTON_ADD_AT_ASSIGNED_DEPENDANTS = "xpath=//h6[text()='Assigned Dependents']/following-sibling::button";
	public static final String NAME_TXTBOX = "xpath=//label[text()='Name']/parent::div/following-sibling::div/input";
	public static final String RELATIONSHIP_DROPDOWN_PARENT = "xpath=//label[text()='Relationship']/parent::div/following-sibling::div//i";
	public static final String RELATIONSHIP_DROPDOWN_CHILD = "xpath=//label[text()='Relationship']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
	public static final String RELATIONSHIP_DROPDOWN_SELECTED = "xpath=//label[text()='Relationship']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	public static final String PLEASE_SPECTIFY_TXTBOX = "xpath=//label[text()='Please Specify']/parent::div/following-sibling::div/input";
	public static final String DATE_OF_BIRTH_DATETIME_PICKERS = "xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
	public static final String SAVE_BUTTON_AT_DEPENDANT = "xpath=//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit']";
	public static final String CHECKBOX_DELETE_DEPENDANT = "xpath=//div[@class='oxd-table-card']//label/input/following-sibling::span/i";
	public static final String DELETE_BUTTON = "xpath=//i[@class='oxd-icon bi-trash']/parent::button";
	public static final String CONFIRM_BUTTON = "xpath=//div[@class='orangehrm-modal-footer']//i/parent::button";
	
	public static final String IMMIGRATION_LINK_BUTTON = "xpath=//a[contains(text(),'Immigration')]";
}
