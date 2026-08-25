package com.espocrm.qa.tests;

import org.testng.annotations.DataProvider;

import com.espocrm.qa.utilities.ConfigReader;

public class LoginDataProvider {
	
	@DataProvider(name = "loginData")
	public static Object[][] loginData(){
	
		String validUsername = ConfigReader.getProperty("username");
		String validPassword = ConfigReader.getProperty("password");
		
		return new Object[][] {
			
			{validUsername, validPassword, true},
			
			{"invaliduser", validPassword, false},
			
			{validUsername, "InvalidPassword", false},
			
			{"InavlidUser", "InvalidPassword", false}
			
			
		};
		
		
	}
	
}
