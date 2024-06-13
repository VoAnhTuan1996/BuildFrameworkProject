package com.orangehrm.pim;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.orangehrm.AddEmployeePageObject;
import pageObjects.orangehrm.ContactDetailPageObject;
import pageObjects.orangehrm.DashboardPageObject;
import pageObjects.orangehrm.DependenciesPageObject;
import pageObjects.orangehrm.EmergencyContactPageObject;
import pageObjects.orangehrm.EmployeeListPageObject;
import pageObjects.orangehrm.LoginPageObject;
import pageObjects.orangehrm.PageGeneratorManager;
import pageObjects.orangehrm.PersonalDetailPageObject;

public class PIM_Employee extends BaseTest {
	private WebDriver driver;
	private String browserName, employeeID, firstName, lastName;
	private String driverLicenseNumber, licenseExpiryDate;
	private String dateOfBirth, genderStatus, nationality, maritalStatus, bloodType;
	private String street1, street2, city, state, zipCode, country;
	private String mobilePhone, workEmail;
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int USERNAME_LENGTH = 10;
    private static final String DOMAIN = "example.com";
	private String nameASC, relationshipASC, mobileASC;
	private String nameDependant, relationshipDependant, dateOfBirthDependant;
	private LoginPageObject loginPage;
	private DashboardPageObject dashboardPage;
	private EmployeeListPageObject employeeListPage;
	private AddEmployeePageObject addEmployeePage;
	private PersonalDetailPageObject personalDetailsPage;
	private ContactDetailPageObject contactDetailsPage;
	private EmergencyContactPageObject emergencyContactPage;
	private DependenciesPageObject dependencyPage;
	@Parameters({"url","browser"})
	@BeforeClass
	public void beforeClass(String url, String browserName) {
		driver = getBrowserDriver(browserName, url);
		this.browserName = browserName;
		firstName = "Michael";
		lastName = "Oliver";
		driverLicenseNumber = "D08954796";
		licenseExpiryDate = "2024-01-03";
		nationality = "American";
		maritalStatus = "Married";
		dateOfBirth = "1986-10-10";
		genderStatus = "Male";
		bloodType = "B+";
		street1 = "869 Waxwing Alley"; 
		street2 = "9299 Meadow Vale Park";
		city = "Miami";
		state = "Lousiana";
		zipCode = "0748";
		country = "United States";
		mobilePhone = "0945765123";
		workEmail = randomEmail();
		nameASC = "Manda";
		relationshipASC = "Co-worker";
		mobileASC = "0564897212";
		nameDependant = "Henry";
		relationshipDependant = "Other";
		dateOfBirthDependant = "1990-08-08";
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		loginPage.enterToUserNameTextbox("Admin");
		loginPage.enterToPasswordTextbox("admin123");
		dashboardPage = loginPage.clickLoginButton();
		
		employeeListPage = dashboardPage.openPIMModule();
	}
	
	public static String randomEmail() {
		StringBuilder username = new StringBuilder();
        Random random = new Random();
        
        for (int i = 0; i < USERNAME_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            username.append(CHARACTERS.charAt(index));
        }

        return username.toString() + "@" + DOMAIN;
	}
	
