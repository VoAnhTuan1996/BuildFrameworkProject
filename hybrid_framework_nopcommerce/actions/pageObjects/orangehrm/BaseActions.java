package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.BaseActionsUI;

public class BaseActions extends BasePage {
	private WebDriver driver;
	
	public BaseActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForSpinnerIconInvisible() {
		waitForAllElementInvisible(driver, BaseActionsUI.SPINNER_ICON);
	}
	
	public boolean isSuccessMessageDisplayed(String messageContent) {
		waitForElementVisible(driver, BaseActionsUI.DYNAMIC_SUCCESS_MESSAGE,messageContent);
		return isElementDisplayed(driver, BaseActionsUI.DYNAMIC_SUCCESS_MESSAGE,messageContent);
	}
	
	public boolean isValueDisplayedAtColumnName(String columnName, String rowIndex, String rowValue) {
		int columnIndex = getElementSize(driver, BaseActionsUI.DYNAMIC_INDEX_BY_COLUMN_NAME, columnName) + 1;
		return isElementDisplayed(driver, BaseActionsUI.DYNAMIC_VALUE_BY_COLUMN_INDEX_ROW_INDEX,rowIndex,String.valueOf(columnIndex),rowValue);
	}
	
	public void clickToRadioButtonByLabelName(String radioLabelName) {
		clickToElementByJS(driver, BaseActionsUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME, radioLabelName);		
	}
	
	public void clickToCheckboxByLabelName(String checkboxLabelName) {
		if(!isElementSelected(driver, BaseActionsUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME,checkboxLabelName)) {
			clickToElementByJS(driver, BaseActionsUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME,checkboxLabelName);
		}
	}
	
	public boolean isRadioButtonSelectedByLabelName(String radioLabelName) {
		return isElementSelected(driver, BaseActionsUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME,radioLabelName);
	}

	public boolean isCheckboxSelectedByLabelName(String checkboxLabelName) {
		return isElementSelected(driver, BaseActionsUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME,checkboxLabelName);
	}
	
	
	public void clickAddRecordsButtonByLabelName(String labelName) {
		clickToElementByJS(driver, BaseActionsUI.DYNAMIC_ADD_RECORDS_BUTTON_BY_LABEL_NAME,labelName);
	}
	
	public void clickSaveButtonAfterAddRecord() {
		clickToElement(driver, BaseActionsUI.DYNAMIC_SAVE_BUTTON);
	}
		
	public void clickEmployeeNavigationLinkButton(String title) {
		clickToElement(driver, BaseActionsUI.DYNAMIC_EMPLOYEE_NAVIGATION_LINK_BUTTON,title);
	}
}
