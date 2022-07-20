package com.crm.proxima.Sample;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.proximus.PomRepository.CreatePurchaseOrderPage;
import com.crm.proximus.PomRepository.HomePage;
import com.crm.proximus.PomRepository.LoginPage;
import com.crm.proximus.PomRepository.PurchaseOrderInformationPage;
import com.crm.proximus.PomRepository.PurchaseOrderPage;
import com.crm.proximus.genericUtility.BaseClass;

@Listeners(com.crm.proximus.genericUtility.ListenerImplementation.class)
public class CreatePurchaseOrderTest extends BaseClass{
	
	@Test
	public void createPurchaseOrderWithVendorNameTest() throws Throwable{
		HomePage hp = new HomePage(driver);
		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		CreatePurchaseOrderPage cpop = new CreatePurchaseOrderPage(driver);
		PurchaseOrderInformationPage poip = new PurchaseOrderInformationPage(driver);
		String vName = exLib.readDataFromExcel("Sheet3", 1, 0);
		String  sub = exLib.readDataFromExcel("Sheet3", 1, 1) + jLib.generateRandomNum();
		String add = exLib.readDataFromExcel("Sheet3", 1, 2);
		String prodName = exLib.readDataFromExcel("Sheet3", 1, 3);
		String m1Name = exLib.readDataFromExcel("Sheet3", 1, 4);
		String m2Name = exLib.readDataFromExcel("Sheet3", 1, 5);
		String m3Name = exLib.readDataFromExcel("Sheet3", 1, 6);
		
		hp.setMoreLink();
		hp.setPurchaseOrderLink();
		pop.setCreatePurchaseOrderLink();
		cpop.setPurchaseOrderNameTF(sub);
		cpop.setAddVendorNameImg(m2Name, m3Name, vName);
		Assert.fail();
		cpop.setBillingAddressTf(add);
		cpop.setCopyBillingAddRadioBtn();
		cpop.setSearchProductImg(m1Name, m3Name, prodName);
		cpop.setQuantityTf("2");
		cpop.setSaveBtn();
		poip.setnameOfPurchaseOrder(sub);
	}
	
	@Test
	public void createPurchaseOrderWithVendorAndCoontactName() throws Throwable{
		String vName = exLib.readDataFromExcel("Sheet3", 1, 0);
		String  sub = exLib.readDataFromExcel("Sheet3", 1, 1) + jLib.generateRandomNum();
		String add = exLib.readDataFromExcel("Sheet3", 1, 2);
		String prodName = exLib.readDataFromExcel("Sheet3", 1, 3);
		String contName = exLib.readDataFromExcel("Sheet2", 1, 0);
		String m1Name = exLib.readDataFromExcel("Sheet3", 1, 4);
		String m2Name = exLib.readDataFromExcel("Sheet3", 1, 5);
		String m3Name = exLib.readDataFromExcel("Sheet3", 1, 6);
		String m4Name = exLib.readDataFromExcel("Sheet3", 1, 7);
		
		HomePage hp = new HomePage(driver);
		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		CreatePurchaseOrderPage cpop = new CreatePurchaseOrderPage(driver);
		PurchaseOrderInformationPage poip = new PurchaseOrderInformationPage(driver);
		
		hp.setMoreLink();
		hp.setPurchaseOrderLink();
		pop.setCreatePurchaseOrderLink();
		cpop.setPurchaseOrderNameTF(sub);
		cpop.setAddVendorNameImg(m2Name, m3Name, vName);
		cpop.setAddContactNameImg(m4Name, m3Name, contName);
		cpop.setBillingAddressTf(add);
		cpop.setCopyBillingAddRadioBtn();
		cpop.setSearchProductImg(m1Name, m3Name, prodName);
		cpop.setQuantityTf("4");
		cpop.setSaveBtn();
		poip.setnameOfPurchaseOrder(sub);
	}
}
