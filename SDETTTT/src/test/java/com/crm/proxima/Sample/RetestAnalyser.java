package com.crm.proxima.Sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetestAnalyser {
	
	@Test(retryAnalyzer = com.crm.proximus.genericUtility.RetryAnalyserImplementation.class)
	public void practiceRetry() {
		System.out.println("This is test1");
		Assert.fail();
		System.out.println("test pass");
	
	}
	
	
}
