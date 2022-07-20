package com.crm.proxima.Sample;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.proximus.PomRepository.ContactInformationPage;
import com.crm.proximus.PomRepository.ContactPage;
import com.crm.proximus.PomRepository.CreateContactPage;
import com.crm.proximus.PomRepository.HomePage;
import com.crm.proximus.genericUtility.BaseClass;

public class SampleCreateContactTest extends BaseClass {
	@Test(groups = "smoke")
	public void createContactTest() throws Throwable {
		String data = exLib.readDataFromExcel("Sheet2", 1, 0) + jLib.generateRandomNum();
		HomePage hp = new HomePage(driver);
		hp.setContactsLink();
		ContactPage cp =new ContactPage(driver);
		cp.setCreateContactLink();
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.setLastNameField(data);
		ccp.setSaveBtn();
		ContactInformationPage cip = new ContactInformationPage(driver);
		cip.setNameOfContact(data);
		Reporter.log("Customer Created", true);
	}
	
	@Test(groups = "regression")   
	public void createContactAndDeleteTest() throws Throwable {
		String data = exLib.readDataFromExcel("Sheet2", 1, 0) + jLib.generateRandomNum();
		HomePage hp = new HomePage(driver);
		hp.setContactsLink();
		ContactPage cp =new ContactPage(driver);
		cp.setCreateContactLink();
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.setLastNameField(data);
		ccp.setSaveBtn();
		ContactInformationPage cip = new ContactInformationPage(driver);
		cip.setNameOfContact(data);
		cip.setDeleteBtn();
		cp.setSearchContact(data);
		cp.setSearchBtn();
		cp.setVerifyDeletion();
	}
}
