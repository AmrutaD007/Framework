package com.learnautomation.testcases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.PPUUserLogin;

public class NonSubscribedUserFlow extends BaseClass {

	@Test
	public void NonSubscribedLogin() {

		PPUUserLogin login = new PPUUserLogin(driver);	
		
		login.PPULoginFlow(excel.getStringData("NonSubscribedLogin", 0, 0), excel.getStringData("NonSubscribedLogin", 0, 1));
		
		String Actual_title = driver.findElement(By.xpath("//h4[@class='title mb-3']")).getText();

		Assert.assertEquals(Actual_title,"Subscription Information");
		
	}
}
