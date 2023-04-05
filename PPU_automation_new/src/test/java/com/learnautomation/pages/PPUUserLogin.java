package com.learnautomation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PPUUserLogin {
	
	WebDriver driver;
	
	//Constructor to initialize the webDriver
	public PPUUserLogin(WebDriver ldriver) {
		
		this.driver = ldriver;
		PageFactory.initElements(this.driver, this);	
	}
	
	//defining the elements
	@FindBy(xpath="//div[@class='modal-content']") WebElement MainModel;
	@FindBy(xpath="//a[@id='a-usertype-individual']") WebElement individualButton;
	@FindBy(xpath="//a[@class='nav-link btn-bg-blue-border-white rounded fw-bolder px-4']") WebElement loginbtn;
	@FindBy(id="Username") WebElement LoginEmail;
	@FindBy(id="Password") WebElement LoginPassword;
	@FindBy(xpath="//button[@class='btn btn-primary px-5 m-auto']") WebElement LoginAppbtn;	
		
	//sending the elements data
	public void PPULoginFlow(String AppEmailId, String AppPassword) {
	
		individualButton.click();
		loginbtn.click();
		LoginEmail.sendKeys(AppEmailId);
		LoginPassword.sendKeys(AppPassword);
		LoginAppbtn.click();
	}
}
