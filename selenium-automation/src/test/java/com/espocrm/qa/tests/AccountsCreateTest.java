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
	
	@Test
	public void verifyAccountNameMandatory() {
		
		accountsPage.clickAccounts();
		accountsPage.clickCreateAccount();
		accountsPage.clickSaveAccount();
		
		AssertionUtils.assertTrue(accountsPage.isAccountnameValidationDisplayed(),
				"Account name validation message should be displayed");
		
	}
	
	@Test
	public void verifyCancelAccountCreation() {
		
		accountsPage.clickAccounts();
		accountsPage.clickCreateAccount();
		
		accountsPage.clickCancelAccount();
		
		AssertionUtils.assertTrue(accountsPage.isAccountsPageDisplayed(),
				"Cancel should return the user to the Accounts page");
		
	}
	
	@Test
	public void verifyCreateAccountWithOptionalFields() {
		
		String uniqueId = String.valueOf(System.currentTimeMillis());
		
		accountName = "Selenium optional fields Account" + System.currentTimeMillis();
		String email = "testaccount" + uniqueId +"@example.com";
		
		accountsPage.clickAccounts();
		accountsPage.clickCreateAccount();
		
		accountsPage.enterAccountName(accountName);
		accountsPage.enterWebsite("https://example.com");
		accountsPage.enterPhoneNumber("9876543210");
		accountsPage.enterEmail(email);
		accountsPage.enterDescription("Test account with optional fields");
		
		accountsPage.clickSaveAccount();
		
		AssertionUtils.assertEquals(
				accountsPage.getCreatedAccountName(), accountName,
				"Account with optional fields was not created successfully");
		
	}
	
	@Test
	public void verifyCreatedAccountAppearsInList() {
		
		
		
		accountName = "Selenium List Verification Account" + System.currentTimeMillis();
		
		
	accountsPage.clickAccounts();
	accountsPage.clickCreateAccount();
	accountsPage.enterAccountName(accountName);
	accountsPage.clickSaveAccount();
	
	accountsPage.clickAccounts();
	
	AssertionUtils.assertTrue(accountsPage.isAccountPresent(accountName),
			"Newly created account should be displayed in the accounts list");
		
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
	 }
}

		 
		 
		


