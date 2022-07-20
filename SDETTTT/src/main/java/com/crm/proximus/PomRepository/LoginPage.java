package com.crm.proximus.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.proximus.genericUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{
	WebDriver driver;
	@FindBy(name="user_name")
	private WebElement untbx;
	
	@FindBy(name="user_password")
	private WebElement pwdTbx;
	
	@FindBy(id="submitButton")
	private WebElement logInBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getUntbx() {
		return untbx;
	}


	public WebElement getPwdTbx() {
		return pwdTbx;
	}


	public WebElement getLogInBtn() {
		return logInBtn;
	}


	public void setLogin(String url, String un,String pw) {
		driver.get(url);
		untbx.sendKeys(un);
		pwdTbx.sendKeys(pw);
		logInBtn.click();
	}
}
