package com.crm.proximus.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.proximus.genericUtility.WebDriverUtility;

public class CampaignPage extends WebDriverUtility{
	WebDriver driver;
	 
	public CampaignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement createCampaignLink;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement campNameSearchTF;
	
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement campNameSearchBtn;

	public WebElement getCreateCampaignLink() {
		return createCampaignLink;
	}

	public void setCreateCampaignLink() {
		createCampaignLink.click();
	}

	public WebElement getCampNameSearchTF() {
		return campNameSearchTF;
	}

	public void setCampNameSearchTF(String campName) {
		campNameSearchTF.sendKeys(campName);
	}

	public WebElement getCampNameSearchBtn() {
		return campNameSearchBtn;
	}

	public void setCampNameSearchBtn() {
		campNameSearchBtn.click();
	}
	
	
}
