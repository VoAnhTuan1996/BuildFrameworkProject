package pageUIs.orangehrm;

public class JobPageUI {
	public static final String JOB_DATE_DATETIME_PICKERS = "xpath=//label[text()='Joined Date']/parent::div/following-sibling::div//input";
	
	public static final String JOB_TITLE_PARENT_DROPDOWN = "xpath=//label[text()='Job Title']/parent::div/following-sibling::div//i";
	public static final String JOB_TITLE_CHILD_DROPDOWN = "xpath=//label[text()='Job Title']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
	public static final String JOB_TITLE_SELECTED_TEXT_DROPDOWN = "xpath=//label[text()='Job Title']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	
	public static final String JOB_SPECIFICATION_TXTBOX = "xpath=//label[text()='Job Specification']/parent::div/following-sibling::div//p";
	
	public static final String JOB_CATEGORY_PARENT_DROPDOWN = "xpath=//label[text()='Job Category']/parent::div/following-sibling::div//i";
	public static final String JOB_CATEGORY_CHILD_DROPDOWN = "xpath=//label[text()='Job Category']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
	public static final String JOB_CATEGORY_SELECTED_TEXT_DROPDOWN = "xpath=//label[text()='Job Category']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	
	public static final String SUB_UNIT_PARENT_DROPDOWN = "xpath=//label[text()='Sub Unit']/parent::div/following-sibling::div//i";
	public static final String SUB_UNIT_CHILD_DROPDOWN = "xpath=//label[text()='Sub Unit']/parent::div/following-sibling::div//div[@role='listbox']//div[contains(@class,'oxd-select-option')]/span";
	public static final String SUB_UNIT_SELECTED_TEXT_DROPDOWN = "xpath=//label[text()='Sub Unit']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	
	public static final String LOCATION_PARENT_DROPDOWN = "xpath=//label[text()='Location']/parent::div/following-sibling::div//i";
	public static final String LOCATION_CHILD_DROPDOWN = "xpath=//label[text()='Location']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
	public static final String LOCATION_SELECTED_TEXT_DROPDOWN = "xpath=//label[text()='Location']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	
	public static final String EMPLOYEMENT_STATUS_PARENT_DROPDOWN = "xpath=//label[text()='Employment Status']/parent::div/following-sibling::div//i";
	public static final String EMPLOYEMENT_STATUS_CHILD_DROPDOWN = "xpath=//label[text()='Employment Status']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
	public static final String EMPLOYEMENT_STATUS_SELECTED_TEXT_DROPDOWN = "xpath=//label[text()='Employment Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	
	public static final String IECD_CHECKBOX_BUTTON = "xpath=//div[@class='oxd-switch-wrapper']//span";
	public static final String CONTRACT_START_DATE = "xpath=//label[text()='Contract Start Date']/parent::div/following-sibling::div//input";
	public static final String CONTRACT_END_DATE = "xpath=//label[text()='Contract End Date']/parent::div/following-sibling::div//input";
	public static final String UPLOAD_FILE_BUTTON = "xpath=//div[contains(text(),'Browse')]";
}
