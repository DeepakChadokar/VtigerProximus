package com.crm.proximus.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.proximus.genericUtility.WebDriverUtility;

public class ContactPage extends WebDriverUtility {
	
	WebDriver driver;
	
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@style='width:16px;height:16px;']")
	private WebElement homeLink;
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactLink;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
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
	
	@FindBy(xpath = "//span[contains(text(),'No Contact Found !')]")
	private WebElement contactNotFoundMsg;
	
	@FindBy(partialLinkText = "Stark")
	private WebElement nameFound;
	
	public WebElement getNameFound() {
		return nameFound;
	}
	
	public void setNameFound() {
		nameFound.click();
	}
	
	public void setVerifyDeletion() {
		String msg = contactNotFoundMsg.getText();
		if(msg.contains("No Contact Found"))
			System.out.println("Deletion Successfull");
		else
			System.out.println("Deletion Failed");
	}
	
	public WebElement searchBtn() {
		return searchBtn;
	}
	
	public void setSearchBtn() {
		searchBtn.click();
	}

	public WebElement getNameSearchTf() {
		return nameSearchTf;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public void setHomeLink() {
		homeLink.click();;
	}

	public WebElement getCreateContactLink() {
		return createContactLink;
	}

	public void setCreateContactLink() {
		createContactLink.click();
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public void setOrganizationLink() {
		organizationLink.click();;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public void setProductsLink() {
		productsLink.click();;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public void setMoreLink() {
		moreLink.click();;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public void setCampaignsLink() {
		campaignsLink.click();
	}

	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	public void setVendorsLink() {
		vendorsLink.click();;
	}

	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}

	public void setPurchaseOrderLink() {
		purchaseOrderLink.click();
	}

	public WebElement getUserPic() {
		return userPic;
	}

	public void setUserPic() {
		mouseOverOnElement(driver, userPic);
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public void setSignoutLink() {
		signoutLink.click();
	}
	
	public void setSearchContact(String contName) {
		nameSearchTf.sendKeys(contName);
	}
	
	public void setSearchBtnClick() {
		searchBtn.click();
	}

	
}
