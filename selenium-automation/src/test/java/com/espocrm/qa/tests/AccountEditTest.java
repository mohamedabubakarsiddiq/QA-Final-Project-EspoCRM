package com.espocrm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.espocrm.qa.base.BaseTest;
import com.espocrm.qa.pages.AccountsPage;
import com.espocrm.qa.pages.LoginPage;
import com.espocrm.qa.utilities.AssertionUtils;
import com.espocrm.qa.utilities.ConfigReader;

public class AccountEditTest extends BaseTest {
	
	private AccountsPage accountsPage;
	private String accountName;
	private String updatedAccountName;
	
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
	public void verifyEditAccount() {
		
		String uniqueId = String.valueOf(System.currentTimeMillis());
		
		String accountName = "Selenium Edit Test Account" + uniqueId;
		String updatedAccountName = "Selenium Edited Account" + uniqueId;
		
		accountsPage.createAccount(accountName);
		
		accountsPage.clickAccounts();
		accountsPage.openAccount(accountName);
		accountsPage.clickEditAccount();
		accountsPage.editAccountName(updatedAccountName);
		accountsPage.clickSaveAccount();
		
		AssertionUtils.assertEquals(
				accountsPage.getAccountNameOnDetailsPage(), 
				updatedAccountName,
				"Account name was not updated successfully");
		
	}
	
	@AfterMethod
	public void tearDownTest() {
		try {
			if (updatedAccountName != null) {
				accountsPage.clickAccounts();
				accountsPage.openAccount(updatedAccountName);
				accountsPage.clickAccountMoreActions();
				accountsPage.clickAccountDeleteOption();
				accountsPage.confirmRemoveAccount();
			}
		} finally {
			tearDown();
		} 
		
	}
	
}
