package com.crm.proximus.genericUtility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.crm.proximus.PomRepository.HomePage;
import com.crm.proximus.PomRepository.LoginPage;

public class BaseClass {
	
	public static WebDriver driver;
	
	public FileUtility fLib = new FileUtility();
	public ExcelUtility exLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public DatabaseUtility dLib = new DatabaseUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	
	@BeforeSuite(groups = {"regression", "smoke"})
	public void connectToDatabase() throws Throwable {
		System.out.println("=======> Connected to Database <=======");
		//dLib.connectToDatabase();
	}
	
	@AfterSuite(groups = {"regression", "smoke"})
	public void closeConnectionToDatabase() throws Throwable {
		System.out.println("-------> Database Connection Closed <-------");
		//dLib.closeDB();
	}
	
//	@Parameters("Browser")
//	@BeforeClass(groups = {"regression", "smoke"})
	@BeforeClass(alwaysRun = true)
	public void openBrowser() throws Throwable {
		Reporter.log("open browser", true);
		String Browser = fLib.getPropertyKeyValue("browser");
		if(Browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(Browser.equalsIgnoreCase("firefox"))
			driver= new FirefoxDriver();
		else
			driver = new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.waitForElementInDOM(driver);
	}
	
	//@AfterClass(groups = {"regression", "smoke"})
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		Reporter.log("close browser");
		driver.close();
	}
	
	//@BeforeMethod(groups = {"regression", "smoke"})
	@BeforeMethod(alwaysRun = true)
	public void loginToVtiger() throws Throwable {
		String url = fLib.getPropertyKeyValue("url");
		String un = fLib.getPropertyKeyValue("uname");
		String pwd = fLib.getPropertyKeyValue("pwd");
		LoginPage lp = new LoginPage(driver);
		lp.setLogin(url, un, pwd);
		Reporter.log("Logged in", true);
	}
	
	//@AfterMethod(groups = {"regression", "smoke"})
	@AfterMethod(alwaysRun = true)
	public void logoutOfVtiger() {
		HomePage hp = new HomePage(driver);
		hp.setUserPic();
	}
}
