package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.BaseActionsUI;
import pageUIs.bankguru.NewCustomerPageUI;

public class BaseActions extends BasePage {
	public WebDriver driver;
	
	public BaseActions(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isLabelNameIsDisplayed(String labelName) {
		waitForElementVisible(driver,BaseActionsUI.DYNAMIC_LABEL_TEXT, labelName);
		return isElementDisplayed(driver,BaseActionsUI.DYNAMIC_LABEL_TEXT,labelName);
	}
	
	public void clickDynamicPageByLabelName(String labelName) {
		waitForElementVisible(driver,BaseActionsUI.DYNAMIC_ITEM_LINK_BY_NAME,labelName);
		clickToElement(driver,BaseActionsUI.DYNAMIC_ITEM_LINK_BY_NAME,labelName);
	}
	
	public String getDynamicMessageSuccessful() {
		return getElementText(driver,BaseActionsUI.DYNAMIC_MESSAGE_SUCCESFULLY);
	}
}
