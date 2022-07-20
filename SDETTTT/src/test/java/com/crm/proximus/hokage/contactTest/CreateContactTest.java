package com.crm.proximus.hokage.contactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.proximus.PomRepository.ContactInformationPage;
import com.crm.proximus.PomRepository.ContactPage;
import com.crm.proximus.PomRepository.CreateContactPage;
import com.crm.proximus.PomRepository.HomePage;
import com.crm.proximus.PomRepository.LoginPage;
import com.crm.proximus.genericUtility.BaseClass;
import com.crm.proximus.genericUtility.ExcelUtility;
import com.crm.proximus.genericUtility.FileUtility;
import com.crm.proximus.genericUtility.JavaUtility;
import com.crm.proximus.genericUtility.WebDriverUtility;

public class CreateContactTest extends BaseClass{
	
	@Test
	public void createCustomerTest() throws Throwable {
		String data = exLib.readDataFromExcel("Sheet2", 1, 0) + jLib.generateRandomNum();
		HomePage hp = new HomePage(driver);
		hp.setContactsLink();
		ContactPage cp =new ContactPage(driver);
		cp.setCreateContactLink();
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.setLastNameField(data);
		ccp.setSaveBtn();
		ContactInformationPage cip = new ContactInformationPage(driver);
		cip.setNameOfContact(data);
		Reporter.log("Customer Created", true);
	}
	
	@Test
	public void createCustomerAndDeleteTest() throws Throwable {
		String data = exLib.readDataFromExcel("Sheet2", 1, 0) + jLib.generateRandomNum();
		HomePage hp = new HomePage(driver);
		hp.setContactsLink();
		ContactPage cp =new ContactPage(driver);
		cp.setCreateContactLink();
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.setLastNameField(data);
		ccp.setSaveBtn();
		ContactInformationPage cip = new ContactInformationPage(driver);
		cip.setNameOfContact(data);
		cip.setDeleteBtn();
		cp.setSearchContact(data);
		cp.setSearchBtn();
		cp.setVerifyDeletion();
	}
	
//	public static void main(String[] args) throws Throwable {
//		FileInputStream fis = new FileInputStream("./testdata/commondata.properties");
//		Properties pro = new Properties();
//		pro.load(fis);
//		String url = pro.getProperty("url");
//		String uname = pro.getProperty("uname");
//		String pwd = pro.getProperty("pwd");
//		FileInputStream fis2 = new FileInputStream("./testdata/testdata.xlsx");
//		Workbook wb = WorkbookFactory.create(fis2);
//		String lastName = wb.getSheet("Sheet2").getRow(1).getCell(0).getStringCellValue();
//		Random ran = new Random();
//		int ranNum = ran.nextInt(10000);
//		lastName = lastName + ranNum;
//		System.out.println(lastName);
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get(url);
//		driver.findElement(By.name("user_name")).sendKeys(uname);
//		driver.findElement(By.name("user_password")).sendKeys(pwd);
//		driver.findElement(By.id("submitButton")).click();
//		driver.findElement(By.linkText("Contacts")).click();
//		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//		driver.findElement(By.name("lastname")).sendKeys(lastName);
//		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
//		String actLastName = driver.findElement(By.xpath("//span[contains(text(),'Contact Information')]")).getText();
//		if(actLastName.contains(lastName))
//			System.out.println("TestCase Passed");
//		else
//			System.out.println("TestCase Failed");
//		Actions a = new Actions(driver);
//		WebElement e = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
//		a.moveToElement(e).perform();
//		driver.findElement(By.linkText("Sign Out")).click();
//		driver.close();
//		FileUtility fLib = new FileUtility();
//		ExcelUtility exLib = new ExcelUtility();
//		JavaUtility jLib = new JavaUtility();
//		WebDriverUtility wLib = new WebDriverUtility();
//		
//		WebDriver driver = new ChromeDriver();
//		LoginPage lp = new LoginPage(driver);
//		HomePage hp = new HomePage(driver);
//		ContactPage cp = new ContactPage(driver);
//		CreateContactPage ccp = new CreateContactPage(driver);
//		ContactInformationPage cip = new  ContactInformationPage(driver);
//		
//		String url = fLib.getPropertyKeyValue("url");
//		String un = fLib.getPropertyKeyValue("uname");
//		String pwd = fLib.getPropertyKeyValue("pwd");
//		
//		String lName = exLib.readDataFromExcel("Sheet2", 1, 0) + jLib.generateRandomNum();
//		
//		wLib.maximizeWindow(driver);
//		
//		lp.setLogin(url, un, pwd);
//		
//		hp.setContactsLink();
//		
//		cp.setCreateContactLink();
//		
//		ccp.setLastNameField(lName);
//		ccp.setSaveBtn();
//		cip.setNameOfContact(lName);
//		
//		hp.setUserPic();
//		driver.close();
//		
//		
//		
//	
//	}

}
