package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostSearchPageUI;

public class AdminPostSearchPageObject extends BasePage {
	WebDriver driver;
	
	public AdminPostSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPageObject clickToAddNewButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}

	public void enterToSearchTextbox(String postTitle) {
		waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX);
		sendKeyToElement(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX, postTitle);
	}

	public void clickToSearchPostsButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_POSTS_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.SEARCH_POSTS_BUTTON);		
	}

	public boolean isPostSearchTableDisplayed(String headerID, String cellValue) {
		int headerIndex = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerID)+1;
		waitForElementVisible(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX,String.valueOf(headerIndex),cellValue);	
		return isElementDisplayed(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX,String.valueOf(headerIndex),cellValue);
	}


	public AdminPostAddNewPageObject clickToPostTitleLink(String postTitle) {
		waitForElementClickable(driver, AdminPostSearchPageUI.ROW_TITLE_DETAIL, postTitle);
		clickToElement(driver, AdminPostSearchPageUI.ROW_TITLE_DETAIL, postTitle);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}

	public void selectPostCheckboxByTitle(String editTitle) {
		waitForElementClickable(driver, AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE_NAME,editTitle);
		checkToDefaultCheckboxRadio(driver,AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE_NAME,editTitle);
	}

	public void selectTextItemInActionDropdown(String dropdownItem) {
		waitForElementClickable(driver, AdminPostSearchPageUI.ACTION_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminPostSearchPageUI.ACTION_DROPDOWN, dropdownItem);
	}

	public void clickToApplyButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.APPLY_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.APPLY_BUTTON);
	}

	public boolean isMoveToTrashMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE, message);
	}

	public boolean isNoPostFoundMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, message);
	}


}
