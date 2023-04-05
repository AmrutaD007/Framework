package com.learnautomation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NonSubscribedUserPages {
	
	WebDriver driver;
	
	//Constructor to initialize the webDriver
	public NonSubscribedUserPages(WebDriver ldriver) {
		
		this.driver = ldriver;
		PageFactory.initElements(this.driver, this);	
	}
	
	//defining the elements
	@FindBy(id="btnSubscriptionDetail") WebElement Subscribebtn;
	@FindBy(xpath="//input[@id='cardNumber']") WebElement CardNumber;
	@FindBy(xpath="//input[@id='cardExpiry']") WebElement CardExpiry;
	@FindBy(xpath="//input[@id='cardCvc']") WebElement CardCVV;
	@FindBy(xpath="//input[@id='billingName']") WebElement NameOnCard;
	@FindBy(xpath="//button[@class='btn btn-primary px-5 m-auto']") WebElement LoginAppbtn;	
		
	//sending the elements data
	public void NonSubscribedUserFlow(String AppEmailId, String AppPassword, String AppCardNumber, String AppCardExpiry, String AppCardCvv, String AppNameOnCard) {
	
		PPUUserLogin ppulogin = new PPUUserLogin(driver);
		ppulogin.PPULoginFlow(AppEmailId, AppPassword);
		Subscribebtn.click();
		CardNumber.sendKeys(AppCardNumber);
		CardExpiry.sendKeys(AppCardExpiry);
		CardCVV.sendKeys(AppCardCvv);
		NameOnCard.sendKeys(AppNameOnCard);
		LoginEmail.sendKeys(AppEmailId);
		LoginPassword.sendKeys(AppPassword);
		LoginAppbtn.click();
	}
}
