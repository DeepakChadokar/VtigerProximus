package com.crm.proximus.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.proximus.genericUtility.WebDriverUtility;

public class CreatePurchaseOrderPage extends WebDriverUtility{
	WebDriver driver;
	
	public CreatePurchaseOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "subject")
	private WebElement purchaseOrderNameTF;
	
	//@FindBy(xpath = "//img[@onclick='return window.open(\\\"index.php?module=Vendors&action=Popup&html=Popup_picker&popuptype=specific_vendor_address&form=EditView&fromlink=\\\",\\\"test\\\",\\\"width=640,height=602,resizable=0,scrollbars=0\\\");']")
	@FindBy(xpath = "(//img[@style='cursor:hand;cursor:pointer'])[1]")
	private WebElement addVendorNameImg;
	
	@FindBy(id = "search_txt")
	private WebElement vendorNameSearchTF;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement vendorNameSearchBtn;
	
	@FindBy(id = "1")
	private WebElement vendorNameLink;
	
	@FindBy(xpath = "//img[@onclick='selectContact(\"false\",\"general\",document.EditView)']")
	private WebElement addContactNameImg;
	
	@FindBy(id = "search_txt")
	private WebElement contactNameSearchTF;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement contactNameSearchBtn;
	
	@FindBy(id = "1")
	private WebElement contactNameLink;
	
	@FindBy(name = "bill_street")
	private WebElement billingAddressTf;
	
	@FindBy(xpath = "//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement copyBillingAddRadioBtn;
	
	@FindBy(id = "searchIcon1")
	private WebElement searchProductImg;
	
	@FindBy(id = "search_txt")
	private WebElement productNameSearchTF;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement productNameSearchBtn;
	
	@FindBy(linkText = "Stark7712")
	private WebElement productFoundLink;
	
	@FindBy(id = "qty1")
	private WebElement quantityTf;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;

	public WebElement getPurchaseOrderNameTF() {
		return purchaseOrderNameTF;
	}

	public WebElement getAddVendorNameImg() {
		return addVendorNameImg;
	}

	public WebElement getVendorNameSearchTF() {
		return vendorNameSearchTF;
	}

	public WebElement getVendorNameSearchBtn() {
		return vendorNameSearchBtn;
	}

	public WebElement getVendorNameLink() {
		return vendorNameLink;
	}

	public WebElement getAddContactNameImg() {
		return addContactNameImg;
	}

	public WebElement getContactNameSearchTF() {
		return contactNameSearchTF;
	}

	public WebElement getContactNameSearchBtn() {
		return contactNameSearchBtn;
	}

	public WebElement getContactNameLink() {
		return contactNameLink;
	}

	public WebElement getBillingAddressTf() {
		return billingAddressTf;
	}

	public WebElement getCopyBillingAddRadioBtn() {
		return copyBillingAddRadioBtn;
	}

	public WebElement getSearchProductImg() {
		return searchProductImg;
	}

	public WebElement getProductNameSearchTF() {
		return productNameSearchTF;
	}

	public WebElement getProductNameSearchBtn() {
		return productNameSearchBtn;
	}

	public WebElement getProductFoundLink() {
		return productFoundLink;
	}
	
	public WebElement getQuantityTf() {
		return quantityTf;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void setPurchaseOrderNameTF(String poName) {
		purchaseOrderNameTF.sendKeys(poName);
	}

	public void setAddVendorNameImg(String m1Name, String m2Name ,String vName) {
		addVendorNameImg.click();
		String w = driver.getWindowHandle();
		swithToWindow(driver, m1Name);
		vendorNameSearchTF.sendKeys(vName);
		vendorNameSearchBtn.click();
		vendorNameLink.click();
		//swithToWindow(driver, m2Name);
		driver.switchTo().window(w);
	}

	public void setAddContactNameImg(String m1Name, String m2Name ,String cName) {
		addContactNameImg.click();
		String w = driver.getWindowHandle();
		swithToWindow(driver, m1Name);
		contactNameSearchTF.sendKeys(cName);
		contactNameSearchBtn.click();
		contactNameLink.click();
		swithToAlertWindowAndCancel(driver, "Overwrite the existing address with this selected contact( Stark2383) address details?");
		//swithToWindow(driver, m2Name);
		driver.switchTo().window(w);
	}

	public void setBillingAddressTf(String billingAddress) {
		billingAddressTf.sendKeys(billingAddress);
	}

	public void setCopyBillingAddRadioBtn() {
		copyBillingAddRadioBtn.click();
	}

	public void setSearchProductImg(String m1Name, String m2Name, String pName) {
		searchProductImg.click();
		String w = driver.getWindowHandle();
		swithToWindow(driver, m1Name);
		productNameSearchTF.sendKeys(pName);
		productNameSearchBtn.click();
		productFoundLink.click();
		//swithToWindow(driver, m2Name);
		driver.switchTo().window(w);
	}
	
	public void setQuantityTf(String numb) {
		quantityTf.sendKeys(numb);
	}

	public void setSaveBtn() {
		saveBtn.click();
	}	
}
