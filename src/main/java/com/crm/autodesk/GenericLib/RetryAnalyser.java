package com.crm.autodesk.GenericLib;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//RetryAnalyser is a class which implements IRetryAnalyzer interface
public class RetryAnalyser  implements IRetryAnalyzer{
	
	int count=0;
	int retryCount=4;
	
	public boolean retry(ITestResult result) {
		while(count<retryCount) {
			count++;
			return true;
		}
		return false;
	}
	

}
