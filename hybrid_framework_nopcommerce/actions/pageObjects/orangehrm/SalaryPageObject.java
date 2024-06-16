package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.SalaryPageUI;

public class SalaryPageObject extends BaseActions{
	private WebDriver driver;

	public SalaryPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterSalaryComponentsTextbox(String salaryComponents) {
		waitForElementVisible(driver, SalaryPageUI.SALARY_COMPONENTS_TXTBOX);
		sendKeyToElement(driver, SalaryPageUI.SALARY_COMPONENTS_TXTBOX, salaryComponents);
	}

	public void selectPayGradeDropdown(String payGrade) {
		waitForElementClickable(driver, SalaryPageUI.PAYGRADE_PARENT_DROPDOWN);
		selectItemInDropdown(driver, SalaryPageUI.PAYGRADE_PARENT_DROPDOWN, SalaryPageUI.PAYGRADE_CHILD_DROPDOWN, payGrade);
	}

	public void selectPayFrequencyDropdown(String payFrequency) {
		waitForElementClickable(driver, SalaryPageUI.PAYFREQUENCY_PARENT_DROPDOWN);
		selectItemInDropdown(driver, SalaryPageUI.PAYFREQUENCY_PARENT_DROPDOWN, SalaryPageUI.PAYFREQUENCY_CHILD_DROPDOWN, payFrequency);
		waitForSpinnerIconInvisible();
	}

	public void selectCurrencyDropdown(String currency) {
		waitForElementClickable(driver, SalaryPageUI.CURRENCY_PARENT_DROPDOWN);
		selectItemInDropdown(driver, SalaryPageUI.CURRENCY_PARENT_DROPDOWN, SalaryPageUI.CURRENCY_CHILD_DROPDOWN, currency);
	}

	public void enterAmountTextbox(String amount) {
		waitForElementVisible(driver, SalaryPageUI.AMOUNT_TXTBOX);
		sendKeyToElement(driver, SalaryPageUI.AMOUNT_TXTBOX, amount);
	}
	
	public String getMessageErrorAmountTextbox() {
		return getElementText(driver, SalaryPageUI.MESSAGE_AMOUNT_ERROR);
	}
	
	public String getPayGradeSelectedText() {
		return getElementText(driver, SalaryPageUI.PAYGRADE_SELECTED_TEXT_DROPDOWN);
	}
	
	public String getPayFrequencySelectedText() {
		return getElementText(driver, SalaryPageUI.PAYFREQUENCY_SELECTED_TEXT_DROPDOWN);
	}
	
	public String getCurrencySelectedText() {
		return getElementText(driver, SalaryPageUI.CURRENCY_SELECTED_TEXT_DROPDOWN);
	}
}
