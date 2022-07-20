package com.crm.proximus.hokage.contactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.proximus.PomRepository.ContactPage;
import com.crm.proximus.PomRepository.CreateContactPage;
import com.crm.proximus.PomRepository.HomePage;
import com.crm.proximus.PomRepository.LoginPage;
import com.crm.proximus.genericUtility.ExcelUtility;
import com.crm.proximus.genericUtility.FileUtility;
import com.crm.proximus.genericUtility.JavaUtility;
import com.crm.proximus.genericUtility.WebDriverUtility;

public class CreateContactWithOrganizationTest {

	public static void main(String[] args) throws Throwable {
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility exLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		
		WebDriver driver = new ChromeDriver();		
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		ContactPage cp = new ContactPage(driver);
		CreateContactPage ccp = new CreateContactPage(driver);
		
		wLib.maximizeWindow(driver);
		
		String url = fLib.getPropertyKeyValue("url");
		String un = fLib.getPropertyKeyValue("uname");
		String pwd = fLib.getPropertyKeyValue("pwd");
		
		String lName = exLib.readDataFromExcel("Sheet2", 1, 0) + jLib.generateRandomNum();
		String orgName = exLib.readDataFromExcel("Sheet2", 1, 1);
		String m1Name = exLib.readDataFromExcel("Sheet2", 1, 6);
		String m2Name = exLib.readDataFromExcel("Sheet2", 1, 7);
		
		lp.setLogin(url, un, pwd);
		
		hp.setContactsLink();
		
		cp.setCreateContactLink();
		
		ccp.setLastNameField(lName);
		ccp.setAddOrganizationImg(orgName, m1Name, m2Name);
		ccp.setSaveBtn();
		
		hp.setUserPic();
		driver.close();
		
		
	}

}
