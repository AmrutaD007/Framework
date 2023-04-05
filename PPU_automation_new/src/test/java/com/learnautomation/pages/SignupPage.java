package com.learnautomation.pages;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignupPage {
	
	WebDriver driver;
	
	//Constructor to initialize the webDriver
	public SignupPage(WebDriver ldriver) {
		
		this.driver = ldriver;
		PageFactory.initElements(this.driver, this);	
	}
	
	//defining the elements
	@FindBy(xpath="//div[@class='modal-content']") WebElement MainModel;
	@FindBy(xpath="//a[@id='a-usertype-individual']") WebElement individualButton;
	@FindBy(xpath="//a[@class='btn bg-blue btn-large']") WebElement signupbtn;
	@FindBy(xpath="//a[@class='btn btn-primary btn-signup']") WebElement signupEmailbtn;
	@FindBy(id="emailId") WebElement signupEmail;
	@FindBy(xpath="//button[@class='btn btn-primary px-4 noHover']") WebElement signupContinue;
	@FindBy(id="btnAgree") WebElement IAgreebutton;
	
		
	//sending the elements data
	public void signupflow(String EmailApp) {
	
		individualButton.click();
		signupbtn.click();
		signupEmailbtn.click();
		signupEmail.sendKeys(EmailApp);
		signupContinue.click();
		IAgreebutton.click();
	}
}
