package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopEcommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage{
	private WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver) {
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
	
	public UserHomePageObject clickToLoginButton() {
		waitForElementVisible(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		enterToEmailTextbox(emailAddress);
		enterToPasswordTextbox(password);
		return clickToLoginButton();
	}
}
