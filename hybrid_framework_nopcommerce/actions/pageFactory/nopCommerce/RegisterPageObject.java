package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	
	@CacheLookup
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(id = "FirstName-error")
	private WebElement firstNameErrorMessage;
	
	@FindBy(id = "LastName-error")
	private WebElement lastNameErrorMessage;
	
	@FindBy(id = "Email-error")
	private WebElement emailErrorMessage;
	
	@FindBy(id = "Password-error")
	private WebElement passwordErrorMessage;
	
	@FindBy(id = "ConfirmPassword-error")
	private WebElement confirmPasswordErrorMessage;
	
	@FindBy(css = "div.result")
	private WebElement registerSuccessMessage;
	
	@FindBy(xpath = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//div[contains(@class,'message-error')]//li")
	private WebElement existingEmailErrorMessage;
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver,registerButton);
		clickToElement(driver,registerButton);
	}
	
	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver,firstNameErrorMessage);
		return getElementText(driver,firstNameErrorMessage);
	}
	
	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver,lastNameErrorMessage);
		return getElementText(driver,lastNameErrorMessage);
	}
	
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver,emailErrorMessage);
		return getElementText(driver,emailErrorMessage);
	}
	
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver,passwordErrorMessage);
		return getElementText(driver,passwordErrorMessage);
	}
	
	public String getErrorMessageAtConPasswordTextbox() {
		waitForElementVisible(driver,confirmPasswordErrorMessage);
		return getElementText(driver,confirmPasswordErrorMessage);
	}
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver,registerSuccessMessage);
		return getElementText(driver,registerSuccessMessage);
	}
	
	public void inputToFirstnameTextbox(String fName) {
		waitForElementVisible(driver,firstNameTextbox);
		sendKeyToElement(driver,firstNameTextbox,fName);
	}
	
	public void inputToLastnameTextbox(String lName) {
		waitForElementVisible(driver,lastNameTextbox);
		sendKeyToElement(driver,lastNameTextbox,lName);
	}
	
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver,emailTextbox);
		sendKeyToElement(driver,emailTextbox,email);
	}
	
	public void inputToPasswordTextbox(String pass) {
		waitForElementVisible(driver,passwordTextbox);
		sendKeyToElement(driver,passwordTextbox,pass);
	}
	
	public void inputToConfirmPasswordTextbox(String pass) {
		waitForElementVisible(driver,confirmPasswordTextbox);
		sendKeyToElement(driver,confirmPasswordTextbox,pass);
	}
	
	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver,existingEmailErrorMessage);
		return getElementText(driver,existingEmailErrorMessage);
	}
	
	public void clickLinkRegister() {
		waitForElementClickable(driver,registerLink);
		clickToElement(driver, registerLink);
	}
}
