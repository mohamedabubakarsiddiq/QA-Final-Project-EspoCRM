package com.espocrm.qa.tests;




import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.espocrm.qa.base.BaseTest;
import com.espocrm.qa.pages.AccountsPage;
import com.espocrm.qa.pages.LoginPage;
import com.espocrm.qa.utilities.AssertionUtils;
import com.espocrm.qa.utilities.ConfigReader;

public class AccountDeleteTest extends BaseTest{
	
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
	public void deleteAccountFromDetails() {
		
		String accountName = "Selenium Delete Details Test" + System.currentTimeMillis();
		
		accountsPage.createAccount(accountName);
		
		accountsPage.clickAccounts();
		
		accountsPage.openAccount(accountName);
		
		accountsPage.clickAccountMoreActions();
		
		accountsPage.clickAccountDeleteOption();
		
		accountsPage.confirmRemoveAccount();
		
		AssertionUtils.assertTrue(accountsPage.isAccountDeleted(accountName), 
				"Account should be deleted successfully");
		
		
		
		
	}

	
	  @Test public void deleteAccountFromList() {
	  
	  String accountName = "Selenium Delete List Test" + System.currentTimeMillis();
	  
	  accountsPage.createAccount(accountName);
	  accountsPage.clickAccounts();
	  accountsPage.clickAccountRowDropdown(accountName);
	  accountsPage.clickRemoveAccount(accountName);
	  accountsPage.confirmRemoveAccount();
	  
	  AssertionUtils.assertTrue(accountsPage.isAccountDeleted(accountName),
	  "Account should be deleted successfully" );
	  
	  }
	 
	
	
	
	@AfterMethod
	
	public void tearDownTest() {
		tearDown();
	}
	
	
	
	
}
