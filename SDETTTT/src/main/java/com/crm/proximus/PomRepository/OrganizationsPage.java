package com.crm.proximus.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.proximus.genericUtility.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility {
	
	WebDriver driver;
	
	public OrganizationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@style='width:16px;height:16px;']")
	private WebElement homeLink;
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorsLink;
	
	@FindBy(linkText="Purchase Order")
	private WebElement purchaseOrderLink;
	
	@FindBy(xpath="(//td[@class='small'])[2]")
	private WebElement userPic;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement nameSearchTf;
	
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement searchBtn;
	
	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}

	public WebElement getUserPic() {
		return userPic;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public WebElement getCreateOrganizationLink() {
		return createOrganizationLink;
	}
	
	public void setUserPic() {
		mouseOverOnElement(driver, userPic);
		signoutLink.click();
	}


	/**
	 * 
	 * @param organizationLink
	 */
	public void setHomeLink() {
		homeLink.click();
	}
	/**
	 * method to click o contact link
	 * @param contactsLink
	 */
	public void setContactsLink() {
		contactsLink.click();
	}

	public void setProductsLink() {
		productsLink.click();
	}

	public void setMoreLink() {
		moreLink.click();
	}

	public void setCampaignsLink() {
		campaignsLink.click();
	}

	public void setVendorsLink() {
		vendorsLink.click();
	}

	public void setPurchaseOrderLink() {
		purchaseOrderLink.click();
	}

	public void setCreateOrganizationLink() {
		createOrganizationLink.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getNameSearchTf() {
		return nameSearchTf;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public void setSearchContact(String contName) {
		nameSearchTf.sendKeys(contName);
	}
	
	
	public void setSearchBtn() {
		searchBtn.click();
	}
	
	
}
