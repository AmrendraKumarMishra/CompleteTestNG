package com.tekPyramid.crm.BaseClassTest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.tek.crm.ObjectRepository.LoginPage;
import com.tek.crm.ObjectRepository.LogoutPage;
import com.tek.crm.databaseUtility.DatabaseUtility;
import com.tek.crm.genericUtility.ExcelUtility;
import com.tek.crm.genericUtility.FileUtility;
import com.tek.crm.genericUtility.UtilityClassObject;
import com.tek.crm.javaUtility.JavaUtility;
import com.tek.crm.webDriverUtility.WebDriverUtility;

@Listeners(com.tekPyramid.crm.ListenerUtility.ListenerImplementationClass.class)
public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public LogoutPage log;
	public DatabaseUtility dbUtil = new DatabaseUtility();
	public FileUtility fUtil = new FileUtility();
	public ExcelUtility eutil = new ExcelUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();

	@BeforeSuite(groups = { "SmokeTesting", "RegressionTesting" })
	public void DataBaseConnconfigBS() throws SQLException {
		System.out.println("==Connect to DB , Report config==");
		dbUtil.getDbConnection("jdbc:mysql://49.249.28.218:3333", "root", "root");

	}

	@Parameters("Browser")
	@BeforeClass(groups = { "SmokeTesting", "RegressionTesting" })
	public void LaunchBrowserconfigBC(@Optional("chrome") String browser) throws IOException {
		System.out.println("==Launch the Browser==");
		String Browser = browser;
		browser = System.getProperty("Browser", fUtil.getDataFromFileUtility("Browser"));

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		UtilityClassObject.setDriver(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String URL = System.getProperty("url", fUtil.getDataFromFileUtility("url"));
//		driver.get(fUtil.getDataFromFileUtility("url"));
		driver.get(URL); // [For command prompt]
	}

	@BeforeMethod(groups = { "SmokeTesting", "RegressionTesting" })
	public void LoginconfigBM() throws IOException {
		System.out.println("===Login===");
		lp = new LoginPage(driver);
		String username = System.getProperty("username", fUtil.getDataFromFileUtility("username"));
		String password = System.getProperty("password", fUtil.getDataFromFileUtility("password"));
		lp.loginToApp(username, password);

	}

	@AfterMethod(groups = { "SmokeTesting", "RegressionTesting" })

	public void LogoutconfigAM() {
		System.out.println("===Logout==");
		log = new LogoutPage(driver);
		log.getLogoutIcon().click();
		log.getLogoutButton().click();
	}

	@AfterClass(groups = { "SmokeTesting", "RegressionTesting" })

	public void CloseBrowserConfigAC() {
		System.out.println("===Close the browser===");
		driver.quit();
	}

	@AfterSuite(groups = { "SmokeTesting", "RegressionTesting" })
	public void CloseDBConnConfigAS() {
		System.out.println("===close db, Repost backup===");
		dbUtil.closeConnection();
	}

}
