package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.proximus.PomRepository.ContactPage;
import com.crm.proximus.PomRepository.CreateContactPage;
import com.crm.proximus.PomRepository.HomePage;
import com.crm.proximus.PomRepository.LoginPage;
import com.crm.proximus.PomRepository.OrganizationsPage;
import com.crm.proximus.genericUtility.ExcelUtility;

public class ReadDataFromExcelFilesTest {

	public static void main(String[] args) throws Throwable {
////		FileInputStream fis = new FileInputStream("./testdata/testdata.xlsx");
////		Workbook wb = WorkbookFactory.create(fis);
//		String url = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
//		String un = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
//		String pwd = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		ExcelUtility eLib = new ExcelUtility();
		String url = eLib.readDataFromExcel("Sheet1", 1, 1);
		String un = eLib.readDataFromExcel("Sheet1", 1, 2);
		String pwd = eLib.readDataFromExcel("Sheet1", 1, 3);
		WebDriver driver = new ChromeDriver();
		driver.get(url);
//		driver.findElement(By.name("user_name")).sendKeys(un);
//		driver.findElement(By.name("user_password")).sendKeys(pwd);
//		driver.findElement(By.id("submitButton")).click();
		LoginPage lgin = new LoginPage(driver);
		lgin.setLogin(url, un, pwd);
//		Actions a = new Actions(driver);
//		WebElement e = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
//		a.moveToElement(e).perform();
//		driver.findElement(By.linkText("Sign Out")).click();
		HomePage hp = new HomePage(driver);
		hp.setContactsLink();
		ContactPage cp = new ContactPage(driver);
		cp.setCreateContactLink();
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.setLastNameField("John Wick");
		ccp.setSaveBtn();
		hp.setUserPic();
		driver.close();
		
	}

}
