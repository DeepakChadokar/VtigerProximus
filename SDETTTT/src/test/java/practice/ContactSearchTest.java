package practice;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.proximus.PomRepository.ContactPage;
import com.crm.proximus.PomRepository.HomePage;
import com.crm.proximus.PomRepository.LoginPage;
import com.crm.proximus.genericUtility.FileUtility;
import com.crm.proximus.genericUtility.WebDriverUtility;

public class ContactSearchTest {

	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter contact id:");
		String conid = sc.nextLine();
		WebDriverUtility wb = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		WebDriver driver = new ChromeDriver();
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		ContactPage cp = new ContactPage(driver);
		
		String url = fLib.getPropertyKeyValue("url");
		String un = fLib.getPropertyKeyValue("uname");
		String pwd = fLib.getPropertyKeyValue("pwd");
		
		lp.setLogin(url, un, pwd);
		hp.setContactsLink();
		cp.setSearchContact(conid);
		cp.setSearchBtn();
		//cp.setVerifyDeletion();
		cp.setNameFound();
		
	}

}
