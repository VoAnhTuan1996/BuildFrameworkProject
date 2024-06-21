package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.ReportToPageUI;

public class ReportToPageObject extends BaseActions{
	private WebDriver driver;

	public ReportToPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterNameSupervisor(String string) {
		waitForElementVisible(driver, ReportToPageUI.NAME_SUPERVISOR_INPUT);
		sendKeyToElement(driver, ReportToPageUI.NAME_SUPERVISOR_INPUT, string);
	}

	public void clickItemNameSupervisor1(String itemName) {
		waitForElementClickable(driver, ReportToPageUI.NAME_SUPERVISOR_ITEM_1);
		clickToElement(driver, ReportToPageUI.NAME_SUPERVISOR_ITEM_1);
	}
	
	public void clickItemNameSupervisor2(String itemName) {
		waitForElementClickable(driver, ReportToPageUI.NAME_SUPERVISOR_ITEM_2);
		clickToElement(driver, ReportToPageUI.NAME_SUPERVISOR_ITEM_2);
	}

	public void selectReportingMethodDropdown(String reportingMethodsSupervisor) {
		waitForElementClickable(driver, ReportToPageUI.REPORTING_METHOD_PARENT_DROPDOWN);
		selectItemInDropdown(driver, ReportToPageUI.REPORTING_METHOD_PARENT_DROPDOWN, ReportToPageUI.REPORTING_METHOD_CHILD_DROPDOWN, reportingMethodsSupervisor);
	}
	
	public void clickSaveButtonAtAddSupervisor() {
		waitForElementClickable(driver, ReportToPageUI.SAVE_BUTTON_AT_REPORT_TO_PAGE);
		clickToElement(driver, ReportToPageUI.SAVE_BUTTON_AT_REPORT_TO_PAGE);
	}
	
	public String getReportingMethodSelectedText() {
		return getElementText(driver, ReportToPageUI.REPORTING_METHOD_SELECTED_TEXT_DROPDOWN);
	}
}
