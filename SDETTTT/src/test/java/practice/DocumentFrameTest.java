package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.proximus.PomRepository.LoginPage;
import com.crm.proximus.genericUtility.ExcelUtility;
import com.crm.proximus.genericUtility.FileUtility;
import com.crm.proximus.genericUtility.JavaUtility;
import com.crm.proximus.genericUtility.WebDriverUtility;

public class DocumentFrameTest {
	
	public static void main(String[] args) throws Throwable 
	{
		WebDriverUtility wb=new WebDriverUtility();
		JavaUtility ja= new JavaUtility();
		FileUtility fi=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriver driver = new ChromeDriver();
		LoginPage lg = new LoginPage(driver);
		
		String url = eLib.readDataFromExcel("Sheet1", 1, 1);
		String un = eLib.readDataFromExcel("Sheet1", 1, 2);
		String pwd = eLib.readDataFromExcel("Sheet1", 1, 3);
	
		driver.get(url);
		wb.maximizeWindow(driver);
		wb.waitForElementInDOM(driver);
		driver.get(url);
		lg.setLogin(url, un, pwd);
		driver.findElement(By.xpath("//a[text()='Documents']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Document...']")).click();
		driver.findElement(By.name("notes_title")).sendKeys("product");
		//wb.swithToFrame(driver, 0);
		wb.swithToFrame(driver, 0);
		driver.findElement(By.xpath("//body[@class='cke_show_borders']")).sendKeys("abcd");
		
	
		

	}

}
