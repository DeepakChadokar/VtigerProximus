package com.crm.proximus.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.proximus.genericUtility.WebDriverUtility;

public class ProductInformationPage extends WebDriverUtility {
	WebDriver driver;
	
	public ProductInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	//@FindBy(id = "dtlview_Product Name")
	private WebElement headerText;
	
	@FindBy(xpath = "(//input[@title='Delete [Alt+D]'])[1]")
	private WebElement deleteBtn;
	
	@FindBy(xpath = "(//input[@title='Edit [Alt+E]'])[1]")
	private WebElement editBtn;

	public WebElement getHeaderText() {
		return headerText;
	}

	public void setHeaderText(String prodName) {
		String title = headerText.getText();
		Assert.assertTrue(title.contains(prodName));
		//Assert.assertEquals(title, prodName); 
//		if(title.contains(prodName))
//			System.out.println("Product Created Successfully");
//		else
//			Assert.assertEquals(title, prodName);
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public void setDeleteBtn() {
		deleteBtn.click();
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

	public void setEditBtn() {
		editBtn.click();
	}
	
	
}
