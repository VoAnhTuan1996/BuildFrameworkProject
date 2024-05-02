package pageUIs.nopEcommerce.user;

public class RegisterPageUI {
	public static final String FIRST_NAME_TEXTBOX = "id=FirstName";
	public static final String LAST_NAME_TEXTBOX = "id=LastName";
	public static final String EMAIL_TEXTBOX = "id=Email";
	public static final String PASSWORD_TEXTBOX = "id=Password";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "id=ConfirmPassword";
	public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";
	public static final String FNAME_ERROR_MESSAGE = "id=FirstName-error";
	public static final String LNAME_ERROR_MESSAGE = "id=LastName-error";
	public static final String EMAIL_ERROR_MESSAGE = "id=Email-error";
	public static final String PASSWORD_ERROR_MESSAGE = "id=Password-error";
	public static final String CON_PASSWORD_ERROR_MESSAGE = "id=ConfirmPassword-error";
	public static final String REGISTER_MESSAGE_SUCCESS = "xpath=//div[@class='result']";
	public static final String EXIST_MESSAGE_ERROR = "xpath=//div[contains(@class,'message-error')]//li";
	public static final String REGISTER_LINK = "xpath=//a[@class='ico-register']";
	public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
}
