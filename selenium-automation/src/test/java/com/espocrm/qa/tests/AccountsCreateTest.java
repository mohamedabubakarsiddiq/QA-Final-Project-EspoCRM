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

	    // Search for the newly created account
	    accountsPage.searchAccount(accountName);

	    // Wait until the searched account is actually displayed
	    AssertionUtils.assertTrue(
	            accountsPage.isAccountSearchResultDisplayed(accountName),
	            "Newly created account should be displayed in the accounts list"
	    );
	}
	
	@Test
	public void verifyWebsiteField() {

	    accountName = "Selenium Website Test Account" + System.currentTimeMillis();
	    String website = "https://example.com";

	    accountsPage.clickAccounts();
	    accountsPage.clickCreateAccount();

	    accountsPage.enterAccountName(accountName);
	    accountsPage.enterWebsite(website);

	    AssertionUtils.assertEquals(
	            accountsPage.getWebsiteValue(),
	            website,
	            "Website field value is incorrect"
	    );

	    accountsPage.clickSaveAccount();

	    AssertionUtils.assertEquals(
	            accountsPage.getCreatedAccountName(),
	            accountName,
	            "Account with Website field was not created successfully"
	    );
	}

	@Test
	public void verifyPhoneField() {

	    accountName = "Selenium Phone Test Account" + System.currentTimeMillis();
	    String phone = "9876543210";

	    accountsPage.clickAccounts();
	    accountsPage.clickCreateAccount();

	    accountsPage.enterAccountName(accountName);
	    accountsPage.enterPhoneNumber(phone);

	    AssertionUtils.assertEquals(
	            accountsPage.getPhoneNumberValue(),
	            phone,
	            "Phone field value is incorrect"
	    );

	    accountsPage.clickSaveAccount();

	    AssertionUtils.assertEquals(
	            accountsPage.getCreatedAccountName(),
	            accountName,
	            "Account with Phone field was not created successfully"
	    );
	}

	@Test
	public void verifyEmailField() {

	    accountName = "Selenium Email Test Account" + System.currentTimeMillis();
	    String email =
	            "testaccount" + System.currentTimeMillis() + "@example.com";

	    accountsPage.clickAccounts();
	    accountsPage.clickCreateAccount();

	    accountsPage.enterAccountName(accountName);
	    accountsPage.enterEmail(email);

	    AssertionUtils.assertEquals(
	            accountsPage.getEmailValue(),
	            email,
	            "Email field value is incorrect"
	    );

	    accountsPage.clickSaveAccount();

	    AssertionUtils.assertEquals(
	            accountsPage.getCreatedAccountName(),
	            accountName,
	            "Account with Email field was not created successfully"
	    );
	}

	@Test
	public void verifyDescriptionField() {

	    accountName = "Selenium Description Test Account"
	            + System.currentTimeMillis();

	    String description = "Automation test description";

	    accountsPage.clickAccounts();
	    accountsPage.clickCreateAccount();

	    accountsPage.enterAccountName(accountName);
	    accountsPage.enterDescription(description);

	    AssertionUtils.assertEquals(
	            accountsPage.getDescriptionValue(),
	            description,
	            "Description field value is incorrect"
	    );

	    accountsPage.clickSaveAccount();

	    AssertionUtils.assertEquals(
	            accountsPage.getCreatedAccountName(),
	            accountName,
	            "Account with Description field was not created successfully"
	    );
	}
	
	@Test
	public void verifyInvalidEmailValidation() {

	    String accountName =
	            "Selenium Invalid Email Test Account"
	                    + System.currentTimeMillis();

	    accountsPage.clickAccounts();
	    accountsPage.clickCreateAccount();

	    accountsPage.enterAccountName(accountName);
	    accountsPage.enterEmail("invalid-email");

	    accountsPage.clickSaveAccount();

	    AssertionUtils.assertTrue(
	            accountsPage.isValidationMessageDisplayed(),
	            "Not valid validation message should be displayed for invalid email"
	    );
	}
	
	@Test
	public void verifyInvalidPhoneValidation() {

	    String accountName =
	            "Selenium Invalid Phone Test Account"
	                    + System.currentTimeMillis();

	    accountsPage.clickAccounts();
	    accountsPage.clickCreateAccount();

	    accountsPage.enterAccountName(accountName);
	    accountsPage.enterPhoneNumber("abc123");

	    accountsPage.clickSaveAccount();

	    AssertionUtils.assertTrue(
	            accountsPage.isValidationMessageDisplayed(),
	            "Not valid validation message should be displayed for invalid phone"
	    );
	}
	
	
	@AfterMethod
	public void tearDownTest() {

	    try {

	        if (accountName != null) {
	            accountsPage.deleteAccountIfPresent(accountName);
	        }

	    } finally {
	        tearDown();
	    }
	}
}

		 
		 
		


