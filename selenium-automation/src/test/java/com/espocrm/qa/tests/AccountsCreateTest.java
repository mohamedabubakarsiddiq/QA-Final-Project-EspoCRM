package com.espocrm.qa.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.espocrm.qa.base.BaseTest;
import com.espocrm.qa.pages.AccountsPage;
import com.espocrm.qa.pages.LoginPage;
import com.espocrm.qa.utilities.AssertionUtils;
import com.espocrm.qa.utilities.ConfigReader;

public class AccountsCreateTest extends BaseTest {
	
	private AccountsPage accountsPage;
	
	@BeforeMethod
	public void setUpTest() {
		setUp();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.login(
				ConfigReader.getProperty("username"),
				ConfigReader.getProperty("password"));
		
		accountsPage = new AccountsPage(driver);
		
	}
	
	@Test
	public void verifyCreateAccount() {

		String accountName = "Selenium Test Account";

		accountsPage.clickAccounts();
		accountsPage.clickCreateAccount();
		accountsPage.enterAccountName(accountName);
		accountsPage.clickSaveAccount();

		AssertionUtils.assertEquals(
		    accountsPage.getCreatedAccountName(),
		    accountName,
		    "Created Account Name is incorrect"
		);
	}
	
	
	
	 @AfterMethod public void tearDownTest() { tearDown(); } 
	 

}
