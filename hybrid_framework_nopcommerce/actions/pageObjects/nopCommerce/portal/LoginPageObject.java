package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopEcommerce.user.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void enterToEmailTextbox(String email) {
		sendKeyToElement(driver,LoginPageUI.EMAIL_TEXTBOX,email);
	}
	
	public void enterToPasswordTextbox(String pass) {
		sendKeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX,pass);
	}
	
	public String getErrorEmailTxtbox() {
		waitForElementVisible(driver,LoginPageUI.EMAIL_ERROR);
		return getElementText(driver,LoginPageUI.EMAIL_ERROR);
	}
	
	public String getMessageError() {
		waitForElementVisible(driver,LoginPageUI.MESSAGE_ERROR);
		return getElementText(driver,LoginPageUI.MESSAGE_ERROR);
	}
	
	public void clickToLoginButton() {
		waitForElementVisible(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
	}
}
