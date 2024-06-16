package pageObjects.orangehrm;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.uploadfile.HomePageUI;
import pageUIs.orangehrm.JobPageUI;

public class JobPageObject extends BaseActions{
	private WebDriver driver;

	public JobPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void enterJoinedDate_DP(String jobDate) {
		waitForElementVisible(driver, JobPageUI.JOB_DATE_DATETIME_PICKERS);
		sendKeyToElement(driver, JobPageUI.JOB_DATE_DATETIME_PICKERS, jobDate);
	}
	
	public void selectItemJobTitleInDropdown(String jobTitle) {
		waitForElementClickable(driver, JobPageUI.JOB_TITLE_PARENT_DROPDOWN);
		selectItemInDropdown(driver, JobPageUI.JOB_TITLE_PARENT_DROPDOWN, JobPageUI.JOB_TITLE_CHILD_DROPDOWN, jobTitle);
	}
	
	public void selectItemJobCategoryInDropdown(String jobCategory) {
		waitForElementClickable(driver, JobPageUI.JOB_CATEGORY_PARENT_DROPDOWN);
		selectItemInDropdown(driver, JobPageUI.JOB_CATEGORY_PARENT_DROPDOWN, JobPageUI.JOB_CATEGORY_CHILD_DROPDOWN, jobCategory);
	}

	public void selectItemSubUnitInDropdown(String subUnit) {
		waitForElementClickable(driver, JobPageUI.SUB_UNIT_PARENT_DROPDOWN);
		selectItemInDropdown(driver, JobPageUI.SUB_UNIT_PARENT_DROPDOWN, JobPageUI.SUB_UNIT_CHILD_DROPDOWN, subUnit);
	}

	public void selectItemLocationInDropdown(String location) {
		waitForElementClickable(driver, JobPageUI.LOCATION_PARENT_DROPDOWN);
		selectItemInDropdown(driver, JobPageUI.LOCATION_PARENT_DROPDOWN, JobPageUI.LOCATION_CHILD_DROPDOWN, location);
	}

	public void selectItemEmploymentStatus(String employmentStatus) {
		waitForElementClickable(driver, JobPageUI.EMPLOYEMENT_STATUS_PARENT_DROPDOWN);
		selectItemInDropdown(driver, JobPageUI.EMPLOYEMENT_STATUS_PARENT_DROPDOWN, JobPageUI.EMPLOYEMENT_STATUS_CHILD_DROPDOWN, employmentStatus);
	}
	
	public void clickIECD_checkboxButton() {
		waitForElementClickable(driver, JobPageUI.IECD_CHECKBOX_BUTTON);
		clickToElement(driver, JobPageUI.IECD_CHECKBOX_BUTTON);
	}
	
	public void enterContractStartDate(String startDate) {
		waitForElementVisible(driver, JobPageUI.CONTRACT_START_DATE);
		sendKeyToElement(driver, JobPageUI.CONTRACT_START_DATE, startDate);
	}
	
	public void enterContractEndDate(String endDate) {
		waitForElementVisible(driver, JobPageUI.CONTRACT_END_DATE);
		sendKeyToElement(driver, JobPageUI.CONTRACT_END_DATE, endDate);
	}
	
	public void clickToBrowseButton() {
		List<WebElement> browseButtons = getListWebElement(driver, JobPageUI.UPLOAD_FILE_BUTTON);
		for(WebElement browseButton : browseButtons) {
			browseButton.click();
			sleepInSecond(2);
		}
	}
	
	public String getJobSpecification() {
		return getElementText(driver, JobPageUI.JOB_SPECIFICATION_TXTBOX);
	}
	
	public String getJobTitle() {
		return getElementText(driver, JobPageUI.JOB_TITLE_SELECTED_TEXT_DROPDOWN);
	}
	
	public String getJobCategory() {
		return getElementText(driver, JobPageUI.JOB_CATEGORY_SELECTED_TEXT_DROPDOWN);
	}
	
	public String getSubUnit() {
		return getElementText(driver, JobPageUI.SUB_UNIT_SELECTED_TEXT_DROPDOWN);
	}
	
	public String getLocation() {
		return getElementText(driver, JobPageUI.LOCATION_SELECTED_TEXT_DROPDOWN);
	}
	
	public String getEmployementStatus() {
		return getElementText(driver, JobPageUI.EMPLOYEMENT_STATUS_SELECTED_TEXT_DROPDOWN);
	}
	
}
