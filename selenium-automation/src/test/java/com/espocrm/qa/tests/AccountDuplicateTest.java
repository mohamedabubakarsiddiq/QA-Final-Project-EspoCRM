package com.espocrm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.espocrm.qa.base.BaseTest;
import com.espocrm.qa.pages.AccountsPage;
import com.espocrm.qa.pages.LoginPage;
import com.espocrm.qa.utilities.AssertionUtils;
import com.espocrm.qa.utilities.ConfigReader;

public class AccountDuplicateTest extends BaseTest {
	
	private AccountsPage accountsPage;
	private String duplicateAccountName;
	private boolean duplicateAccountCreated;
	
	@BeforeMethod
	public void setUpTest() {
		setUp();
		
		duplicateAccountName = null;
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.login(ConfigReader.getProperty("username"),
				ConfigReader.getProperty("password"));
		accountsPage = new AccountsPage(driver);
	}
	
	@Test
	public void verifyDuplicateAccountDetection() {
		String accountName = "Selenium Test Account";
		
		accountsPage.clickAccounts();
		accountsPage.openAccount(accountName);
		accountsPage.clickAccountMoreActions();
		accountsPage.clickAccountDuplicate();
		accountsPage.clickSaveAccount();
		
		AssertionUtils.assertTrue(accountsPage.isDuplicateWarningDisplayed(),
				"Duplicate warning should be displayed");
		
		accountsPage.clickDuplicateWarningCancel();
		
	}
	
	@Test
	public void verifyDuplicateAccountCanBeSavedAfterChangingData() {
		
		String originalAcccountName = "Selenium Test Account";
		
		duplicateAccountName = 
				"Selenium Duplicate Test Account" + System.currentTimeMillis();
		
		accountsPage.clickAccounts();
		accountsPage.openAccount(originalAcccountName);
		accountsPage.clickAccountMoreActions();
		accountsPage.clickAccountDuplicate();
		
		accountsPage.editAccountName(duplicateAccountName);
		accountsPage.clickSaveAccount();
		
		duplicateAccountCreated = true;
		
		AssertionUtils.assertEquals(accountsPage.getCreatedAccountName(),
				duplicateAccountName,
				"Duplicated Account was not created successfully");
		
		
	}
	
	
	
	@AfterMethod
	public void tearDownTest() {
		
		try {
			if (duplicateAccountCreated && duplicateAccountName != null) {
				accountsPage.clickAccounts();
				accountsPage.openAccount(duplicateAccountName);
				accountsPage.clickAccountMoreActions();
				accountsPage.clickAccountDeleteOption();
				accountsPage.confirmRemoveAccount();
			}
		} finally {
			tearDown();
		}
		
		
	}
	
	
	

}
