package com.crm.proxima.Sample;

import org.testng.annotations.Test;

import com.crm.proximus.PomRepository.CreateOrganizationPage;
import com.crm.proximus.PomRepository.HomePage;
import com.crm.proximus.PomRepository.OrganizationInfoPage;
import com.crm.proximus.PomRepository.OrganizationsPage;
import com.crm.proximus.genericUtility.BaseClass;

public class SampleCreateOrganizationTest extends BaseClass {
	
	@Test(groups = "smoke")
	public void createOrganizationTest() throws Throwable {
		String orgName = exLib.readDataFromExcel("Sheet2", 1, 1) + jLib.generateRandomNum();
		HomePage hp = new HomePage(driver);
		hp.setOrganizationLink();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.setCreateOrganizationLink();
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.setOrgName(orgName);
		cop.setIndustryListBox("Government");
		cop.setSaveBtn();
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.setHeaderText(orgName);
	}
	
	@Test(groups = "regression")
	public void createAndEditOrganizationTest() throws Throwable {
		String orgName = exLib.readDataFromExcel("Sheet2", 1, 1) + jLib.generateRandomNum();
		HomePage hp = new HomePage(driver);
		hp.setOrganizationLink();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.setCreateOrganizationLink();
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.setOrgName(orgName);
		cop.setIndustryListBox("Government");
		cop.setSaveBtn();
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.setHeaderText(orgName);
		oip.setEditBtn();
		cop.setIndustryListBox("Banking");
		cop.setSaveBtn();
		oip.setHeaderText(orgName);
	}
}
