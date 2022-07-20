package com.crm.proximus.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.crm.proximus.genericUtility.WebDriverUtility;

public class PurchaseOrderInformationPage extends WebDriverUtility {
	WebDriver driver;
	
	public PurchaseOrderInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement nameOfPurchaseOrder;
	
	@FindBy(xpath = "(//input[@title='Delete [Alt+D]'])[1]")
	private WebElement deleteBtn;

	public WebElement getNameOfContact() {
		return nameOfPurchaseOrder;
	}

	public void setnameOfPurchaseOrder(String name) {
		String nameApp = nameOfPurchaseOrder.getText();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(nameApp.contains(name));
		sa.assertAll();
//		if(nameApp.contains(name))
//			System.out.println("Purchase order created successfully");
//		else
//			System.out.println("Purchase order creation failed");
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public void setDeleteBtn() {
		deleteBtn.click();
		swithToAlertWindowAndAccpect(driver, "Are you sure you want to delete this record?");
	}

}
