package com.crm.proximus.hokage.contactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.proximus.PomRepository.ContactInformationPage;
import com.crm.proximus.PomRepository.ContactPage;
import com.crm.proximus.PomRepository.CreateContactPage;
import com.crm.proximus.PomRepository.HomePage;
import com.crm.proximus.PomRepository.LoginPage;
import com.crm.proximus.genericUtility.ExcelUtility;
import com.crm.proximus.genericUtility.FileUtility;
import com.crm.proximus.genericUtility.JavaUtility;
import com.crm.proximus.genericUtility.WebDriverUtility;

public class CreateAndDeleteContactTest {

	public static void main(String[] args) throws Throwable{
		FileUtility fu = new FileUtility();
		ExcelUtility excelLib = new ExcelUtility();
		JavaUtility javaLib = new JavaUtility();
		WebDriverUtility wb = new WebDriverUtility();
		
		WebDriver driver = new ChromeDriver();		
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		ContactPage cp = new ContactPage(driver);
		CreateContactPage ccp = new CreateContactPage(driver);
		ContactInformationPage cip = new ContactInformationPage(driver);
		
		String url = fu.getPropertyKeyValue("url");
		String uname = fu.getPropertyKeyValue("uname");
		String pwd = fu.getPropertyKeyValue("pwd");
		String lastName = excelLib.readDataFromExcel("Sheet2", 1, 0) + javaLib.generateRandomNum();
		
		wb.waitForElementInDOM(driver);
//		driver.get(url);
//		driver.findElement(By.name("user_name")).sendKeys(uname);
//		driver.findElement(By.name("user_password")).sendKeys(pwd);
//		driver.findElement(By.id("submitButton")).click();
		lp.setLogin(url, uname, pwd);
//		driver.findElement(By.linkText("Contacts")).click();
		hp.setContactsLink();
//		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		cp.setCreateContactLink();
//		driver.findElement(By.name("lastname")).sendKeys(lastName);
		ccp.setLastNameField(lastName);
//		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		ccp.setSaveBtn();
//		driver.findElement(By.xpath("(//input[@title='Delete [Alt+D]'])[1]")).click();
		cip.setDeleteBtn();
//		wb.swithToAlertWindowAndAccpect(driver, "Are you sure you want to delete this record?");
//		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(lastName);
//		WebElement w = driver.findElement(By.id("bas_searchfield"));
//		wb.select(w, 1);
//		driver.findElement(By.xpath("//input[@name='submit']")).click();
//		String msg = driver.findElement(By.xpath("//span[contains(text(),'No Contact Found')]")).getText();
//		if(msg.contains("No Contact Found"))
//			System.out.println("Contact Deleted Successfully");
//		else
//			System.out.println("Contact Deletion Failed");
		cp.setSearchContact(lastName);
		cp.setSearchBtn();
		cp.setVerifyDeletion();
//		WebElement e = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
//		wb.mouseOverOnElement(driver, e);
//		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		
		

	}

}
