package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFrom1stAnd2ndColumnTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testdata/testBook1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int r = wb.getSheet("Sheet1").getLastRowNum();
		for(int i = 0; i <= r; i++) {
		String url = wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
		String un = wb.getSheet("Sheet1").getRow(i).getCell(2).getStringCellValue();
		System.out.println(url + "\t" + un);
		}
	}

}
