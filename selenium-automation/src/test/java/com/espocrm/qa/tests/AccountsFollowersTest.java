/*
 * package com.espocrm.qa.tests;
 * 
 * import org.testng.annotations.AfterMethod; import
 * org.testng.annotations.BeforeMethod; import org.testng.annotations.Test;
 * 
 * import com.espocrm.qa.base.BaseTest; import
 * com.espocrm.qa.pages.AccountsPage; import com.espocrm.qa.pages.LoginPage;
 * import com.espocrm.qa.utilities.AssertionUtils; import
 * com.espocrm.qa.utilities.ConfigReader;
 * 
 * public class AccountsFollowersTest extends BaseTest {
 * 
 * private AccountsPage accountsPage;
 * 
 * @BeforeMethod public void setUpTest() {
 * 
 * setUp();
 * 
 * LoginPage loginPage = new LoginPage(driver);
 * 
 * loginPage.login(ConfigReader.getProperty("username"),
 * ConfigReader.getProperty("password"));
 * 
 * accountsPage = new AccountsPage(driver);
 * 
 * }
 * 
 * 
 * @Test public void verifyFollowAccount() {
 * 
 * String accountName = "Test Account 004";
 * 
 * accountsPage.clickAccounts(); accountsPage.openAccount(accountName);
 * 
 * // Reset to initial state if already followed if
 * (accountsPage.isFollowedButtonDisplayed()) { accountsPage.clickFollowed(); }
 * 
 * AssertionUtils.assertTrue( accountsPage.waitForFollowButtonDisplayed(),
 * "Follow button should be displayed for the account" );
 * 
 * accountsPage.clickFollow();
 * 
 * AssertionUtils.assertTrue( accountsPage.waitForFollowedButtonDisplayed(),
 * "Follow button should change to Followed after clicking Follow" );
 * 
 * accountsPage.clickFollowed();
 * 
 * AssertionUtils.assertTrue( accountsPage.waitForFollowButtonDisplayed(),
 * "Followed button should change back to Follow after unfollowing" ); }
 * 
 * @AfterMethod public void tearDownTest() { tearDown(); }
 * 
 * 
 * }
 */