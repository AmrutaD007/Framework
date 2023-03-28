package com.learnautomation.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import freemarker.core.UndefinedCustomFormatException;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Helper {
	
	//Screenshot, alerts, frames, windows, Sync issue, javascript executor
	
	public static String captureScreenshot(WebDriver driver) {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshot_path = System.getProperty("user.dir")+"/Screenshot/FreeCRM_"+ getCurrentDateTime() +".png";
		try {
			
			FileHandler.copy(src, new File(screenshot_path));
			
			Reporter.log("Screenshot captured", true);
			
		//	System.out.println("Screenshot captured");
			
		} catch (IOException e) {
			
			System.out.println("Unable to capture screenshot"+ e.getMessage());
		}
		
		return screenshot_path;
	}
	
	public static String getCurrentDateTime() {
		
		DateFormat custom_format = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date current_date = new Date();
		
		return custom_format.format(current_date);
		
	}

}
