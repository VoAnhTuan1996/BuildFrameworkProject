package pageUIs.orangehrm;

public class SalaryPageUI {
	public static final String SALARY_COMPONENTS_TXTBOX = "xpath=//label[text()='Salary Component']/parent::div/following-sibling::div/input";
	
	public static final String PAYGRADE_PARENT_DROPDOWN = "xpath=//label[text()='Pay Grade']/parent::div/following-sibling::div//i";
	public static final String PAYGRADE_CHILD_DROPDOWN = "xpath=//label[text()='Pay Grade']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
	public static final String PAYGRADE_SELECTED_TEXT_DROPDOWN = "xpath=//label[text()='Pay Grade']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	
	public static final String PAYFREQUENCY_PARENT_DROPDOWN = "xpath=//label[text()='Pay Frequency']/parent::div/following-sibling::div//i";
	public static final String PAYFREQUENCY_CHILD_DROPDOWN = "xpath=//label[text()='Pay Frequency']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
	public static final String PAYFREQUENCY_SELECTED_TEXT_DROPDOWN = "xpath=//label[text()='Pay Frequency']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	
	public static final String CURRENCY_PARENT_DROPDOWN = "xpath=//label[text()='Currency']/parent::div/following-sibling::div//i";
	public static final String CURRENCY_CHILD_DROPDOWN = "xpath=//label[text()='Currency']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
	public static final String CURRENCY_SELECTED_TEXT_DROPDOWN = "xpath=//label[text()='Currency']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	
	public static final String AMOUNT_TXTBOX = "xpath=//label[text()='Amount']/parent::div/following-sibling::div/input";
	public static final String MESSAGE_AMOUNT_ERROR = "xpath=//label[text()='Amount']/parent::div/following-sibling::span";
}
