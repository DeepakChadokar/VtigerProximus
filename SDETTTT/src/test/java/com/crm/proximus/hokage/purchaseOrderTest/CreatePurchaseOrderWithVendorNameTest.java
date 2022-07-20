package com.crm.proximus.hokage.purchaseOrderTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.proximus.PomRepository.CreatePurchaseOrderPage;
import com.crm.proximus.PomRepository.HomePage;
import com.crm.proximus.PomRepository.LoginPage;
import com.crm.proximus.PomRepository.PurchaseOrderInformationPage;
import com.crm.proximus.PomRepository.PurchaseOrderPage;
import com.crm.proximus.genericUtility.BaseClass;
import com.crm.proximus.genericUtility.ExcelUtility;
import com.crm.proximus.genericUtility.FileUtility;
import com.crm.proximus.genericUtility.JavaUtility;
import com.crm.proximus.genericUtility.WebDriverUtility;

public class CreatePurchaseOrderWithVendorNameTest extends BaseClass {
	
	@Test
	public void createPurchaseOrderWithVendorNameTest() throws Throwable{
		HomePage hp = new HomePage(driver);
		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		CreatePurchaseOrderPage cpop = new CreatePurchaseOrderPage(driver);
		PurchaseOrderInformationPage poip = new PurchaseOrderInformationPage(driver);
		String vName = exLib.readDataFromExcel("Sheet3", 1, 0);
		String  sub = exLib.readDataFromExcel("Sheet3", 1, 1) + jLib.generateRandomNum();
		String add = exLib.readDataFromExcel("Sheet3", 1, 2);
		String prodName = exLib.readDataFromExcel("Sheet3", 1, 3);
		String m1Name = exLib.readDataFromExcel("Sheet3", 1, 4);
		String m2Name = exLib.readDataFromExcel("Sheet3", 1, 5);
		String m3Name = exLib.readDataFromExcel("Sheet3", 1, 6);
		
		hp.setMoreLink();
		hp.setPurchaseOrderLink();
		pop.setCreatePurchaseOrderLink();
		cpop.setPurchaseOrderNameTF(sub);
		cpop.setAddVendorNameImg(m2Name, m3Name, vName);
		cpop.setBillingAddressTf(add);
		cpop.setCopyBillingAddRadioBtn();
		cpop.setSearchProductImg(m1Name, m3Name, prodName);
		cpop.setQuantityTf("2");
		cpop.setSaveBtn();
		poip.setnameOfPurchaseOrder(sub);
	}
	
