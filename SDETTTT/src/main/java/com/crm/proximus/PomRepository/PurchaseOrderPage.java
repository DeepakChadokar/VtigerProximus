package com.crm.proximus.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.proximus.genericUtility.WebDriverUtility;

public class PurchaseOrderPage extends WebDriverUtility{
	WebDriver driver;
	
	public PurchaseOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Purchase Order...']")
	private WebElement createPurchaseOrderLink;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement purchOrderNameSearchTF;
	
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement purchOrderSearchBtn;

	public WebElement getCreatePurchaseOrderLink() {
		return createPurchaseOrderLink;
	}

	public void setCreatePurchaseOrderLink() {
		createPurchaseOrderLink.click();
	}

	public WebElement getPurchOrderNameSearchTF() {
		return purchOrderNameSearchTF;
	}

	public void setPurchOrderNameSearchTF(String poName) {
		purchOrderNameSearchTF.sendKeys(poName);
	}

	public WebElement getPurchOrderNameSearchBtn() {
		return purchOrderSearchBtn;
	}

	public void setPurchOrderNameSearchBtn() {
		purchOrderSearchBtn.click();
	}
	
	
	
}
