package com.learnautomation.testcases;
import org.testng.annotations.Test;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.SignupPage;

public class SignupFlow extends BaseClass {
	
//	public WebDriver driver;

	@Test
	public void SignUp() {

		SignupPage signup = new SignupPage(driver);	
		
		signup.signupflow(excel.getStringData("Signup", 0, 0));	
	}
}
