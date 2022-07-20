package com.crm.proximus.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.proximus.genericUtility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility{
	
	WebDriver driver;
	
	public CreateOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgName;
	
	@FindBy(name = "industry")
	private WebElement industryListBox;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;

	public WebElement getOrgName() {
		return orgName;
	}

	public void setOrgName(String oName) {
		orgName.sendKeys(oName);;
	}

	public WebElement getIndustryListBox() {
		return industryListBox;
	}

	public void setIndustryListBox(String value) {
		select(industryListBox, value);
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn() {
		saveBtn.click();
	}
	
	
}
