package com.crm.proximus.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.proximus.genericUtility.WebDriverUtility;

public class ContactInformationPage extends WebDriverUtility{
	
	WebDriver driver;
	
	public ContactInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement nameOfContact;
	
	@FindBy(xpath = "(//input[@title='Delete [Alt+D]'])[1]")
	private WebElement deleteBtn;

	public WebElement getNameOfContact() {
		return nameOfContact;
	}

	public void setNameOfContact(String name) {
		String nameApp = nameOfContact.getText();
		if(nameApp.contains(name))
			System.out.println("Name created successfully");
		else
			System.out.println("Name creation failed");
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public void setDeleteBtn() {
		deleteBtn.click();
		swithToAlertWindowAndAccpect(driver, "Are you sure you want to delete this record?");
	}
	
	
	

}
