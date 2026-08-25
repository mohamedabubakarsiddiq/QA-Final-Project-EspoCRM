package com.espocrm.qa.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	private DriverFactory() {
		// Prevent object creation
	}
	
	public static WebDriver createDriver(String browser) {
		
		if (browser == null || browser.isBlank()) {
			throw new IllegalArgumentException("Browser must be provided");
		}
		
		switch (browser.trim().toLowerCase()) {
		
		case "chrome":
		return new ChromeDriver();
		
		default:
			throw new IllegalArgumentException(
					"Unsupported browser: " + browser
					);
		
		}	
	}
}
