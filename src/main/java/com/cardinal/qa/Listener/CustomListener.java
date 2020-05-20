package com.cardinal.qa.Listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cardinal.qa.Base.Base;
import com.cardinal.qa.TestUtil.TestUtility;
import com.cardinal.qa.classes.ExtentReporterNG;

public class CustomListener extends Base implements ITestListener
{
	public ExtentTest test;
	ExtentReports rep = ExtentReporterNG.extentReporterGenerator();
	
	private ThreadLocal<ExtentTest> local = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
	test = rep.createTest(result.getMethod().getMethodName());
	local.set(test);
        
    }

    public void onTestSuccess(ITestResult result) {
      local.get().log(Status.PASS, "successfull");
        
    }

    //Override below method to implement screenshot
    public void onTestFailure(ITestResult result) {
       TestUtility.screenshot(driver);
       
       local.get().fail(result.getThrowable());
       try {
		local.get().addScreenCaptureFromPath(TestUtility.screenshot(driver), "title");
	} catch (IOException e) {
		
		e.printStackTrace();
	}
        
    }

    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        
    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
        
    }

    public void onFinish(ITestContext context) {
        rep.flush();
        
    }
}
