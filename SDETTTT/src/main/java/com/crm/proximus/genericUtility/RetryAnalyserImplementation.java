package com.crm.proximus.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer {

	int counter = 0;
	int retryLimit = 4;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(counter<retryLimit) {
			counter++;
			return true;
		}
		return false;
	}
	
}
