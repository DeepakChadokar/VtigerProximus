package com.crm.proximus.genericUtility;
/**
 * This class contains methods regarding webdriver
 * @author Deepak
 *
 */

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public static WebDriver driver;
	static WebDriverWait wait;
	
	/**
	 * this method helps to open the browser
	 * @param brw
	 */
	public void openBrowser(String brw) {
		if(brw.equals("chrome"))
			driver = new ChromeDriver();
		else if(brw.equals("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();
	}
	
	/**
	 * this method is to maximize the browser window
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * method to get to url
	 * @param url
	 */
	public void gotoUrl(String url) {
		driver.get(url);
	}
	
	/**
	 * This method will return target element
	 * @param locatorType
	 * @param locator
	 * @return 
	 */
	public WebElement elementLocator(String locatorType, String locator) {
		WebElement element = null;
		if(locatorType.equals("id")) {
			element = driver.findElement(By.id(locator));
		}
		else if(locatorType.equals("name")) {
			element = driver.findElement(By.name(locator));
		}
		else if(locatorType.equals("xpath")) {
			element = driver.findElement(By.xpath(locator));
		}
		else if(locatorType.equals("link")) {
			element = driver.findElement(By.linkText(locator));
		}
		return element;
	}
	
	/**
	 * this method will enter the data into the field
	 * @param element
	 * @param data
	 */
	public void enterDetail(WebElement element, String data) {
		element.sendKeys(data);
	}
	
	/**
	 * method to click on targetted element
	 * @param element
	 */
	public void clickOnElement(WebElement element) {
		element.click();
	}
	
	/**
	 *   it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 
	 * @param driver
	 */
	public void waitForElementInDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 */
	public void waitForPage(WebDriver driver , String partailPageURL) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlContains(partailPageURL));
	}
	
	/**
	 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 */
	public void waitForElement (WebDriver driver , WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 *  used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void swithToWindow(WebDriver driver , String partialWindowTitle) {
	       Set<String> set = driver.getWindowHandles();
	         Iterator<String> it = set.iterator();

	          while (it.hasNext()) {
			          String wID = it.next();
			          driver.switchTo().window(wID);
			          String currentWindowTitle = driver.getTitle();
			          if(currentWindowTitle.contains(partialWindowTitle)) {
			        	  break;
			          }
		    	}
	}
	/**
	 * used to Switch to Alert Window & click on OK button
	 * @param driver
	 */
	public void swithToAlertWindowAndAccpect(WebDriver driver ,String expectedMsg) {
		Alert alt = driver.switchTo().alert();
		 if(alt.getText().equals(expectedMsg)) {
			 System.out.println("Alert Message is verified");
		 }else {
			 System.out.println("Alert Message is not verified");
		 }
		alt.accept();
	}
	
	
	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * @param driver
	 */
	public void swithToAlertWindowAndCancel(WebDriver driver, String expectedMsg) {
		Alert alt = driver.switchTo().alert();
		 if(alt.getText().equals(expectedMsg)) {
			 System.out.println("Alert Message is verified");
		 }else {
			 System.out.println("Alert Message is not verified");
		 }
		 alt.dismiss();
	}
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver , int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(WebDriver driver , String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * used to select the value from the dropDown  based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element , int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * used to select the value from the dropDwon  based on value / option avlaible in GUI
	 * @param element
	 * @param value
	 */
	public void select(WebElement element , String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void mouseOverOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}
	
	/**
	 * 	 used to right click  on specified element

	 * @param driver
	 * @param elemnet
	 */
	
	public void rightClickOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver , String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
	}
	
	   public void waitAndClick(WebElement element) throws InterruptedException
	   {
		   int count = 0;
	       while(count<20) {
		    	   try {
		    	       element.click();
		    	       break;
		    	   }catch(Throwable e){
		    		   Thread.sleep(1000);
		    		   count++;
		    	   }
	       }
	   }
	   

	    
	    /**
	     * pass enter Key appertain in to Browser
	     * @param driver
	     */
	   public void passEnterKey(WebDriver driver) {
		   Actions act = new Actions(driver);
		   act.sendKeys(Keys.ENTER).perform();
	   } 
	   
	   
	   public void switchWindows(WebDriver driver, String winTitle, Set<String> s) {
		   Iterator<String> it = s.iterator();

	          while (it.hasNext()) {
			          String wID = it.next();
			          driver.switchTo().window(wID);
			          String currentWindowTitle = driver.findElement(By.className("moduleName")).getText();
			          if(currentWindowTitle.equalsIgnoreCase(winTitle)) {
			        	  break;
			          }
		    	}
	}
	   
	   public void takeScreenShotOfFail(WebDriver driver){
		   JavaUtility ju = new JavaUtility();
		   String winTitle = driver.getTitle() + ju.generateRandomNum();
		   TakesScreenshot t = (TakesScreenshot)driver;
		   File src = t.getScreenshotAs(OutputType.FILE);
		   File dest = new File("./ScreenShot/" + winTitle + ".png");
		   try {
			   FileUtils.copyFile(src, dest);
		   }
		   catch(Exception e) {
			   
		   }
	   }
 }


