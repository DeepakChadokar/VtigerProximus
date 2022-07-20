package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.proximus.genericUtility.BaseClass;
import com.crm.proximus.genericUtility.ExcelUtility;

public class DataProviderWithExcelTest {

	@Test(dataProvider = "dataProvider_bookTicketTest", invocationCount = 2)
	public void bookTicket(String src, String dest) {
		System.out.println("Book ticket from " + src + " to " + dest);
	}
	
	@DataProvider
	public Object[][] dataProvider_bookTicketTest() throws Throwable{
		ExcelUtility exLib = new ExcelUtility();
		String from = exLib.readDataFromExcel("Sheet4", 1, 0);
		Object[][] objArr = new Object[5][2];
//		objArr[0][0] = from;
//		objArr[0][1] = exLib.readDataFromExcel("Sheet4", 1, 1);
//		objArr[1][0] = from;
//		objArr[1][1] = exLib.readDataFromExcel("Sheet4", 2, 1);
//		objArr[2][0] = from;
//		objArr[2][1] = exLib.readDataFromExcel("Sheet4", 3, 1);
//		objArr[3][0] = from;
//		objArr[3][1] = exLib.readDataFromExcel("Sheet4", 4, 1);
//		objArr[4][0] = from;
//		objArr[4][1] = exLib.readDataFromExcel("Sheet4", 5, 1);
		
		for(int i = 1; i <= 5; i++) {
			for(int j = 0; j <= 1; j++) {
				if(j==0)
					objArr[i-1][j] = from;
				else if(j == 1)
					objArr[i-1][j] =  exLib.readDataFromExcel("Sheet4", i, j);
			}
		}
		
		return objArr;
		}
	
}
