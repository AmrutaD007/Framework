package com.learnautomation.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.BrowserLaunch;

public class LoginTestCRM extends BaseClass {

	@Test
	public void login_app() {

		//Class pagefactory has methods to initialize webelement for the page. It returns the object of same class
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToCRM("Selenium_50", "Abcd@123456");
		
	}

}





/*	Rough work
 * Positions of annotations does not matter they work as per there annoted work
 * 	login_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
String error_msg = login_driver.findElement(By.xpath("//div[@class='header']")).getText();
String exptect_msg = "Something went wrong...";
Assert.assertEquals(error_msg, exptect_msg);
if(error_msg.equalsIgnoreCase(exptect_msg)) {
	System.out.println("Error message is correct");
}
else {
	System.out.println("Error message is incorrect");
}*/
