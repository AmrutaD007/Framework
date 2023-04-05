package com.learnautomation.pages;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.learnautomation.utility.BrowserLaunch;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;

public class BaseClass {

	//This is the class that has all the common methods that are needed.
	// Driver is made public so that it can be accessed every where.
	public WebDriver driver;
	BrowserLaunch bl;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	
	@BeforeSuite
	public void setUpSuite() {
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
	}
	
	@BeforeClass
	public void setup() {
		
		bl = new BrowserLaunch();
		driver = bl.launch_browser(driver, config.getBrowser(), config.getStagingUrl());
	}
	
	@AfterClass
	public void teardown() {
		
		bl.browserquit(driver);
	}
}
	




//Rough work
// This is for segregation of logics
