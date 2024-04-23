package com.wordpress.posts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.AdminDashboardPageObject;
import pageObjects.wordpress.AdminLoginPageObject;
import pageObjects.wordpress.AdminPostAddNewPageObject;
import pageObjects.wordpress.AdminPostSearchPageObject;
import pageObjects.wordpress.PageGeneratorManager;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailPO;
import pageObjects.wordpress.UserSearchPostPO;



public class Post01_Create_Read_Update_Delete_Search extends BaseTest {
	WebDriver driver;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;
	AdminPostSearchPageObject adminPostSearchPage;
	AdminPostAddNewPageObject adminPostAddNewPage;
	UserHomePO userHomePage;
	UserPostDetailPO userPostDetailPage;
	UserSearchPostPO userSearchPostPage;
	//private String projectPath = System.getProperty("user.dir");
	String adminUsername = "automationfc.vn@gmail.com";
	String adminPassword = "d*4YKn68TWGhquZA7sUmcTUx";
	String searchPostUrl;
	String postTitle = "Live coding title";
	String postBody = "Live coding body";
	String editTitle = "Edit Title";
	String editBody = "Edit Body";
	String authorName = "Automation FC";
	String adminUrl, userUrl;
	String currentDay = getCurrentDay();
	
	@Parameters({"browser","urlAdmin","urlUser"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String userUrl) {
		log.info("Pre-Condition - Step 01: Open browser and admin site");
		this.adminUrl = adminUrl;
		this.userUrl = userUrl;
		driver = getBrowserDriver(browserName);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Pre-Condition - Step 02: Enter to Username textbox with value: " + adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);
		
		log.info("Pre-Condition - Step 03: Enter to Password textbox" + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);
		
		log.info("Pre-Condition - Step 04: Click to Login button");
		adminLoginPage.clickToLoginButton();
		
		adminDashboardPage = PageGeneratorManager.getAdminDashboardPage(driver);
	}
	
	@Test
	public void Create_Post() {
		log.info("Create Post - Step 01: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();
		
		log.info("Create Post - Step 02: Get 'Search Posts' page Url");
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);
		
		log.info("Create Post - Step 03: Click to 'Add New' menu link");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();
		
		log.info("Create Post - Step 04: Enter to post title");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitle);
		
		log.info("Create Post - Step 05: Enter to body");
		adminPostAddNewPage.enterToAddNewPostBody(postBody);
		
		log.info("Create Post - Step 06: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishButton();
		
		log.info("Create Post - Step 07: Click to 'Pre-Publish' button");
		adminPostAddNewPage.clickToPrePublishButton();
		
		log.info("Create Post - Step 08: Verify 'Post published' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));
	}
	
	@Test
	public void Search_Post() {
		log.info("Search Post - Step 01: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);
		
		log.info("Search Post - Step 02: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);
		
		log.info("Search Post - Step 03: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Search Post - Step 04: Verify search table contains '"+ postTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title",postTitle));
		
		log.info("Search Post - Step 05: Verify search table contains '"+ authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author",authorName));
		
		log.info("Search Post - Step 06: Open user site");
		adminPostSearchPage.openEndUserSite(driver, this.userUrl);
		
		log.info("Search Post - Step 07: Verify post info displayed at Home Page");
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostTitle(postTitle));
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostAuthor(postTitle, authorName));
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostCurrentDay(postTitle, currentDay));
		
		log.info("Search Post - Step 08: Click to post title");
		userPostDetailPage = userHomePage.clickToPostTitle(postTitle);
		log.info("Search Post - Step 09: Verify post info displayed at Post detail page");
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostTitle(postTitle));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostAuthor(postTitle, authorName));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostCurrentDay(postTitle, currentDay));
	}
	
	
	@Test
	public void Edit_Post() {
		log.info("Edit Post - Step 01: Open Admin site");
		adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.adminUrl);
		
		log.info("Edit Post - Step 02: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();
		
		log.info("Edit Post - Step 03: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);
		
		log.info("Edit Post - Step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Edit Post - Step 05: Click to Post title link and navigate to Edit Post page");
		adminPostAddNewPage = adminPostSearchPage.clickToPostTitleLink(postTitle);
		
		log.info("Edit Post - Step 06: Enter to post title");
		adminPostAddNewPage.enterToAddNewPostTitle(editTitle);
		
		log.info("Edit Post - Step 07: Enter to post body");
		adminPostAddNewPage.enterToEditPostBody(editBody);
		
		log.info("Edit Post - Step 08: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishButton();
		
		log.info("Edit Post - Step 09: Verify 'Post updated' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post updated."));
		
		log.info("Edit Post - Step 10: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);
		
		log.info("Edit Post - Step 11: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editTitle);
		
		log.info("Edit Post - Step 12: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Edit Post - Step 13: Verify search table contains '"+ postTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title",editTitle));
		
		log.info("Edit Post - Step 14: Verify search table contains '"+ authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author",authorName));
		
		log.info("Edit Post - Step 15: Open user site");
		adminPostSearchPage.openEndUserSite(driver,this.userUrl);
		
		log.info("Edit Post - Step 16: Verify post info displayed at Home Page");
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostTitle(editTitle));
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostBody(editTitle, editBody));
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostAuthor(editTitle, authorName));
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostCurrentDay(editTitle, currentDay));
		
		log.info("Edit Post - Step 17: Click to post title");
		userPostDetailPage = userHomePage.clickToPostTitle(editTitle);
		log.info("Edit Post - Step 18: Verify post info displayed at Post detail page");
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostTitle(editTitle));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostBody(editTitle, editBody));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostAuthor(editTitle, authorName));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostCurrentDay(editTitle, currentDay));
	}
	
	@Test
	public void Delete_Post() {
		log.info("Delete Post - Step 01: Open Admin site");
		adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.adminUrl);
		
		log.info("Delete Post - Step 02: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();
		
		log.info("Delete Post - Step 03: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editTitle);
		
		log.info("Delete Post - Step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Delete Post - Step 05: Select Post detail checkbox");
		adminPostSearchPage.selectPostCheckboxByTitle(editTitle);
		
		log.info("Delete Post - Step 06: Select 'Move to Trash' item in dropdown");
		adminPostSearchPage.selectTextItemInActionDropdown("Move to Trash");
		
		log.info("Delete Post - Step 07: Click to 'Apply' button");
		adminPostSearchPage.clickToApplyButton();
		
		log.info("Delete Post - Step 08: Verify '1 post moved to the trash.' message is displayed");
		verifyTrue(adminPostSearchPage.isMoveToTrashMessageDisplayed("1 post moved to the trash."));
		
		log.info("Delete Post - Step 09: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editTitle);
		
		log.info("Delete Post - Step 10: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Delete Post - Step 11: Verify 'No posts found.' message is displayed");
		verifyTrue(adminPostSearchPage.isNoPostFoundMessageDisplayed("No posts found."));
		
		log.info("Delete Post - Step 12: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.userUrl);
		
		log.info("Delete Post - Step 13: Verify Post title undisplayed at Home page");
		verifyTrue(userHomePage.isPostInfoUnDisplayedWithPostTitle(editTitle));
		
		log.info("Delete Post - Step 14: Enter to Search textbox");
		userHomePage.enterToSearchTextbox(editTitle);
		
		log.info("Delete Post - Step 15: Click to 'Search' button");
		userSearchPostPage= userHomePage.clickToSearchButton();
		
		log.info("Delete Post - Step 16: Verify 'Nothing Found' message is displayed");
		verifyTrue(userSearchPostPage.isNothingFoundMessageDisplayed("Nothing Found"));
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
