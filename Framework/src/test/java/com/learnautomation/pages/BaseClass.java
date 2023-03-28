package com.learnautomation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnautomation.utility.BrowserLaunch;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {

	//This is the class that has all the common methods that are needed.
	// Driver is made public so that it can be accessed every where.
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setting up reports and test is getting ready", true);
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
//		ExtentSparkReporter extent = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/FreeCRM"+Helper.getCurrentDateTime()+".html");
		ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting done - Test can be started", true);
	}

	@BeforeClass
	public void setup() {
		
		Reporter.log("Trying to start the browser and getting the application ready", true);
		
		BrowserLaunch bl = new BrowserLaunch();
		driver = bl.launch_browser(driver, config.getBrowser(), config.getStagingUrl());
		
		Reporter.log("Browser and application up and running", true);
	}
	
	@AfterClass
	public void teardown() {
		
		driver.close();
	}
	
	@AfterMethod
	public void teardownMethod(ITestResult result) {
	
		Reporter.log("Test is about to end.", true);
		
		if (result.getStatus()==ITestResult.FAILURE)
		{
	
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if (result.getStatus()==ITestResult.SUCCESS){
			
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		report.flush();
		
		Reporter.log("Test completed >> Reports Generated", true);
	}
}
	




//Rough work
// This is for segregation of logics
