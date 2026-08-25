package com.espocrm.qa.base;

import org.openqa.selenium.WebDriver;
import com.espocrm.qa.utilities.ConfigReader;
import com.espocrm.qa.utilities.DriverFactory;

public class BaseTest {
	
	protected WebDriver driver;
	
	protected void setUp() {
		
		String browser = ConfigReader.getProperty("browser");
		
		driver = DriverFactory.createDriver(browser);
		
		driver.manage().window().maximize();
		
		driver.get(ConfigReader.getProperty("baseUrl"));
		
	}
	
	protected void tearDown() {
		if (driver != null) {
			driver.quit();
		}
		
	}
	
	
}
