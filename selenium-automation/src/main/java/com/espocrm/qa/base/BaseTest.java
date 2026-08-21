package com.espocrm.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.espocrm.qa.utilities.ConfigReader;

public class BaseTest {
	
	protected WebDriver driver;
	
	protected void setup() {
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(ConfigReader.getProperty("baseUrl"));;
		
	}
	
	protected void tearDown() {
		if (driver != null) {
			driver.quit();
		}
		
	}
	
	
}
