/**
 * 
 */
package practice;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.proximus.PomRepository.ContactInformationPage;
import com.crm.proximus.PomRepository.ContactPage;
import com.crm.proximus.PomRepository.CreateContactPage;
import com.crm.proximus.PomRepository.HomePage;
import com.crm.proximus.genericUtility.BaseClass;

/**
 * @author Deepak
 *
 */
public class TestngPracticeTest{
	
	@Test(dataProvider = "dataProvider_bookTicketTest", invocationCount = 2)
	public void bookTicket(String src, String dest) {
		System.out.println("Book ticket from " + src + " to " + dest);
	}
	
	@DataProvider
	public Object[][] dataProvider_bookTicketTest(){
		Object[][] objArr = new Object[5][2];
		objArr[0][0] = "Bangalore";
		objArr[0][1] = "Goa";
		objArr[1][0] = "Bangalore";
		objArr[1][1] = "Delhi";
		objArr[2][0] = "Bangalore";
		objArr[2][1] = "Chennai";
		objArr[3][0] = "Bangalore";
		objArr[3][1] = "Bhopal";
		objArr[4][0] = "Bangalore";
		objArr[4][1] = "Kolkata";
		
		return objArr;
		}
}
