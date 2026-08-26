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
	
	@BeforeMethod
	public void setUpTest() {
		setUp();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.login(
				ConfigReader.getProperty("username"),
				ConfigReader.getProperty("password"));
		
		accountsPage = new AccountsPage(driver);
		
		//Create test data specifically for this test
		accountsPage.createAccount("Selenium Edit Test Account");
		
	}

	@Test
	public void verifyEditAccount() {
		
		String exisitingAccountName = "Selenium Edit Test Account";
		String updatedAccountName = "Selenium Edited Account";
		
		
		accountsPage.clickAccounts();
		accountsPage.openAccount(exisitingAccountName);
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
		tearDown();
	}
	
}
