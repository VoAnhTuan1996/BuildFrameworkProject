package pageUIs.wordpress;

public class UserHomePageUI {
	public static final String POST_TITLE_TEXT = "xpath=//article//h2/a[text()='%s']";
	public static final String POST_CURRENT_DATE_TEXT_BY_POST_TITLE = "xpath=//article//a[text()='%s']/parent::h2/following-sibling::div//time[text()='%s']";
	public static final String POST_BODY_TEXT_BY_POST_TITLE = "xpath=//article//p[text()='%s']/ancestor::header/following-sibling::div/p[text()='%s']";
	public static final String AUTHOR_BODY_TEXT_BY_POST_TITLE = "xpath=//article//p[text()='%s']/parent::h2/following-sibling::div//span[@class='author vcard']/a[text()='%s']";
	public static final String SEARCH_TEXTBOX = "xpath=//input[@name='s']";
	public static final String SEARCH_BUTTON = "css=button.wp-block-search__button";
}
