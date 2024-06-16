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
import pageObjects.orangehrm.ImigrationPageObject;
import pageObjects.orangehrm.JobPageObject;
import pageObjects.orangehrm.LoginPageObject;
import pageObjects.orangehrm.PageGeneratorManager;
import pageObjects.orangehrm.PersonalDetailPageObject;
import pageObjects.orangehrm.SalaryPageObject;

public class PIM_Employee extends BaseTest {
	private WebDriver driver;
	private String browserName, employeeID, firstName, lastName;
	private String driverLicenseNumber, licenseExpiryDate;
	private String dateOfBirth, genderStatus, nationality, maritalStatus, bloodType;
	private String street1, street2, city, state, zipCode, country;
	private String mobilePhone, workEmail;
	private String document, number, issuedDate, issuedBy, expiryDate, eligibleReviewDate, eligibleStatus;
	private String joinedDate, jobTitle, jobSpecification, jobCategory, subUnit, location, employmentStatus;
	private String salaryComponents, payGrade, payFrequency, currency, amount;
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
	private ImigrationPageObject imigrationPage;
	private JobPageObject jobPage;
	private SalaryPageObject salaryPage;
	private String javaFileName = "java.jpg";
	String[] multipleFileNames = {javaFileName};
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
		document = "Visa";
		number = "100";
		issuedDate = "2024-21-03";
		expiryDate = "2024-24-06";
		eligibleStatus = "enough";
		issuedBy = "Viet Nam";
		eligibleReviewDate = "2024-14-05";
		joinedDate = "2024-28-03";
		jobSpecification = "Not Defined";
		jobTitle = "Automaton Tester";
		jobCategory = "Professionals";
		subUnit = "Engineering";
		location = "New York Sales Office";
		employmentStatus = "Freelance";
		salaryComponents="10000"; 
		payGrade="Grade 3";
		payFrequency="Monthly"; 
		currency="United States Dollar"; 
		amount = "45000";
		
		
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
		
		personalDetailsPage.sleepInSecond(2);;
		
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
	
	/*
	 * @Test public void Employee_03_Contact_Details() { contactDetailsPage =
	 * personalDetailsPage.clickToContactDetailsButton();
	 * contactDetailsPage.enterStreet1Textbox(street1);
	 * contactDetailsPage.enterStreet2Textbox(street2);
	 * contactDetailsPage.enterCityTextbox(city);
	 * contactDetailsPage.enterStateTextbox(state);
	 * contactDetailsPage.enterZipCodeTextbox(zipCode);
	 * contactDetailsPage.selectCountryDropdown(country);
	 * contactDetailsPage.enterMobilePhoneTextbox(mobilePhone);
	 * contactDetailsPage.enterWorkEmailTextbox(workEmail);
	 * contactDetailsPage.clickSaveButtonAfterAddRecord();
	 * 
	 * Assert.assertTrue(contactDetailsPage.
	 * isSuccessMessageDisplayed("Successfully Updated"));
	 * Assert.assertEquals(contactDetailsPage.getCountryDropdownSelectText(),country
	 * ); }
	 * 
	 * @Test public void Employee_04_Emergency_Contacts() { emergencyContactPage =
	 * contactDetailsPage.clickToEmergencyContactsButton();
	 * emergencyContactPage.clickAddButtonAtASC();
	 * emergencyContactPage.enterNameTxtbox(nameASC);
	 * emergencyContactPage.enterRelationshipTxtbox(relationshipASC);
	 * emergencyContactPage.enterMobilePhoneTxtbox(mobileASC);
	 * emergencyContactPage.clickSaveButtonAfterAddRecord();
	 * 
	 * Assert.assertTrue(contactDetailsPage.
	 * isSuccessMessageDisplayed("Successfully Saved")); }
	 * 
	 * @Test public void Employee_05_Dependents() { dependencyPage =
	 * emergencyContactPage.clickToDependantPageButton();
	 * dependencyPage.clickAddButtonAtAD();
	 * dependencyPage.enterNameTxtbox(nameDependant);
	 * dependencyPage.selectRelationshipDropdown(relationshipDependant);
	 * dependencyPage.enterPleaseSpecifyTxtbox("friend");
	 * dependencyPage.enterToDateOfBirthDatePicker(dateOfBirthDependant);
	 * dependencyPage.clickSaveButtonAfterAddRecord();
	 * 
	 * Assert.assertTrue(dependencyPage.
	 * isSuccessMessageDisplayed("Successfully Saved"));
	 * Assert.assertEquals(dependencyPage.getRelationshipDropdownText(),
	 * relationshipDependant); }
	 * 
	 * @Test public void Employee_06_Immigration() { imigrationPage =
	 * dependencyPage.clickToImigrationPageButton(); imigrationPage.
	 * clickAddRecordsButtonByLabelName("Assigned Immigration Records");
	 * imigrationPage.clickToRadioButtonByLabelName(document);
	 * imigrationPage.enterNumberTextbox(number);
	 * imigrationPage.enterToIssuedDate_DP(issuedDate);
	 * imigrationPage.enterToExpiryDate_DP(expiryDate);
	 * imigrationPage.enterEligibleStatusTxtbox(eligibleStatus);
	 * imigrationPage.clickItemIssuedByDropdown(issuedBy);
	 * imigrationPage.enterEligibleReviewDate_DP(eligibleReviewDate);
	 * imigrationPage.clickSaveButtonAfterAddRecord();
	 * 
	 * Assert.assertTrue(imigrationPage.
	 * isSuccessMessageDisplayed("Successfully Saved"));
	 * Assert.assertEquals(imigrationPage.getIssuedByDropdownSelectedText(),
	 * issuedBy); }
	 */
	