	@Test
	public void createPurchaseOrderWithVendorAndCoontactName() throws Throwable{
		String vName = exLib.readDataFromExcel("Sheet3", 1, 0);
		String  sub = exLib.readDataFromExcel("Sheet3", 1, 1) + jLib.generateRandomNum();
		String add = exLib.readDataFromExcel("Sheet3", 1, 2);
		String prodName = exLib.readDataFromExcel("Sheet3", 1, 3);
		String contName = exLib.readDataFromExcel("Sheet2", 1, 0);
		String m1Name = exLib.readDataFromExcel("Sheet3", 1, 4);
		String m2Name = exLib.readDataFromExcel("Sheet3", 1, 5);
		String m3Name = exLib.readDataFromExcel("Sheet3", 1, 6);
		String m4Name = exLib.readDataFromExcel("Sheet3", 1, 7);
		
		HomePage hp = new HomePage(driver);
		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		CreatePurchaseOrderPage cpop = new CreatePurchaseOrderPage(driver);
		PurchaseOrderInformationPage poip = new PurchaseOrderInformationPage(driver);
		
		hp.setMoreLink();
		hp.setPurchaseOrderLink();
		pop.setCreatePurchaseOrderLink();
		cpop.setPurchaseOrderNameTF(sub);
		cpop.setAddVendorNameImg(m2Name, m3Name, vName);
		cpop.setAddContactNameImg(m4Name, m3Name, contName);
		cpop.setBillingAddressTf(add);
		cpop.setCopyBillingAddRadioBtn();
		cpop.setSearchProductImg(m1Name, m3Name, prodName);
		cpop.setQuantityTf("4");
		cpop.setSaveBtn();
		poip.setnameOfPurchaseOrder(sub);
	}

//	public static void main(String[] args) throws Throwable {
////		FileUtility fu = new FileUtility();
////		ExcelUtility excelLib = new ExcelUtility();
////		JavaUtility javaLib = new JavaUtility();
////		WebDriverUtility wb = new WebDriverUtility();
////		
////		//Reading the data from External resource files
////		String url = fu.getPropertyKeyValue("url");
////		String uname = fu.getPropertyKeyValue("uname");
////		String pwd = fu.getPropertyKeyValue("pwd");
////		
////		String vName = excelLib.readDataFromExcel("Sheet3", 1, 0) + javaLib.generateRandomNum();
////		String  sub = excelLib.readDataFromExcel("Sheet3", 1, 1) + javaLib.generateRandomNum();
////		String add = excelLib.readDataFromExcel("Sheet3", 1, 2) + javaLib.generateRandomNum();
////		String prodName = excelLib.readDataFromExcel("Sheet3", 1, 3) + javaLib.generateRandomNum();
////		String m1Name = excelLib.readDataFromExcel("Sheet3", 1, 4);
////		String m2Name = excelLib.readDataFromExcel("Sheet3", 1, 5);
////		String m3Name = excelLib.readDataFromExcel("Sheet3", 1, 6);
////		
////		//Browser opening and logging in
////		WebDriver driver = new ChromeDriver();
////		wb.maximizeWindow(driver);
////		wb.waitForElementInDOM(driver);
////		driver.get(url);
////		driver.findElement(By.name("user_name")).sendKeys(uname);
////		driver.findElement(By.name("user_password")).sendKeys(pwd);
////		driver.findElement(By.id("submitButton")).click();
////		
////		//Creating Product
////		driver.findElement(By.linkText("Products")).click();
////		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
////		driver.findElement(By.name("productname")).sendKeys(prodName);
////		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
////		String actProdName = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
////		if(actProdName.contains(prodName))
////			System.out.println("Product Created Successfully");
////		else
////			System.out.println("Product Creation Failed");
////		
////		//Creating Vendor
////		WebElement more = driver.findElement(By.linkText("More"));
////		wb.mouseOverOnElement(driver, more);
////		driver.findElement(By.linkText("Vendors")).click();
////		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
////		driver.findElement(By.name("vendorname")).sendKeys(vName);
////		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
////		String actVendName = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
////		if(actVendName.contains(vName))
////			System.out.println("Vendor Created Successfully");
////		else
////			System.out.println("Vendor Creation Failed");
////		
////		//Creating Purchase Order
////		WebElement more1 = driver.findElement(By.linkText("More"));
////		wb.mouseOverOnElement(driver, more1);
////		driver.findElement(By.linkText("Purchase Order")).click();
////		driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();
////		driver.findElement(By.name("subject")).sendKeys(sub);
////		driver.findElement(By.xpath("//img[@onclick='return window.open(\"index.php?module=Vendors&action=Popup&html=Popup_picker&popuptype=specific_vendor_address&form=EditView&fromlink=\",\"test\",\"width=640,height=602,resizable=0,scrollbars=0\");']")).click();
////		wb.swithToWindow(driver, m2Name);
////		driver.findElement(By.id("search_txt")).sendKeys(vName);
////		driver.findElement(By.xpath("//input[@name='search']")).click();
////		driver.findElement(By.linkText(vName)).click();
////		
////		wb.swithToWindow(driver, m3Name);
////		driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(add);
////		driver.findElement(By.xpath("//input[@onclick='return copyAddressRight(EditView)']")).click();
////		driver.findElement(By.id("searchIcon1")).click();
////		wb.swithToWindow(driver, m1Name);
////		driver.findElement(By.id("search_txt")).sendKeys(prodName);
////		driver.findElement(By.xpath("//input[@name='search']")).click();
////		driver.findElement(By.linkText(prodName)).click();
////		wb.swithToWindow(driver, m3Name);
////		driver.findElement(By.id("qty1")).sendKeys("1");
////		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();		
////		String actSub = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
////		if(actSub.contains(sub))
////			System.out.println("---->=>=>Order Created Successfully<=<=<----");
////		else
////			System.out.println("Order Creation Failed");
////		WebElement e = driver.findElement(By.xpath("//td/img[@style='padding: 0px;padding-left:5px']"));
////		wb.mouseOverOnElement(driver, e);
////		driver.findElement(By.linkText("Sign Out")).click();
////		driver.close();
//		
//		FileUtility fu = new FileUtility();
//		ExcelUtility excelLib = new ExcelUtility();
//		JavaUtility javaLib = new JavaUtility();
//		WebDriverUtility wb = new WebDriverUtility();
//		
//		WebDriver driver = new ChromeDriver();
//		wb.waitForElementInDOM(driver);
//		
//		LoginPage lp = new LoginPage(driver);
//		HomePage hp = new HomePage(driver);
//		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
//		CreatePurchaseOrderPage cpop = new CreatePurchaseOrderPage(driver);
//		PurchaseOrderInformationPage poip = new PurchaseOrderInformationPage(driver);
//		
//		String url = fu.getPropertyKeyValue("url");
//		String uname = fu.getPropertyKeyValue("uname");
//		String pwd = fu.getPropertyKeyValue("pwd");
//		
//		String vName = excelLib.readDataFromExcel("Sheet3", 1, 0);
//		String  sub = excelLib.readDataFromExcel("Sheet3", 1, 1) + javaLib.generateRandomNum();
//		String add = excelLib.readDataFromExcel("Sheet3", 1, 2);
//		String prodName = excelLib.readDataFromExcel("Sheet3", 1, 3);
//		String m1Name = excelLib.readDataFromExcel("Sheet3", 1, 4);
//		String m2Name = excelLib.readDataFromExcel("Sheet3", 1, 5);
//		String m3Name = excelLib.readDataFromExcel("Sheet3", 1, 6);
//		
//		lp.setLogin(url, uname, pwd);
//		
//		hp.setMoreLink();
//		hp.setPurchaseOrderLink();
//		pop.setCreatePurchaseOrderLink();
//		cpop.setPurchaseOrderNameTF(sub);
//		cpop.setAddVendorNameImg(m2Name, m3Name, vName);
//		cpop.setBillingAddressTf(add);
//		cpop.setCopyBillingAddRadioBtn();
//		cpop.setSearchProductImg(m1Name, m3Name, prodName);
//		cpop.setQuantityTf("2");
//		cpop.setSaveBtn();
//		poip.setnameOfPurchaseOrder(sub);
//		hp.setUserPic();
//		driver.close();
//	}

}
