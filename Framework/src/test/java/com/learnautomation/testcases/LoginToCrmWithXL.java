package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.Helper;


public class LoginToCrmWithXL extends BaseClass{
	
	@Test
	public void login_app() {
		
		logger = report.createTest("Login to CRM");
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting application");
		
		loginpage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Login failed successfully");
		
	}

}
