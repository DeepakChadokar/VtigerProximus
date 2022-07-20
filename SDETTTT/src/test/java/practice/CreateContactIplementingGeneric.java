package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crm.proximus.genericUtility.ExcelUtility;
import com.crm.proximus.genericUtility.FileUtility;
import com.crm.proximus.genericUtility.JavaUtility;
import com.crm.proximus.genericUtility.WebDriverUtility;

public class CreateContactIplementingGeneric {

	public static void main(String[] args) throws Throwable {
		FileUtility fu = new FileUtility();
		ExcelUtility excelLib = new ExcelUtility();
		JavaUtility javaLib = new JavaUtility();
		WebDriverUtility wb = new WebDriverUtility();
		
		
		String browser = fu.getPropertyKeyValue("browser");
		String url = fu.getPropertyKeyValue("url");
		String un = fu.getPropertyKeyValue("uname");
		String pwd = fu.getPropertyKeyValue("pwd");
		
		String data = excelLib.readDataFromExcel("Sheet2", 1, 0) + javaLib.generateRandomNum();
		
		
		wb.openBrowser(browser);
		wb.waitForElementInDOM(WebDriverUtility.driver);
		wb.gotoUrl(url);
		WebElement unField = wb.elementLocator("name", "user_name");
		wb.enterDetail(unField, un);
		WebElement pwdField = wb.elementLocator("name", "user_password");
		wb.enterDetail(pwdField, pwd);
		WebElement loginButton = wb.elementLocator("id", "submitButton");
		wb.clickOnElement(loginButton);
		
		wb.elementLocator("link", "Contacts").click();
		wb.elementLocator("xpath", "//img[@title='Create Contact...']").click();
		wb.elementLocator("name", "lastname").sendKeys(data);
		wb.elementLocator("xpath", "(//input[@title='Save [Alt+S]'])[1]").click();
		String actContName = wb.elementLocator("xpath", "//span[contains(text(),'Contact Information')]").getText();
		if(actContName.contains(data))
			System.out.println("contact created successfully");
		else
			System.out.println("contact creation failed");
		WebElement signOut = wb.elementLocator("xpath", "//td/img[@style='padding: 0px;padding-left:5px']");
		wb.mouseOverOnElement(WebDriverUtility.driver, signOut);
		wb.elementLocator("link", "Sign Out").click();
		WebDriverUtility.driver.close();
		
	}

}
