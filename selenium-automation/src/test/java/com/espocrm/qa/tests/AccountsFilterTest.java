package com.espocrm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.espocrm.qa.base.BaseTest;
import com.espocrm.qa.pages.AccountsPage;
import com.espocrm.qa.pages.LoginPage;
import com.espocrm.qa.utilities.AssertionUtils;
import com.espocrm.qa.utilities.ConfigReader;

public class AccountsFilterTest extends BaseTest {

    private AccountsPage accountsPage;

    @BeforeMethod
    public void setUpTest() {

        setUp();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        accountsPage = new AccountsPage(driver);
        accountsPage.clickAccounts();
    }

    @Test
    public void verifyRecentlyCreatedFilter() {

        accountsPage.clickFilter();
        accountsPage.selectRecentlyCreatedFilter();

        AssertionUtils.assertTrue(
                accountsPage.isAccountListDisplayed(),
                "Recently Created filter should display the Accounts list"
        );
    }

    @Test
    public void verifyFollowedFilter() {

        String accountName = "Test Account 004";

        accountsPage.openAccount(accountName);

        boolean wasFollowed =
                accountsPage.isFollowedButtonDisplayed();

        try {

            // Ensure the account is followed
            if (!wasFollowed) {

                accountsPage.clickFollow();

                AssertionUtils.assertTrue(
                        accountsPage.waitForFollowedButtonDisplayed(),
                        "Account should change to Followed state"
                );
            }

            // Return to Accounts list
            accountsPage.clickAccounts();

            // Select Followed filter
            accountsPage.clickFilter();
            accountsPage.selectFollowedFilter();

            AssertionUtils.assertTrue(
                    accountsPage.isFollowedFilterSelected(),
                    "Followed filter should be selected"
            );

            // Verify account appears
            AssertionUtils.assertTrue(
                    accountsPage.waitForAccountPresent(accountName),
                    "Test Account 004 should be displayed in the Followed filter"
            );

            // IMPORTANT: close the dropdown before clicking the account
            accountsPage.closeFilterMenu();

            // Open followed account
            accountsPage.openAccount(accountName);

            AssertionUtils.assertTrue(
                    accountsPage.waitForFollowedButtonDisplayed(),
                    "Account should be in Followed state"
            );

            // Unfollow
            accountsPage.clickFollowed();

            AssertionUtils.assertTrue(
                    accountsPage.waitForFollowButtonDisplayed(),
                    "Account should return to Follow state"
            );

            accountsPage.clickAccounts();

            accountsPage.clickFilter();

            accountsPage.reapplyFollowedFilter();

            accountsPage.closeFilterMenu();

            AssertionUtils.assertTrue(
                    accountsPage.waitForAccountAbsent(accountName),
                    "Unfollowed account should not appear in the Followed filter"
            );

        } finally {

             // Restore the original state only when necessary
            if (wasFollowed) {

                // Go back to Accounts
                accountsPage.clickAccounts();

                // Switch back to All accounts
                accountsPage.clickFilter();
                accountsPage.selectAllFilter();
                accountsPage.closeFilterMenu();

                // Open the account
                accountsPage.openAccount(accountName);

                // Restore Followed state
                if (accountsPage.isFollowButtonDisplayed()) {
                    accountsPage.clickFollow();
                    accountsPage.waitForFollowedButtonDisplayed();
                }
            }}

        }

    @Test
    public void verifyOnlyMyFilter() {

        String accountName = "Test Account 004";

        accountsPage.clickFilter();
        accountsPage.selectOnlyMyFilter();

        AssertionUtils.assertTrue(
                accountsPage.isOnlyMyFilterSelected(),
                "Only My filter should be selected"
        );

        AssertionUtils.assertTrue(
                accountsPage.isAccountPresent(accountName),
                "Test Account 004 should be displayed under Only My filter"
        );
    }

    @Test
    public void verifyStarredFilter() {

        String accountName = "Test Account 004";

        // Start from All Accounts
        accountsPage.clickFilter();
        accountsPage.selectAllFilter();
        accountsPage.closeFilterMenu();

        accountsPage.openAccount(accountName);
        accountsPage.clickAccountMoreActions();

        // Capture initial state
        boolean wasStarred =
                accountsPage.isStarredButtonDisplayed();

        try {

            // Ensure the account is starred
            if (!wasStarred) {

                accountsPage.clickStar();

                AssertionUtils.assertTrue(
                        accountsPage.waitForStarredButtonDisplayed(),
                        "Account should change to Starred state"
                );
            }

            // Return to Accounts
            accountsPage.clickAccounts();

            // Select Starred filter
            accountsPage.clickFilter();
            accountsPage.selectStarredFilter();
            accountsPage.closeFilterMenu();

            // Verify account appears
            AssertionUtils.assertTrue(
                    accountsPage.waitForAccountPresent(accountName),
                    "Starred account should appear in the Starred filter"
            );

            // Open the starred account
            accountsPage.openAccount(accountName);

            accountsPage.clickAccountMoreActions();

            AssertionUtils.assertTrue(
                    accountsPage.waitForStarredButtonDisplayed(),
                    "Account should remain in Starred state"
            );

            // Unstar the account
            accountsPage.clickStarred();

            AssertionUtils.assertTrue(
                    accountsPage.waitForStarButtonDisplayed(),
                    "Account should return to Star state after unstar"
            );

            // Return to Accounts
            accountsPage.clickAccounts();

            // Reapply Starred filter
            accountsPage.clickFilter();
            accountsPage.selectStarredFilter();
            accountsPage.closeFilterMenu();

            // Verify unstarred account disappears
            AssertionUtils.assertTrue(
                    accountsPage.waitForAccountAbsent(accountName),
                    "Unstarred account should not appear in the Starred filter"
            );

        } finally {

            // Restore original state only if it was initially starred
            if (wasStarred) {

                accountsPage.clickAccounts();

                accountsPage.clickFilter();
                accountsPage.selectAllFilter();
                accountsPage.closeFilterMenu();

                accountsPage.openAccount(accountName);

                if (accountsPage.isStarButtonDisplayed()) {
                    accountsPage.clickStar();
                    accountsPage.waitForStarredButtonDisplayed();
                }
            }
        }
    }

    @Test
    public void verifyAllFilter() {
        String accountName = "Test Account 004";

        accountsPage.clickFilter();
        accountsPage.selectAllFilter();

        AssertionUtils.assertTrue(accountsPage.isAccountPresent(accountName),
                "Test Account 004 should be displayed under the All filter");
    }


    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}