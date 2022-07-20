package com.crm.proximus.genericUtility;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

  


public class ListenerImplementation implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		String res = result.getName();
		//TakesScreenshot t =(TakesScreenshot)driver;
		EventFiringWebDriver t = new EventFiringWebDriver(BaseClass.driver);
		String date = new Date().toString().replaceAll(":", "-");
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/"+res+date+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
		}
	}


	
}
