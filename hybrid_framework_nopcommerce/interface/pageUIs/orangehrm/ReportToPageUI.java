package pageUIs.orangehrm;

public class ReportToPageUI {
	public static final String NAME_SUPERVISOR_INPUT = "xpath=//label[text()='Name']/parent::div/following-sibling::div//input";
	public static final String NAME_SUPERVISOR_ITEM_1 = "xpath=//label[text()='Name']/parent::div/following-sibling::div//span[contains(text(),'Ranga')]";
	public static final String NAME_SUPERVISOR_ITEM_2 = "xpath=//label[text()='Name']/parent::div/following-sibling::div//span[contains(text(),'James')]";
	
	public static final String REPORTING_METHOD_PARENT_DROPDOWN = "xpath=//label[text()='Reporting Method']/parent::div/following-sibling::div//i";
	public static final String REPORTING_METHOD_CHILD_DROPDOWN = "xpath=//label[text()='Reporting Method']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
	public static final String REPORTING_METHOD_SELECTED_TEXT_DROPDOWN = "xpath=//label[text()='Reporting Method']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	
	public static final String SAVE_BUTTON_AT_REPORT_TO_PAGE = "xpath=//div[@class='oxd-form-actions']//button[@type='submit']";
}
