package commons;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	private WebDriver driver;
	protected final Log log;
	
	@BeforeSuite
	public void initBeforeSuite() {
		deleteAllureReport();
	}
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	//private String projectPath = System.getProperty("user.dir");
	protected WebDriver getBrowserDriver(String browserName) {
		if(browserName.equals("firefox")) {
			//System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setAcceptInsecureCerts(true);
			options.addPreference("intl.accept_languages", "vi-vn,vi,en-us,en");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-geolocation");
			options.addArguments("-private");
			driver = new FirefoxDriver();
		}else if(browserName.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			
			options.addArguments("--lang=vi");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-geolocation");
			//options.addArguments("--incognito"); ẩn danh
			driver = new ChromeDriver(options);
		}
		else {
			throw new RuntimeException("Browser name invalid");
		}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(GlobalConstant.PORTAL_PAGE_URL);
		return driver;
	}
	
	
//	  protected WebDriver getBrowserDriver(String browserName, String environmentName) {
//		  if(browserName.equals("firefox"))
//		  {
//			  driver = new FirefoxDriver();
//		  }
//		  else if(browserName.equals("chrome")){
//			  //System.setProperty("webdriver.chrome.driver", GlobalConstant.PROJECT_PATH + "\\browserDrivers\\chromedriver.exe"); 
//			  driver = new ChromeDriver();
//		  }else {
//			  throw new RuntimeException("Browser name invalid.");
//		  }
//		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//		  driver.get(getEnvironmentUrl(environmentName)); return driver;
//	  }
	 
	
	
	  protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		  if(browserName.equals("firefox")) {
			  driver = new FirefoxDriver(); 
		  }else if(browserName.equals("chrome")) {
			  driver = new ChromeDriver();
		  }else {
			  throw new RuntimeException("Browser name invalid.");
		  }
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  driver.get(appUrl); return driver;
	}
	 	
	public WebDriver getDriverInstance() {
		return this.driver;
	}
	
	protected String getEnvironmentUrl(String serverName) {
		String envUrl = null;
		EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
		
		switch (environment) {
		case DEV:
			envUrl = "https://demo.nopcommerce.com/";
			break;
		case TESTING:
			envUrl = "https://testing.nopcommerce.com/";
			break;
		case STAGING:
			envUrl = "https://staging.nopcommerce.com/";
			break;
		case PRE_PRODUCTION:
			envUrl = "https://pre-prod.nopcommerce.com/";
			break;
		case PRODUCTION:
			envUrl = "https://prod.nopcommerce.com/";
			break;
		default:
			envUrl = null;
			break;
		}
		return envUrl;
	}
	
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			if(condition == true) {
				System.out.println("-----------------PASSED---------------");
			}else {
				System.out.println("-----------------FAILED---------------");
			}
			Assert.assertTrue(condition);
		}catch(Throwable e) {
			pass = false;
			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(),e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			if(condition == false) {
				System.out.println("-----------------PASSED---------------");
			}else {
				System.out.println("-----------------FAILED---------------");
			}
			Assert.assertFalse(condition);
		}catch(Throwable e) {
			pass = false;
			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(),e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			System.out.println("-----------------PASSED---------------");
		}catch(Throwable e) {
			pass = false;
			System.out.println("-----------------FAILED---------------");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(),e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	public void deleteAllureReport() {
		try {
			String pathFolderDownload = GlobalConstant.PROJECT_PATH + "/allure-json";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			if (listOfFiles.length != 0) {
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
						new File(listOfFiles[i].toString()).delete();
					}
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected String getCurrentDate() {
		DateTime nowUTC = new DateTime();
		int day = nowUTC.getDayOfMonth();
		if(day<10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return String.valueOf(day);
	}
	
	protected String getCurrentMonth() {
		DateTime nowUTC = new DateTime();
		int month = nowUTC.getDayOfYear();
		if(month<10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return String.valueOf(month);
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime();
		return String.valueOf(now.getYear());
	}
	
	protected String getCurrentDay() {
		return getCurrentDate() + "/" + getCurrentMonth() + "/" + getCurrentYear();
	}
	
	protected void showBrowserConsoleLogs(WebDriver driver) {
		if(driver.toString().contains("chrome")) {
			LogEntries logs = driver.manage().logs().get("browser");
			List<LogEntry> logList = logs.getAll();
			for(LogEntry logging:logList) {
				log.info("------------"+ logging.getLevel().toString()+"-------------\n"+logging.getMessage());
			}
		}
	}
}
