package com.crm.proximus.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.proximus.genericUtility.WebDriverUtility;

public class ProductPage extends WebDriverUtility{
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createProductLink;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement productNameSearchTF;
	
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement productNameSearchBtn;

	public WebElement getCreateProductLink() {
		return createProductLink;
	}

	public void setCreateProductLink() {
		createProductLink.click();
	}

	public WebElement getProductNameSearchTF() {
		return productNameSearchTF;
	}

	public void setProductNameSearchTF(String prodName) {
		productNameSearchTF.sendKeys(prodName);
	}

	public WebElement getProductNameSearchBtn() {
		return productNameSearchBtn;
	}

	public void setProductNameSearchBtn() {
		productNameSearchBtn.click();
	}
	
	

}
