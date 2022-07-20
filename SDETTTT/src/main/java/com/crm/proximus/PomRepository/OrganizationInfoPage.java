package com.crm.proximus.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.proximus.genericUtility.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility {
	WebDriver driver;
	
	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	@FindBy(xpath = "(//input[@title='Delete [Alt+D]'])[1]")
	private WebElement deleteBtn;
	
	@FindBy(xpath = "(//input[@title='Edit [Alt+E]'])[1]")
	private WebElement editBtn;
	
	

	public WebElement getEditBtn() {
		return editBtn;
	}

	public void setEditBtn() {
		editBtn.click();
	}

	public WebElement getHeaderText() {
		return headerText;
	}

	public void setHeaderText(String name) {
		String text = headerText.getText();
		if(text.contains(name))
			System.out.println("Organization created successfully");
		else
			System.out.println("Organization creation failed");
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public void setDeleteBtn() {
		deleteBtn.click();;
	}
	
	

}
