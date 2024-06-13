package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.DependenciesPageUI;

public class DependenciesPageObject extends BaseActions {
	private WebDriver driver;

	public DependenciesPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickAddButtonAtAD() {
		waitForElementClickable(driver, DependenciesPageUI.BUTTON_ADD_AT_ASSIGNED_DEPENDANTS);
		clickToElement(driver, DependenciesPageUI.BUTTON_ADD_AT_ASSIGNED_DEPENDANTS);
	}

	public void enterNameTxtbox(String nameDependant) {
		waitForElementVisible(driver, DependenciesPageUI.NAME_TXTBOX);
		sendKeyToElement(driver, DependenciesPageUI.NAME_TXTBOX,nameDependant);
	}

	public void selectRelationshipDropdown(String relationshipDependant) {
		waitForElementVisible(driver, DependenciesPageUI.RELATIONSHIP_DROPDOWN_PARENT);
		selectItemInDropdown(driver, DependenciesPageUI.RELATIONSHIP_DROPDOWN_PARENT, DependenciesPageUI.RELATIONSHIP_DROPDOWN_CHILD, relationshipDependant);
	}
	
	public void enterPleaseSpecifyTxtbox(String pS) {
		waitForElementVisible(driver, DependenciesPageUI.PLEASE_SPECTIFY_TXTBOX);
		sendKeyToElement(driver, DependenciesPageUI.PLEASE_SPECTIFY_TXTBOX, pS);
	}

	public void enterToDateOfBirthDatePicker(String dateOfBirthDependant) {
		waitForElementVisible(driver, DependenciesPageUI.DATE_OF_BIRTH_DATETIME_PICKERS);
		sendKeyToElement(driver, DependenciesPageUI.DATE_OF_BIRTH_DATETIME_PICKERS,dateOfBirthDependant);
	}

	public void clickSaveButtonAtAD() {
		waitForElementClickable(driver, DependenciesPageUI.SAVE_BUTTON_AT_DEPENDANT);
		clickToElement(driver, DependenciesPageUI.SAVE_BUTTON_AT_DEPENDANT);
	}
	
	public String getRelationshipDropdownText() {
		return getElementText(driver, DependenciesPageUI.RELATIONSHIP_DROPDOWN_SELECTED);
	}
	
	public void checkDeleteDependent() {
		waitForElementClickable(driver, DependenciesPageUI.CHECKBOX_DELETE_DEPENDANT);
		checkToDefaultCheckboxRadio(driver, DependenciesPageUI.CHECKBOX_DELETE_DEPENDANT);
	}
	
	public void clickDeleteButtonDependent() {
		waitForElementClickable(driver, DependenciesPageUI.DELETE_BUTTON);
		clickToElement(driver, DependenciesPageUI.DELETE_BUTTON);
	}
	
	public void clickConfirmDeleteButtonDependent() {
		waitForElementClickable(driver, DependenciesPageUI.CONFIRM_BUTTON);
		clickToElement(driver, DependenciesPageUI.CONFIRM_BUTTON);
		waitForSpinnerIconInvisible();
	}
}
