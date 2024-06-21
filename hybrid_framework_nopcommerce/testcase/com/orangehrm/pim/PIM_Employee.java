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
import pageObjects.orangehrm.QualificationsPageObject;
import pageObjects.orangehrm.ReportToPageObject;
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
	private String nameSupervisor1, nameSupervisor2, reportingMethodsSupervisor;
	private String companyName, jobTitleExp, fromDate, toDate, comment;
	private String levelEdu, institute, major, year, score, startDate, endDate;
	private String skillName, yearOfExp;
	private String language, fluency, competency;
	private String licenseType, licenseNumber, licenseIssuedDate, licenseExpiredDate;
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
	private ReportToPageObject reportToPage;
	private QualificationsPageObject qualificationsPage;
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
		nameSupervisor1 = "a";
		nameSupervisor2 = "b";
		reportingMethodsSupervisor = "Direct";
		companyName="Apple"; 
		jobTitleExp="Technical Engineer";
		fromDate="2020-5-1"; 
		toDate="2024-9-10"; 
		comment="abcxyz";
		levelEdu="Master's Degree"; 
		institute="MIT"; 
		major="Computer Science";
		year="2020";
		score="9.6";
		startDate="2016-09-09"; 
		endDate="2020-04-15";
		skillName="Java";
		yearOfExp="4";
		language="English";
		fluency="";
		competency="Good";
		licenseType="Microsoft Certified Systems Engineer (MCSE)"; 
		licenseNumber="1"; 
		licenseIssuedDate="2023-08-05";
		licenseExpiredDate="2025-08-05";
		
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
		contactDetailsPage.clickSaveButtonAfterAddRecord();
	  
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
		emergencyContactPage.clickSaveButtonAfterAddRecord();
	  
		Assert.assertTrue(contactDetailsPage.isSuccessMessageDisplayed("Successfully Saved")); }
	  
	@Test
	public void Employee_05_Dependents() {
		dependencyPage = emergencyContactPage.clickToDependantPageButton();
		dependencyPage.clickAddButtonAtAD();
		dependencyPage.enterNameTxtbox(nameDependant);
		dependencyPage.selectRelationshipDropdown(relationshipDependant);
		dependencyPage.enterPleaseSpecifyTxtbox("friend");
		dependencyPage.enterToDateOfBirthDatePicker(dateOfBirthDependant);
		dependencyPage.clickSaveButtonAfterAddRecord();
	  
		Assert.assertTrue(dependencyPage.isSuccessMessageDisplayed("Successfully Saved"));
		Assert.assertEquals(dependencyPage.getRelationshipDropdownText(),relationshipDependant); }
	  
	@Test 
	public void Employee_06_Immigration() { 
		imigrationPage = dependencyPage.clickToImigrationPageButton(); imigrationPage.
		clickAddRecordsButtonByLabelName("Assigned Immigration Records");
		imigrationPage.clickToRadioButtonByLabelName(document);
		imigrationPage.enterNumberTextbox(number);
		imigrationPage.enterToIssuedDate_DP(issuedDate);
		imigrationPage.enterToExpiryDate_DP(expiryDate);
		imigrationPage.enterEligibleStatusTxtbox(eligibleStatus);
		imigrationPage.clickItemIssuedByDropdown(issuedBy);
		imigrationPage.enterEligibleReviewDate_DP(eligibleReviewDate);
		imigrationPage.clickSaveButtonAfterAddRecord();
	  
		Assert.assertTrue(imigrationPage.isSuccessMessageDisplayed("Successfully Saved"));
		Assert.assertEquals(imigrationPage.getIssuedByDropdownSelectedText(),issuedBy);
	}
	 
	
	@Test
	public void Employee_07_Job() {
		imigrationPage.clickEmployeeNavigationLinkButton("Job");
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
		jobPage.clickEmployeeNavigationLinkButton("Salary");
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
		salaryPage.clickEmployeeNavigationLinkButton("Report-to");
		reportToPage = PageGeneratorManager.getReportToPage(driver);
		reportToPage.clickAddRecordsButtonByLabelName("Assigned Supervisors");
		reportToPage.enterNameSupervisor(nameSupervisor1);
		reportToPage.clickItemNameSupervisor1("Ranga");
		reportToPage.selectReportingMethodDropdown(reportingMethodsSupervisor);
		reportToPage.clickSaveButtonAtAddSupervisor();
		Assert.assertTrue(reportToPage.isSuccessMessageDisplayed("Successfully Saved"));
		Assert.assertEquals(reportToPage.getReportingMethodSelectedText(),reportingMethodsSupervisor);
		reportToPage.sleepInSecond(3);
		reportToPage.clickAddRecordsButtonByLabelName("Assigned Subordinates");
		reportToPage.enterNameSupervisor(nameSupervisor2);
		reportToPage.clickItemNameSupervisor2("James");
		reportToPage.selectReportingMethodDropdown("Indirect");
		reportToPage.clickSaveButtonAtAddSupervisor();
		Assert.assertTrue(reportToPage.isSuccessMessageDisplayed("Successfully Saved"));
	}
	
	@Test
	public void Employee_10_Qualifications() {
		reportToPage.clickEmployeeNavigationLinkButton("Qualifications");
		qualificationsPage = PageGeneratorManager.getQualificationsPage(driver);
		qualificationsPage.clickAddRecordsButtonByLabelName("Work Experience");
		qualificationsPage.enterCompanyTextbox(companyName);
		qualificationsPage.enterJobTitleTextbox(jobTitleExp);
		qualificationsPage.enterFromDatePickers(fromDate);
		qualificationsPage.enterToDatePickers(toDate);
		qualificationsPage.enterCommentsTextbox(comment);
		qualificationsPage.clickSaveButton();
		Assert.assertTrue(qualificationsPage.isSuccessMessageDisplayed("Successfully Saved"));
		qualificationsPage.clickAddRecordsButtonByLabelName("Education");
		qualificationsPage.selectLevelDropdown(levelEdu);
		qualificationsPage.enterInstituteTxtbox(institute);
		qualificationsPage.enterMajorTxtbox(major);
		qualificationsPage.enterYearTxtbox(year);
		qualificationsPage.enterScoreTxtbox(score);
		qualificationsPage.enterStartDateDP(startDate);
		qualificationsPage.enterEndDateDP(endDate);
		qualificationsPage.clickSaveButton();
		Assert.assertTrue(qualificationsPage.isSuccessMessageDisplayed("Successfully Saved"));
		Assert.assertEquals(qualificationsPage.getLevelSelectedText(),levelEdu);
		qualificationsPage.clickAddRecordsButtonByLabelName("Skills");
		qualificationsPage.selectSkillDropdown(skillName);
		qualificationsPage.enterYearExpTxtbox(yearOfExp);
		qualificationsPage.clickSaveButton();
		Assert.assertTrue(qualificationsPage.isSuccessMessageDisplayed("Successfully Saved"));
		Assert.assertEquals(qualificationsPage.getSkillSelectedText(),skillName);
		qualificationsPage.clickAddRecordsButtonByLabelName("License");
		qualificationsPage.selectLicenseTypeDropdown(licenseType);
		qualificationsPage.enterLicenseNumberTxtbox(licenseNumber);
		qualificationsPage.enterLicenseIssuedDateDP(licenseIssuedDate);
		qualificationsPage.enterLicenseExpiryDateDP(licenseExpiryDate);
		qualificationsPage.clickSaveButton();
		Assert.assertTrue(qualificationsPage.isSuccessMessageDisplayed("Successfully Saved"));
		Assert.assertEquals(qualificationsPage.getLicenseTypeSelectedText(),licenseType);
		qualificationsPage.clickAddRecordsButtonByLabelName("Languages");
		qualificationsPage.selectLanguageDropdown(language);
		qualificationsPage.selectFluencyDropdown(fluency);
		qualificationsPage.selectCompetencyDropdown(competency);
		qualificationsPage.clickSaveButton();
		Assert.assertTrue(qualificationsPage.isSuccessMessageDisplayed("Successfully Saved"));
		Assert.assertEquals(qualificationsPage.getLanguageSelectedText(),language);
		Assert.assertEquals(qualificationsPage.getCompetencySelectedText(),competency);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
