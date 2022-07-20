package com.crm.proximus.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is to read and write data from excel file
 * @author Deepak
 *
 */

public class ExcelUtility {
	/**
	 * this method is used to read data from specific cell
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return String
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheet, int row, int cell) throws Throwable {
		FileInputStream fis = new FileInputStream(IConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		return data;
	}
	
	/**
	 * this method returns the last row in which data is present
	 * @param sheet
	 * @return int
	 * @throws Throwable
	 */
	public int getRowCount(String sheet) throws Throwable {
		FileInputStream fis  = new FileInputStream(IConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		int lastRowNum = wb.getSheet(sheet).getLastRowNum();
		wb.close();
		return lastRowNum;
	}
	
	/**
	 * this method is used to write data in excel file
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param data
	 * @throws Throwable
	 */
	public void writeDataToExcel(String sheet, int row, int cell, String data) throws Throwable{
		FileInputStream fis = new FileInputStream(IConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IConstants.excelFilePath);
		wb.write(fos);
		wb.close();
	}
	
	/**
	 * this method is used to read numeric data from excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return double
	 * @throws Throwable
	 */
	public double readNumDataFromExcel(String sheet, int row, int cell) throws Throwable {
		FileInputStream fis = new FileInputStream(IConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		double data = wb.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
		wb.close();
		return data;
	}

}