	//@Test
	public void Employee_07_Job() {
		//imigrationPage.clickEmployeeNavigationLinkButton("Job");
		personalDetailsPage.clickEmployeeNavigationLinkButton("Job");
		jobPage = PageGeneratorManager.getJobPage(driver);
		jobPage.enterJoinedDate_DP(joinedDate);
		jobPage.sleepInSecond(1);
		jobPage.selectItemJobTitleInDropdown(jobTitle);
		jobPage.sleepInSecond(1);
		jobPage.selectItemJobCategoryInDropdown(jobCategory);
		jobPage.sleepInSecond(1);
		jobPage.selectItemSubUnitInDropdown(subUnit);
		jobPage.sleepInSecond(1);
		jobPage.selectItemLocationInDropdown(location);
		jobPage.sleepInSecond(1);
		jobPage.selectItemEmploymentStatus(employmentStatus);
		jobPage.sleepInSecond(1);
		jobPage.clickIECD_checkboxButton();
		jobPage.sleepInSecond(1);
		jobPage.enterContractStartDate("2023-01-03");
		jobPage.enterContractEndDate("2024-12-03");
		jobPage.uploadMultipleFiles(driver, multipleFileNames);
		//jobPage.clickToBrowseButton();
		jobPage.sleepInSecond(3);
		jobPage.clickSaveButtonAfterAddRecord();
		Assert.assertTrue(jobPage.isSuccessMessageDisplayed("Successfully Updated"));
		Assert.assertEquals(jobPage.getJobSpecification(),jobSpecification);
		Assert.assertEquals(jobPage.getJobTitle(),jobTitle);
		Assert.assertEquals(jobPage.getJobCategory(),jobCategory);
		Assert.assertEquals(jobPage.getSubUnit(),subUnit);
		Assert.assertEquals(jobPage.getLocation(),location);
		Assert.assertEquals(jobPage.getEmployementStatus(), employmentStatus);
	}
	
	@Test
	public void Employee_08_Salary() {
		personalDetailsPage.clickEmployeeNavigationLinkButton("Salary");
		salaryPage = PageGeneratorManager.getSalaryPage(driver);
		salaryPage.clickAddRecordsButtonByLabelName("Assigned Salary Components");
		salaryPage.enterSalaryComponentsTextbox(salaryComponents);
		salaryPage.selectPayGradeDropdown(payGrade);
		salaryPage.selectPayFrequencyDropdown(payFrequency);
		salaryPage.selectCurrencyDropdown(currency);
		salaryPage.enterAmountTextbox(amount);
		
		Assert.assertEquals(salaryPage.getMessageErrorAmountTextbox(), "Should be within Min/Max values");
		Assert.assertEquals(salaryPage.getPayGradeSelectedText(), payGrade);
		Assert.assertEquals(salaryPage.getPayFrequencySelectedText(), payFrequency);
		Assert.assertEquals(salaryPage.getCurrencySelectedText(), currency);
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
