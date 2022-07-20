package com.crm.proximus.hokage.organizationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.proximus.PomRepository.CreateOrganizationPage;
import com.crm.proximus.PomRepository.HomePage;
import com.crm.proximus.PomRepository.LoginPage;
import com.crm.proximus.PomRepository.OrganizationInfoPage;
import com.crm.proximus.PomRepository.OrganizationsPage;
import com.crm.proximus.genericUtility.BaseClass;
import com.crm.proximus.genericUtility.ExcelUtility;
import com.crm.proximus.genericUtility.FileUtility;
import com.crm.proximus.genericUtility.JavaUtility;
import com.crm.proximus.genericUtility.WebDriverUtility;

public class CreateOrganizationTest extends BaseClass {
	
	@Test
	public void createOrganizationTest() throws Throwable {
		String orgName = exLib.readDataFromExcel("Sheet2", 1, 1) + jLib.generateRandomNum();
		HomePage hp = new HomePage(driver);
		hp.setOrganizationLink();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.setCreateOrganizationLink();
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.setOrgName(orgName);
		cop.setIndustryListBox("Government");
		cop.setSaveBtn();
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.setHeaderText(orgName);
	}

//	public static void main(String[] args) throws Throwable {
//		FileUtility fileLib = new FileUtility();
//		ExcelUtility excelLib = new ExcelUtility();
//		JavaUtility javaLib = new JavaUtility();
//		WebDriverUtility wb = new WebDriverUtility();
//		
//		WebDriver driver = new ChromeDriver();
//		LoginPage lp = new LoginPage(driver);
//		HomePage hp = new HomePage(driver);
//		OrganizationsPage op = new OrganizationsPage(driver);
//		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
//		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
//		
//		String url = fileLib.getPropertyKeyValue("url");
//		String uname = fileLib.getPropertyKeyValue("uname");
//		String pwd = fileLib.getPropertyKeyValue("pwd");
//		String orgName = excelLib.readDataFromExcel("Sheet2", 1, 1) + javaLib.generateRandomNum();
//		
//		wb.waitForElementInDOM(driver);
////		driver.get(url);
////		driver.findElement(By.name("user_name")).sendKeys(uname);
////		driver.findElement(By.name("user_password")).sendKeys(pwd);
////		driver.findElement(By.id("submitButton")).click();
//		lp.setLogin(url, uname, pwd);
////		driver.findElement(By.linkText("Organizations")).click();
////		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//		hp.setOrganizationLink();
//		op.setCreateOrganizationLink();
////		driver.findElement(By.name("accountname")).sendKeys(orgName);
////		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
//		cop.setOrgName(orgName);
//		cop.setIndustryListBox("Technology");
//		cop.setSaveBtn();
////		String actOrgName = driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]")).getText();
////		if(actOrgName.contains(orgName))
////			System.out.println("TestCase Passed");
////		else
////			System.out.println("TestCase Failed");
////		WebElement e = driver.findElement(By.xpath("//td/img[@style='padding: 0px;padding-left:5px']"));
////		wb.mouseOverOnElement(driver, e);
////		driver.findElement(By.linkText("Sign Out")).click();
//		oip.setHeaderText(orgName);
//		hp.setUserPic();
//		driver.close();
//
//	}

}
