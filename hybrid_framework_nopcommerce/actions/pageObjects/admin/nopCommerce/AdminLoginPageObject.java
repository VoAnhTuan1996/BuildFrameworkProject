package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopEcommerce.admin.AdminLoginUI;

public class AdminLoginPageObject extends BasePage{
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterToEmailTextbox(String email) {
		sendKeyToElement(driver,AdminLoginUI.EMAIL_TEXTBOX,email);
	}
	
	public void enterToPasswordTextbox(String pass) {
		sendKeyToElement(driver,AdminLoginUI.PASSWORD_TEXTBOX,pass);
	}
	
	public DashboardObject clickToLoginButton() {
		waitForElementVisible(driver,AdminLoginUI.LOGIN_BUTTON);
		clickToElement(driver,AdminLoginUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboardPage(driver);
	}
	
	public DashboardObject loginAsAdmin(String emailAddress, String password) {
		enterToEmailTextbox(emailAddress);
		enterToPasswordTextbox(password);
		return clickToLoginButton();
	}
}
