package com.espocrm.qa.tests;

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
	
	private String accountName;
	
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

		accountName = "Selenium Test Account" + System.currentTimeMillis();

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
	
	
	
	 @AfterMethod public void tearDownTest() { 
		 
		 try {
			if (accountName != null) {
				accountsPage.clickAccounts();
				accountsPage.openAccount(accountName);
				accountsPage.clickAccountMoreActions();
				accountsPage.clickAccountDeleteOption();
				accountsPage.confirmRemoveAccount();
			}
		} finally {
			tearDown();
		}
		}}
		 
		 
		


