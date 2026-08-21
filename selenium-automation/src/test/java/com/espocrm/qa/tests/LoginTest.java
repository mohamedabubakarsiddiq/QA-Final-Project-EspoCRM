package com.espocrm.qa.tests;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.espocrm.qa.base.BaseTest;
import com.espocrm.qa.pages.LoginPage;


public class LoginTest extends BaseTest {
	
	private LoginPage loginPage;
	
	@BeforeMethod
	public void setUpTest() {
		setup();
		loginPage = new LoginPage(driver);
	}
	
	@Test
	public void verifyValidLogin() {
		
		System.out.println("Current URL before login: " + driver.getCurrentUrl());
		
		System.out.println("Current Title before login: " + driver.getTitle());
		
		loginPage.login("admin", "YOUR_ADMIN_PASSWORD");
		
		String currentUrl = driver.getCurrentUrl();
		
		System.out.println("Current URL: " + currentUrl);
		
		Assert.assertNotEquals(currentUrl, "http://localhost:8081/#", "User should be redirected after successful login");
		
		System.out.println("Login successful.");
		System.out.println("Current URL after login: " + driver.getCurrentUrl());
		
	}
	
	@AfterMethod
	public void tearDownTest() {
		tearDown();
	}
	
	
	
	
}