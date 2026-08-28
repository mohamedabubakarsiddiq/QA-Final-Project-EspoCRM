package com.espocrm.qa.tests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.espocrm.qa.base.BaseTest;
import com.espocrm.qa.pages.AccountsPage;
import com.espocrm.qa.pages.LoginPage;
import com.espocrm.qa.utilities.AssertionUtils;
import com.espocrm.qa.utilities.ConfigReader;

public class AccountSearchTest extends BaseTest{
	
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
	public void verifyAccountSearch() {
		
		String accountName = "Selenium Test Account1787845161331";
		
		accountsPage.clickAccounts();
		
		
		accountsPage.searchAccount(accountName);
		
		AssertionUtils.assertTrue(accountsPage.isAccountSearchResultDisplayed(accountName),
				"Expected Account should be displayed in search results");
		
	}
	
	@AfterMethod
	public void tearDowntest() {
		tearDown();
	}
	
	
	

}
