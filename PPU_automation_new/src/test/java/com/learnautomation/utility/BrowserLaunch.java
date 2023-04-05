package com.learnautomation.utility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserLaunch {
	
	WebDriver driver;

	public WebDriver launch_browser(WebDriver driver, String browser, String URL) {
		
		if(browser.equalsIgnoreCase("Chrome")) {
			
			System.getProperty("webdriver.chrome.driver", "./chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			
		}
		else if(browser.equalsIgnoreCase("Firefox")){
			
			System.getProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("IE")) {
			
			driver = new EdgeDriver();
			System.getProperty("webdriver.msedgedriver.driver", "./msedgedriver.exe");
		
		}
		else {
			
			System.out.println("Sorry we do not support the browser");
		
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		return driver;
		
	}
	
	public void browserquit(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.close();
	}

}
