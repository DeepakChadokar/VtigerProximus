package com.crm.proximus.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.proximus.genericUtility.WebDriverUtility;

public class CreateProductPage extends WebDriverUtility{
	WebDriver driver;
	
	public CreateProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname")
	private WebElement productNameTF;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;

	public WebElement getProductNameTF() {
		return productNameTF;
	}

	public void setProductNameTF(String prodName) {
		productNameTF.sendKeys(prodName);
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn() {
		saveBtn.click();
	}

	
}
