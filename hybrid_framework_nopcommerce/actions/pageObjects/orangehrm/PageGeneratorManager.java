package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static AddEmployeePageObject getEmployeePage(WebDriver driver) {
		return new AddEmployeePageObject(driver);
	}
	
	public static ContactDetailPageObject getContactDetailsPage(WebDriver driver) {
		return new ContactDetailPageObject(driver);
	}
	
	public static DashboardPageObject getDashboardPage(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	
	public static DependenciesPageObject getDependentsPage(WebDriver driver) {
		return new DependenciesPageObject(driver);
	}
	
	public static EmployeeListPageObject getEmployeeListPage(WebDriver driver) {
		return new EmployeeListPageObject(driver);
	}
	
	public static EmergencyContactPageObject getEmergencyContactPage(WebDriver driver) {
		return new EmergencyContactPageObject(driver);
	}
	
	public static ImigrationPageObject getImigrationPage(WebDriver driver) {
		return new ImigrationPageObject(driver);
	}
	
	public static JobPageObject getJobPage(WebDriver driver) {
		return new JobPageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static PersonalDetailPageObject getPersonalDetailPage(WebDriver driver) {
		return new PersonalDetailPageObject(driver);
	}
	
	public static ReportToPageObject getReportToPage(WebDriver driver) {
		return new ReportToPageObject(driver);
	}
	
	public static SalaryPageObject getSalaryPage(WebDriver driver) {
		return new SalaryPageObject(driver);
	}


}
