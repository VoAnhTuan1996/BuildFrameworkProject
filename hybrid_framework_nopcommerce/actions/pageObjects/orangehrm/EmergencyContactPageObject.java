package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.EmergencyContactPageUI;

public class EmergencyContactPageObject extends BaseActions {
	private WebDriver driver;

	public EmergencyContactPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickAddButtonAtASC() {
		waitForElementClickable(driver, EmergencyContactPageUI.BUTTON_ADD_AT_ASSIGNED);
		clickToElement(driver, EmergencyContactPageUI.BUTTON_ADD_AT_ASSIGNED);
	}

	public void enterNameTxtbox(String nameASC) {
		waitForElementVisible(driver, EmergencyContactPageUI.NAME_TXTBOX);
		sendKeyToElement(driver, EmergencyContactPageUI.NAME_TXTBOX, nameASC);
	}

	public void enterRelationshipTxtbox(String relationshipASC) {
		waitForElementVisible(driver, EmergencyContactPageUI.RELATIONSHIP_TEXTBOX);
		sendKeyToElement(driver, EmergencyContactPageUI.RELATIONSHIP_TEXTBOX, relationshipASC);
	}

	public void enterMobilePhoneTxtbox(String mobileASC) {
		waitForElementVisible(driver, EmergencyContactPageUI.MOBILE_TXTBOX);
		sendKeyToElement(driver, EmergencyContactPageUI.MOBILE_TXTBOX, mobileASC);
	}

	public void clickSaveButtonAtASC() {
		waitForElementClickable(driver, EmergencyContactPageUI.SAVE_BUTTON_AT_SAVE_EMERGENCY);
		clickToElement(driver, EmergencyContactPageUI.SAVE_BUTTON_AT_SAVE_EMERGENCY);
	}

	public DependenciesPageObject clickToDependantPageButton() {
		waitForElementClickable(driver, EmergencyContactPageUI.DEPENDENTS_BUTTON);
		clickToElement(driver, EmergencyContactPageUI.DEPENDENTS_BUTTON);
		waitForSpinnerIconInvisible();
		return PageGeneratorManager.getDependentsPage(driver);
	}


}
