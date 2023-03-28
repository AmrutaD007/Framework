package com.learnautomation.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.learnautomation.utility.BrowserLaunch;

public class TestCaseWithoutFramework {
	
	WebDriver driver;
	
	@Test
	public void test1() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		
		System.getProperty("webdriver.chrome.driver", "C:\\Users\\AmrutaD\\Framework-workspace\\Framework\\Drivers\\chromedriver.exe");
		
		driver.manage().window().maximize();
		
		driver.get("https://freecrm.com/index.html");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
		
		driver.findElement(By.name("email")).sendKeys("Selenium_50");
		
		driver.findElement(By.name("password")).sendKeys("Abcd@123456");
		
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String error_msg = driver.findElement(By.xpath("//div[@class='header']")).getText();
		
		String exptect_msg = "Something went wrong...";
		
		Assert.assertEquals(error_msg, exptect_msg);
		
	}
}
