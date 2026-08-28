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
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.login(ConfigReader.getProperty("username"),
				ConfigReader.getProperty("password"));
		
		accountsPage = new AccountsPage(driver);
		
	}
		
	@Test
	public void verifyAccountsModuleAccess() {
		
		accountsPage.clickAccounts();
		
		AssertionUtils.assertTrue(
				accountsPage.isAccountsPageDisplayed(),
				"Accounts module should be accessible");
		
	}
	
	@Test
	public void verifyAccountsListDisplayed() {
		accountsPage.clickAccounts();
		
		AssertionUtils.assertTrue(
				accountsPage.isAccountListDisplayed(), 
				"Accounts list should be displayed");
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDownTest() {
		tearDown();
	}

}
