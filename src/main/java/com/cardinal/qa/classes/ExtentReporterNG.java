package com.cardinal.qa.classes;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 

{
	public static ExtentReports extent;
	public static ExtentReports extentReporterGenerator()
    {
    	String path = System.getProperty("User.dir")+"\\ExtentReport\\Extent.html";
    	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
    	reporter.config().setDocumentTitle("test execution");
    	reporter.config().setReportName("WebdriverAutomation");
    	
    	extent = new ExtentReports();
    	extent.attachReporter(reporter);
    	extent.setSystemInfo("Tester", "pranay");
    	
    	return extent;
    }
    
    
}