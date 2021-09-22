package com.crm.autodesk.GenericLib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Listners implements ITestListener
{
	ExtentReports reports; //attach the reporter
	ExtentTest test; //to make entries of test cases and logs
	
	public void onTestStart(ITestResult result) 
	{
		test=reports.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getMethod().getMethodName()+" is Passed");

		BaseClass Baseclass=new BaseClass();
		try {
		String path=Baseclass.screenShot("result.getMethod().getMethodName()");
		test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}
	
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,result.getMethod().getMethodName()+" is Failed");
		test.log(Status.FAIL,result.getThrowable());
		BaseClass Baseclass=new BaseClass();
		try {
		String path=Baseclass.screenShot("result.getMethod().getMethodName()");
		test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,result.getMethod().getMethodName()+" is Skipped");
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	public void onStart(ITestContext context) {
		JavaUtility ju=new JavaUtility();
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(IpathConstants.extentRepoPath+"reports"+ju.getSystmeDate()+".html");//path of report
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		
		reports.setSystemInfo("AppURL","http://localhost:8888");
		reports.setSystemInfo("ENV","Test QA");
		reports.setSystemInfo("Build","5.1");
		reports.setSystemInfo("Reporter name","Juniad");
	}
	
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
