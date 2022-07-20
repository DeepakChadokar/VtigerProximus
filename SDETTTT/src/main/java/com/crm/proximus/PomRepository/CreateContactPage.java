package com.crm.proximus.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.proximus.genericUtility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{
	
	WebDriver driver;
	
	public CreateContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameField;
	
	@FindBy(xpath="//img[@onclick='return window.open(\"index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=\",\"test\",\"width=640,height=602,resizable=0,scrollbars=0\");']")
	private WebElement addOrganizationImg;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	@FindBy(id="search_txt")
	private WebElement orgSearchField;
	
	@FindBy(name="search")
	private WebElement srchBtn;
	
	@FindBy(id="1")
	private WebElement orgNameFound;

	public WebElement getLastNameField() {
		return lastNameField;
	}
	
	
	
	public WebElement getOrgSearchField() {
		return orgSearchField;
	}



	public WebElement getSrchBtn() {
		return srchBtn;
	}



	public WebElement getOrgNameFound() {
		return orgNameFound;
	}



	public void setLastNameField(String lastname){
		lastNameField.sendKeys(lastname);
	}

	public WebElement getAddOrganizationImg() {
		return addOrganizationImg;
	}

	public void setAddOrganizationImg(String orgname, String m1name, String m2name) throws Throwable {
		addOrganizationImg.click();
		swithToWindow(driver, m1name);
		orgSearchField.sendKeys(orgname);
		srchBtn.click();
		String name = orgNameFound.getText();
		if(name.contains(orgname))
			orgNameFound.click();
		swithToWindow(driver, m2name);
		
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn() {
		saveBtn.click();
	}
	
	
}