	@Test
	public void Employee_01_Add_New() {
		addEmployeePage = employeeListPage.clickToAddEmployeeButton();
		
		addEmployeePage.enterToFirstNameTextbox(firstName);
		addEmployeePage.enterToLastNameTextbox(lastName);
		employeeID = addEmployeePage.getEmployeeID();
		
		addEmployeePage.clickSaveButton();
		
		Assert.assertTrue(addEmployeePage.isSuccessMessageDisplayed("Successfully Saved"));
		addEmployeePage.isSuccessMessageDisplayed("Successfully Saved");
		addEmployeePage.waitForSpinnerIconInvisible();
		
		personalDetailsPage = PageGeneratorManager.getPersonalDetailPage(driver);
		
		Assert.assertTrue(personalDetailsPage.isPersonalDetailsHeaderDisplayed());
		personalDetailsPage.waitForSpinnerIconInvisible();
		
		Assert.assertEquals(personalDetailsPage.getFirstNameValue(),firstName);
		Assert.assertEquals(personalDetailsPage.getLastNameValue(),lastName);
		Assert.assertEquals(personalDetailsPage.getEmployeeIDValue(), employeeID);
		
		employeeListPage = personalDetailsPage.clickToEmployeeListButton();
		
		employeeListPage.enterToEmployeeIDTextbox(employeeID);
		employeeListPage.clickToSearchButton();
		
		Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("Id","1",employeeID));
		Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("First (& Middle) Name","1",firstName));
		Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("Last Name","1",lastName));
	}
	
	@Test
	public void Employee_02_Personal_Details() {
		employeeListPage.clickToEditIconByEmployeeID(employeeID);
		
		Assert.assertTrue(personalDetailsPage.isPersonalDetailsHeaderDisplayed());
		
		Assert.assertEquals(personalDetailsPage.getFirstNameValue(), firstName);
		Assert.assertEquals(personalDetailsPage.getLastNameValue(), lastName);
		Assert.assertEquals(personalDetailsPage.getEmployeeIDValue(), employeeID);
		
		personalDetailsPage.enterToDriverLicenseNumberTextbox(driverLicenseNumber);
		
		personalDetailsPage.enterToLicenseExpiryDatePicker(licenseExpiryDate);
		
		personalDetailsPage.selectToNationalityDropdown(nationality);
		
		personalDetailsPage.selectToMaritalStatusDropdown(maritalStatus);
		
		personalDetailsPage.enterToDateOfBirthDatePicker(dateOfBirth);
		
		personalDetailsPage.clickToRadioButtonByLabelName(genderStatus);
		
		personalDetailsPage.clickToSaveButtonAtPersonalDetailPart();
		
		Assert.assertTrue(personalDetailsPage.isSuccessMessageDisplayed("Successfully Updated"));
		personalDetailsPage.waitForSpinnerIconInvisible();
		
		Assert.assertEquals(personalDetailsPage.getNationalityDropdownSelectedText(), nationality);
		Assert.assertEquals(personalDetailsPage.getMaritalStatusDropdownSelectedText(), maritalStatus);
		
		Assert.assertTrue(personalDetailsPage.isRadioButtonSelectedByLabelName(genderStatus));
		
		personalDetailsPage.selectToBloodTypeDropdown(bloodType);
		personalDetailsPage.enterTestField("test");
		personalDetailsPage.clickToSaveButtonAtCustomField();
		
		Assert.assertTrue(personalDetailsPage.isSuccessMessageDisplayed("Successfully Saved"));
		personalDetailsPage.waitForSpinnerIconInvisible();
		
		Assert.assertEquals(personalDetailsPage.getBloodTypeDropdownSelectedText(),bloodType);
		
	}
	
	@Test
	public void Employee_03_Contact_Details() {
		contactDetailsPage = personalDetailsPage.clickToContactDetailsButton();
		contactDetailsPage.enterStreet1Textbox(street1);
		contactDetailsPage.enterStreet2Textbox(street2);
		contactDetailsPage.enterCityTextbox(city);
		contactDetailsPage.enterStateTextbox(state);
		contactDetailsPage.enterZipCodeTextbox(zipCode);
		contactDetailsPage.selectCountryDropdown(country);
		contactDetailsPage.enterMobilePhoneTextbox(mobilePhone);
		contactDetailsPage.enterWorkEmailTextbox(workEmail);
		contactDetailsPage.clickSaveButtonAtContactDetails();
		
		Assert.assertTrue(contactDetailsPage.isSuccessMessageDisplayed("Successfully Updated"));
		Assert.assertEquals(contactDetailsPage.getCountryDropdownSelectText(),country);
	}
	
	@Test
	public void Employee_04_Emergency_Contacts() {
		emergencyContactPage = contactDetailsPage.clickToEmergencyContactsButton();
		emergencyContactPage.clickAddButtonAtASC();
		emergencyContactPage.enterNameTxtbox(nameASC);
		emergencyContactPage.enterRelationshipTxtbox(relationshipASC);
		emergencyContactPage.enterMobilePhoneTxtbox(mobileASC);
		emergencyContactPage.clickSaveButtonAtASC();
		
		Assert.assertTrue(contactDetailsPage.isSuccessMessageDisplayed("Successfully Saved"));
	}
	
	@Test
	public void Employee_05_Dependents() {
		dependencyPage = emergencyContactPage.clickToDependantPageButton();
		dependencyPage.clickAddButtonAtAD();
		dependencyPage.enterNameTxtbox(nameDependant);
		dependencyPage.selectRelationshipDropdown(relationshipDependant);
		dependencyPage.enterPleaseSpecifyTxtbox("friend");
		dependencyPage.enterToDateOfBirthDatePicker(dateOfBirthDependant);
		dependencyPage.clickSaveButtonAtAD();
		
		Assert.assertTrue(dependencyPage.isSuccessMessageDisplayed("Successfully Saved"));
		Assert.assertEquals(dependencyPage.getRelationshipDropdownText(),relationshipDependant);
		
		dependencyPage.checkDeleteDependent();
		dependencyPage.clickDeleteButtonDependent();
		dependencyPage.clickConfirmDeleteButtonDependent();
	}
	
	@Test
	public void Employee_06_Immigration() {
		
	}
	
	@Test
	public void Employee_07_Job() {
		
	}
	
	@Test
	public void Employee_08_Salary() {
		
	}
	
	@Test
	public void Employee_09_Report() {
		
	}
	
	@Test
	public void Employee_10_Qualifications() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
