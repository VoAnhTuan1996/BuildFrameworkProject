package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import pageUIs.orangehrm.QualificationsPageUI;

public class QualificationsPageObject extends BaseActions{
	private WebDriver driver;

	public QualificationsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterCompanyTextbox(String companyName) {
		waitForElementVisible(driver, QualificationsPageUI.COMPANY_NAME_TEXTBOX);
		sendKeyToElement(driver, QualificationsPageUI.COMPANY_NAME_TEXTBOX,companyName);
	}

	public void enterJobTitleTextbox(String jobTitleExp) {
		waitForElementVisible(driver, QualificationsPageUI.JOB_TITLE_TEXTBOX);
		sendKeyToElement(driver, QualificationsPageUI.JOB_TITLE_TEXTBOX,jobTitleExp);
	}

	public void enterFromDatePickers(String fromDate) {
		waitForElementVisible(driver, QualificationsPageUI.FROM_DATE_DP);
		sendKeyToElement(driver, QualificationsPageUI.FROM_DATE_DP, fromDate);
	}

	public void enterToDatePickers(String toDate) {
		waitForElementVisible(driver, QualificationsPageUI.TO_DATE_DP);
		sendKeyToElement(driver, QualificationsPageUI.TO_DATE_DP, toDate);
	}

	public void enterCommentsTextbox(String comment) {
		waitForElementVisible(driver, QualificationsPageUI.COMMENT_TEXTAREA);
		sendKeyToElement(driver, QualificationsPageUI.COMMENT_TEXTAREA, comment);
	}

	public void selectLevelDropdown(String levelEdu) {
		waitForElementClickable(driver, QualificationsPageUI.LEVEL_PARENT_DROPDOWN);
		selectItemInDropdown(driver, QualificationsPageUI.LEVEL_PARENT_DROPDOWN, QualificationsPageUI.LEVEL_CHILD_DROPDOWN, levelEdu);
	}
	

	public void enterInstituteTxtbox(String institute) {
		waitForElementVisible(driver, QualificationsPageUI.INSTITUTE_TEXTBOX);
		sendKeyToElement(driver, QualificationsPageUI.INSTITUTE_TEXTBOX,institute);
	}

	public void enterMajorTxtbox(String major) {
		waitForElementVisible(driver, QualificationsPageUI.MAJOR_TEXTBOX);
		sendKeyToElement(driver, QualificationsPageUI.MAJOR_TEXTBOX, major);
	}

	public void enterYearTxtbox(String year) {
		waitForElementVisible(driver, QualificationsPageUI.YEAR_TEXTBOX);
		sendKeyToElement(driver, QualificationsPageUI.YEAR_TEXTBOX,year);
	}

	public void enterScoreTxtbox(String score) {
		waitForElementVisible(driver, QualificationsPageUI.SCORE_TEXTBOX);
		sendKeyToElement(driver, QualificationsPageUI.SCORE_TEXTBOX,score);		
	}

	public void enterStartDateDP(String startDate) {
		waitForElementVisible(driver, QualificationsPageUI.START_DATE_DP);
		sendKeyToElement(driver, QualificationsPageUI.START_DATE_DP, startDate);
	}

	public void enterEndDateDP(String endDate) {
		waitForElementVisible(driver, QualificationsPageUI.END_DATE_DP);
		sendKeyToElement(driver, QualificationsPageUI.END_DATE_DP, endDate);
	}

	public String getLevelSelectedText() {
		return getElementText(driver, QualificationsPageUI.LEVEL_SELECTED_TEXT_DROPDOWN);
	}

	public void selectSkillDropdown(String skillName) {
		waitForElementClickable(driver, QualificationsPageUI.SKILL_PARENT_DROPDOWN);
		selectItemInDropdown(driver, QualificationsPageUI.SKILL_PARENT_DROPDOWN, QualificationsPageUI.SKILL_CHILD_DROPDOWN, skillName);
	}

	public void enterYearExpTxtbox(String yearOfExp) {
		waitForElementVisible(driver, QualificationsPageUI.YEAR_OF_EXP_TXTBOX);
		sendKeyToElement(driver, QualificationsPageUI.YEAR_OF_EXP_TXTBOX, yearOfExp);
	}

	public String getSkillSelectedText() {
		return getElementText(driver, QualificationsPageUI.SKILL_SELECTED_TEXT_DROPDOWN);
	}

	public void selectLanguageDropdown(String language) {
		waitForElementClickable(driver, QualificationsPageUI.LANGUAGE_PARENT_DROPDOWN);
		selectItemInDropdown(driver, QualificationsPageUI.LANGUAGE_PARENT_DROPDOWN, QualificationsPageUI.LANGUAGE_CHILD_DROPDOWN,language);
	}

	public void selectFluencyDropdown(String fluency) {
		waitForElementClickable(driver, QualificationsPageUI.FLUENCY_PARENT_DROPDOWN);
		selectItemInDropdown(driver, QualificationsPageUI.FLUENCY_PARENT_DROPDOWN, QualificationsPageUI.FLUENCY_CHILD_DROPDOWN,fluency);
	}

	public void selectCompetencyDropdown(String competency) {
		waitForElementClickable(driver, QualificationsPageUI.COMPETENCY_PARENT_DROPDOWN);
		selectItemInDropdown(driver, QualificationsPageUI.COMPETENCY_PARENT_DROPDOWN, QualificationsPageUI.COMPETENCY_CHILD_DROPDOWN,competency);
	}

	public String getLanguageSelectedText() {
		return getElementText(driver, QualificationsPageUI.LANGUAGE_SELECTED_TEXT_DROPDOWN);
	}

	public String getCompetencySelectedText() {
		return getElementText(driver, QualificationsPageUI.COMPETENCY_SELECTED_TEXT_DROPDOWN);
	}

	public void selectLicenseTypeDropdown(String licenseType) {
		waitForElementClickable(driver, QualificationsPageUI.LICENSE_TYPE_PARENT_DROPDOWN);
		selectItemInDropdown(driver, QualificationsPageUI.LICENSE_TYPE_PARENT_DROPDOWN, QualificationsPageUI.LICENSE_TYPE_CHILD_DROPDOWN, licenseType);
	}

	public void enterLicenseNumberTxtbox(String licenseNumber) {
		waitForElementVisible(driver, QualificationsPageUI.LICENSE_NUMBER_TXTBOX);
		sendKeyToElement(driver, QualificationsPageUI.LICENSE_NUMBER_TXTBOX,licenseNumber);
	}

	public void enterLicenseIssuedDateDP(String licenseIssuedDate) {
		waitForElementVisible(driver, QualificationsPageUI.LICENSE_ISSUED_DATE_DP);
		sendKeyToElement(driver, QualificationsPageUI.LICENSE_ISSUED_DATE_DP,licenseIssuedDate);
	}

	public void enterLicenseExpiryDateDP(String licenseExpiryDate) {
		waitForElementVisible(driver, QualificationsPageUI.LICENSE_EXPIRY_DATE_DP);
		sendKeyToElement(driver, QualificationsPageUI.LICENSE_EXPIRY_DATE_DP,licenseExpiryDate);
	}

	public String getLicenseTypeSelectedText() {
		
		return getElementText(driver, QualificationsPageUI.LICENSE_TYPE_SELECTED_TEXT_DROPDOWN);
	}
	
	
	
}
