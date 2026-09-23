package com.espocrm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.espocrm.qa.base.BaseTest;
import com.espocrm.qa.pages.AccountsPage;
import com.espocrm.qa.pages.LoginPage;
import com.espocrm.qa.utilities.AssertionUtils;
import com.espocrm.qa.utilities.ConfigReader;

public class AccountsUserAccessTest extends BaseTest {

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
    public void verifyAccountUserAccess() {

        String accountName = "Test Account 004";

        accountsPage.openAccount(accountName);
        accountsPage.clickAccountMoreActions();
        accountsPage.clickViewUserAccess();

        AssertionUtils.assertTrue(
                accountsPage.isUserAccessListDisplayed(),
                "User Access list should be displayed"
        );

        AssertionUtils.assertTrue(
                accountsPage.areUserAccessLevelsDisplayed(),
                "Read, Edit, Delete and Stream access levels should be displayed"
        );
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}