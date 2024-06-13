package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.AddEmployeePageUI;


public class AddEmployeePageObject extends BaseActions{
	private WebDriver driver;

	public AddEmployeePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToFirstNameTextbox(String fName) {
		waitForElementVisible(driver, AddEmployeePageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, AddEmployeePageUI.FIRSTNAME_TEXTBOX, fName);
	}
	

	public void enterToLastNameTextbox(String lName) {
		waitForElementVisible(driver, AddEmployeePageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, AddEmployeePageUI.LASTNAME_TEXTBOX, lName);
	}
	

	public String getEmployeeID() {
		waitForElementVisible(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
		return getElementAttribute(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX, "value");
	}

	public void clickSaveButton() {
		waitForElementClickable(driver, AddEmployeePageUI.SAVE_BUTTON);
		clickToElement(driver, AddEmployeePageUI.SAVE_BUTTON);
	}
	
	
}
