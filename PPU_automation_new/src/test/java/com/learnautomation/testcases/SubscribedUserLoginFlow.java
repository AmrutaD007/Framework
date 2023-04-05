package com.learnautomation.testcases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.PPUUserLogin;

public class SubscribedUserLoginFlow extends BaseClass {
	
//	public WebDriver driver;

	@Test
	public void SubscribedLogin() {

		PPUUserLogin login = new PPUUserLogin(driver);	
		
		login.PPULoginFlow(excel.getStringData("SubscribedLogin", 0, 0), excel.getStringData("SubscribedLogin", 0, 1));
		
		String Actual_title = driver.findElement(By.xpath("//h1[@class='page-heading2']")).getText();
//		System.out.println(Actual_title);
		Assert.assertEquals(Actual_title,"My Order History");
		
	}
}
