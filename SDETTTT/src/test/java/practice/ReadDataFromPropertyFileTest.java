package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDataFromPropertyFileTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./testdata/commondata.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String browser = pro.getProperty("browser");
		WebDriver driver;
		if(browser.equals("chrome"))
			driver = new ChromeDriver();
		else
			driver = new FirefoxDriver();
		
		String url = pro.getProperty("url");
		String uname = pro.getProperty("uname");
		String pwd = pro.getProperty("pwd");
		//WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(uname);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
	}

}

