package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopEcommerce.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage{
	private WebDriver driver;
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver,RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);
	}
	
	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver,RegisterPageUI.FNAME_ERROR_MESSAGE);
		return getElementText(driver,RegisterPageUI.FNAME_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver,RegisterPageUI.LNAME_ERROR_MESSAGE);
		return getElementText(driver,RegisterPageUI.LNAME_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver,RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver,RegisterPageUI.EMAIL_ERROR_MESSAGE);	}
	
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver,RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver,RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtConPasswordTextbox() {
		waitForElementVisible(driver,RegisterPageUI.CON_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver,RegisterPageUI.CON_PASSWORD_ERROR_MESSAGE);
	}
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver,RegisterPageUI.REGISTER_MESSAGE_SUCCESS);
		return getElementText(driver,RegisterPageUI.REGISTER_MESSAGE_SUCCESS);
	}
	
	public void inputToFirstnameTextbox(String fName) {
		waitForElementVisible(driver,RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver,RegisterPageUI.FIRST_NAME_TEXTBOX,fName);
	}
	
	public void inputToLastnameTextbox(String lName) {
		waitForElementVisible(driver,RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver,RegisterPageUI.LAST_NAME_TEXTBOX,lName);
	}
	
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver,RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX,email);
	}
	
	public void inputToPasswordTextbox(String pass) {
		waitForElementVisible(driver,RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX,pass);
	}
	
	public void inputToConfirmPasswordTextbox(String pass) {
		waitForElementVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,pass);
	}
	
	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver,RegisterPageUI.EXIST_MESSAGE_ERROR);
		return getElementText(driver,RegisterPageUI.EXIST_MESSAGE_ERROR);
	}
	
	public UserHomePageObject clickLinkRegister() {
		waitForElementClickable(driver,RegisterPageUI.REGISTER_LINK);
		clickToElement(driver, RegisterPageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public UserHomePageObject clickLinkLogout() {
		waitForElementClickable(driver,RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}
}
