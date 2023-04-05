package com.learnautomation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	//Testing new commit by Amruta
	public LoginPage(WebDriver ldriver) {
		
		this.driver = ldriver;
		System.out.println(this.driver);
	}
	
	//defining the elements
	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']") WebElement MainLoginbtn;
	@FindBy(name="email") WebElement uname;
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']") WebElement login_btn;
	
	public void loginToCRM(String app_username, String app_password){
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		
		//sending the elements data
		MainLoginbtn.click();
		uname.sendKeys(app_username);
		pass.sendKeys(app_password);
		login_btn.click();
		
	}
}
