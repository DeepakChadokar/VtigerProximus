package com.crm.proximus.hokage.campaignsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.proximus.PomRepository.CampaignPage;
import com.crm.proximus.PomRepository.CreateeCampaignPage;
import com.crm.proximus.PomRepository.HomePage;
import com.crm.proximus.PomRepository.LoginPage;
import com.crm.proximus.genericUtility.ExcelUtility;
import com.crm.proximus.genericUtility.FileUtility;
import com.crm.proximus.genericUtility.JavaUtility;
import com.crm.proximus.genericUtility.WebDriverUtility;

public class CreateCampaignTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fu = new FileUtility();
		ExcelUtility excelLib = new ExcelUtility();
		JavaUtility javaLib = new JavaUtility();
		WebDriverUtility wb = new WebDriverUtility();
		
		String url = fu.getPropertyKeyValue("url");
		String uname = fu.getPropertyKeyValue("uname");
		String pwd = fu.getPropertyKeyValue("pwd");
		
		String campName = excelLib.readDataFromExcel("Sheet2", 1, 2) + javaLib.generateRandomNum();
		
		WebDriver driver = new ChromeDriver();
		LoginPage lp =new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		CampaignPage cp =new CampaignPage(driver);
		CreateeCampaignPage ccp = new CreateeCampaignPage(driver);
		wb.waitForElementInDOM(driver);
		lp.setLogin(url, uname, pwd);
		hp.setMoreLink();
		hp.setCampaignsLink();
		cp.setCreateCampaignLink();
		ccp.setCampaignNameField(campName);
		ccp.setSaveBtn();
		hp.setUserPic();
		driver.close();
//		driver.get(url);
//		driver.findElement(By.name("user_name")).sendKeys(uname);
//		driver.findElement(By.name("user_password")).sendKeys(pwd);
//		driver.findElement(By.id("submitButton")).click();
//		WebElement more = driver.findElement(By.linkText("More"));
//		wb.mouseOverOnElement(driver, more);
//		driver.findElement(By.linkText("Campaigns")).click();
//		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
//		driver.findElement(By.name("campaignname")).sendKeys(campName);
//		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
//		String actCampName = driver.findElement(By.xpath("//span[contains(text(),'Campaign Information')]")).getText();
//		if(actCampName.contains(campName))
//			System.out.println("---->=>=>Campaign Created Successfully<=<=<----");
//		else
//			System.out.println("Campain Creation Failed");
//		WebElement e = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
//		wb.mouseOverOnElement(driver, e);
//		driver.findElement(By.linkText("Sign Out")).click();
//		driver.close();
	}

	
}
