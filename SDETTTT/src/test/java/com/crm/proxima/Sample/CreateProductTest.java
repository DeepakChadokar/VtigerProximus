package com.crm.proxima.Sample;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.proximus.PomRepository.CreateProductPage;
import com.crm.proximus.PomRepository.HomePage;
import com.crm.proximus.PomRepository.ProductInformationPage;
import com.crm.proximus.PomRepository.ProductPage;
import com.crm.proximus.genericUtility.BaseClass;

public class CreateProductTest extends BaseClass {
	
	@Test(groups = "smoke")
	public void createProductTest() throws Throwable {
		String prodName = exLib.readDataFromExcel("Sheet3", 1, 4) + jLib.generateRandomNum();
		HomePage hp = new HomePage(driver);
		hp.setProductsLink();
		ProductPage pp = new ProductPage(driver);
		pp.setCreateProductLink();
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.setProductNameTF(prodName);
		//Assert.fail();
		cpp.setSaveBtn();
		ProductInformationPage pip = new ProductInformationPage(driver);
		pip.setHeaderText(prodName);
	}
	
	@Test(groups = "regression")
	public void createAndEditProductTest() throws Throwable {
		String prodName = exLib.readDataFromExcel("Sheet3", 1, 4) + jLib.generateRandomNum();
		HomePage hp = new HomePage(driver);
		hp.setProductsLink();
		ProductPage pp = new ProductPage(driver);
		pp.setCreateProductLink();
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.setProductNameTF(prodName);
		cpp.setSaveBtn();
		ProductInformationPage pip = new ProductInformationPage(driver);
		pip.setEditBtn();
		cpp.setProductNameTF(prodName + jLib.generateRandomNum());
		cpp.setSaveBtn();
		pip.setHeaderText(prodName);
	}

}
