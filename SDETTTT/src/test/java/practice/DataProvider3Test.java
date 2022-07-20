package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider3Test {
	@Test(dataProvider = "dataProvider_bookTicketTest")
	public void bookTicket(String src, String dest, int p) {
		System.out.println("Book ticket from " + src + " to " + dest +" price = "+p);
	}
	
	@DataProvider
	public Object[][] dataProvider_bookTicketTest(){
		Object[][] objArr = new Object[5][3];
		objArr[0][0] = "Bangalore";
		objArr[0][1] = "Goa";
		objArr[0][2] = 10;
		objArr[1][0] = "Bangalore";
		objArr[1][1] = "Delhi";
		objArr[1][2] = 20;
		objArr[2][0] = "Bangalore";
		objArr[2][1] = "Chennai";
		objArr[2][2] = 30;
		objArr[3][0] = "Bangalore";
		objArr[3][1] = "Bhopal";
		objArr[3][2] = 40;
		objArr[4][0] = "Bangalore";
		objArr[4][1] = "Kolkata";
		objArr[4][2] = 50;
		
		return objArr;
		}
}
