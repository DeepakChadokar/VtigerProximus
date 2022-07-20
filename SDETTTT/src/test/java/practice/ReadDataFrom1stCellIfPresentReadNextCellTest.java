package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFrom1stCellIfPresentReadNextCellTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testdata/testBook1.xlsx");
		String expName = "Pam";
		Workbook book = WorkbookFactory.create(fis);
		int r = book.getSheet("Sheet1").getLastRowNum();
		for(int i = 0; i <= r; i++) {
			String actName = book.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
			if(actName.equals(expName)) {
				String sub = book.getSheet("Sheet1").getRow(i).getCell(2).getStringCellValue();
				System.out.println(actName + "\t" + sub);
			}
		}
	}

}
