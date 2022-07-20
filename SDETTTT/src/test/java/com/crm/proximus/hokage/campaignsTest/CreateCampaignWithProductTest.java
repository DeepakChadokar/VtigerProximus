package com.crm.proximus.hokage.campaignsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.proximus.genericUtility.ExcelUtility;
import com.crm.proximus.genericUtility.FileUtility;
import com.crm.proximus.genericUtility.JavaUtility;
import com.crm.proximus.genericUtility.WebDriverUtility;

public class CreateCampaignWithProductTest {

	public static void main(String[] args) throws Throwable{
		FileUtility fu = new FileUtility();
		ExcelUtility excelLib = new ExcelUtility();
		JavaUtility javaLib = new JavaUtility();
		WebDriverUtility wb = new WebDriverUtility();
		
		String url = fu.getPropertyKeyValue("url");
		String uname = fu.getPropertyKeyValue("uname");
		String pwd = fu.getPropertyKeyValue("pwd");
		
		String prodName = excelLib.readDataFromExcel("Sheet2", 1, 3) + javaLib.generateRandomNum();
		
		WebDriver driver = new ChromeDriver();
		wb.waitForElementInDOM(driver);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(uname);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(prodName);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String actProdName = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(actProdName.contains(prodName))
			System.out.println("Product Created Successfully");
		else
			System.out.println("Product Creation Failed");
		//Product Creation Complete
		
		String firstModName = excelLib.readDataFromExcel("Sheet2", 1, 4);
		String secModName = excelLib.readDataFromExcel("Sheet2", 1, 5);
		
		
		String campName = excelLib.readDataFromExcel("Sheet2", 1, 2) + javaLib.generateRandomNum();
		WebElement more = driver.findElement(By.linkText("More"));
		wb.mouseOverOnElement(driver, more);
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campName);
		driver.findElement(By.xpath("//img[@style='cursor:hand;cursor:pointer']")).click();
		wb.swithToWindow(driver, secModName);
		driver.findElement(By.id("search_txt")).sendKeys(prodName);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.linkText(prodName)).click();
		wb.swithToWindow(driver, firstModName);
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();		
		String actCampName = driver.findElement(By.xpath("//span[contains(text(),'Campaign Information')]")).getText();
		if(actCampName.contains(campName))
			System.out.println("---->=>=>Campaign Created Successfully<=<=<----");
		else
			System.out.println("Campain Creation Failed");
		WebElement e = driver.findElement(By.xpath("//td/img[@style='padding: 0px;padding-left:5px']"));
		wb.mouseOverOnElement(driver, e);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
	}

}
