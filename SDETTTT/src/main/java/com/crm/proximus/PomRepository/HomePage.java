package com.crm.proximus.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.proximus.genericUtility.WebDriverUtility;

/**
 * Page object model of home page
 * @author Deepak
 *
 */
public class HomePage extends WebDriverUtility{
	
	WebDriver driver;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText ="Contacts")
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
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
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

	public void setUserPic() {
		mouseOverOnElement(driver, userPic);
		signoutLink.click();
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	

	/**
	 * 
	 * @param organizationLink
	 */
	public void setOrganizationLink() {
		organizationLink.click();
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
	
	
}
