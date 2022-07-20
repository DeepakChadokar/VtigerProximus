package com.crm.proximus.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.proximus.genericUtility.WebDriverUtility;

public class CreateeCampaignPage extends WebDriverUtility {
	WebDriver driver;
	
	public CreateeCampaignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(name="campaignname")
	private WebElement campaignNameField;
	
	
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	
	public WebElement getCampaignNameField() {
		return campaignNameField;
	}

	public void setCampaignNameField(String campname){
		campaignNameField.sendKeys(campname);
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn() {
		saveBtn.click();
	}

}
