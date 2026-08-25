package com.espocrm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.espocrm.qa.base.BaseTest;
import com.espocrm.qa.pages.AccountsPage;
import com.espocrm.qa.pages.LoginPage;
import com.espocrm.qa.utilities.AssertionUtils;
import com.espocrm.qa.utilities.ConfigReader;

public class AccountsTest extends BaseTest {
	
	private AccountsPage accountsPage;
	
	@BeforeMethod
	public void setUpTest() {
		setUp();
		accountsPage = new AccountsPage(driver);
		
		//Login before accessing Accounts
		LoginPage loginPage = new com.espocrm.qa.pages.LoginPage(driver);
		
		loginPage.login(
				ConfigReader.getProperty("username"), 
				ConfigReader.getProperty("password")
				);
	}
	
	@Test
	public void verifyAccountsModuleAccess() {
		
		accountsPage.clickAccounts();
		
		AssertionUtils.assertTrue(
				accountsPage.isAccountsPageDisplayed(),
				"Accounts module should be accessible"
				);
	}
	
	@AfterMethod
	public void tearDownTest() {
		tearDown();
	}
	

}
