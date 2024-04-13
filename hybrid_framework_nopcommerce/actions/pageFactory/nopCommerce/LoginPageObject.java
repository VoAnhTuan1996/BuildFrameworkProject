package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopEcommerce.user.LoginPageUI;

public class LoginPageObject extends BasePageFactory {
private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	private WebElement loginButton;
	
	@FindBy(id = "Email-error")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath = "//div[contains(@class,'message-error')]")
	private WebElement messageError;
	
	public void enterToEmailTextbox(String email) {
		sendKeyToElement(driver,emailTextbox,email);
	}
	
	public void enterToPasswordTextbox(String pass) {
		sendKeyToElement(driver,passwordTextbox,pass);
	}
	
	public String getErrorEmailTxtbox() {
		waitForElementVisible(driver,emailErrorMessage);
		return getElementText(driver,emailErrorMessage);
	}
	
	public String getMessageError() {
		waitForElementVisible(driver,messageError);
		return getElementText(driver,messageError);
	}
	
	public void clickToLoginButton() {
		waitForElementVisible(driver,loginButton);
		clickToElement(driver,loginButton);
	}
	
	
	
}
