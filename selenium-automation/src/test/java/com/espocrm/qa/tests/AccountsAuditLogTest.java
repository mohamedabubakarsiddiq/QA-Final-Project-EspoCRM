package com.espocrm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.espocrm.qa.base.BaseTest;
import com.espocrm.qa.pages.AccountsPage;
import com.espocrm.qa.pages.LoginPage;
import com.espocrm.qa.utilities.AssertionUtils;
import com.espocrm.qa.utilities.ConfigReader;

public class AccountsAuditLogTest extends BaseTest {

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
    public void verifyAccountAuditLog() {

        String accountName = "Test Account 004";

        accountsPage.openAccount(accountName);
        accountsPage.clickAccountMoreActions();
        accountsPage.clickViewAuditLog();

        AssertionUtils.assertTrue(
                accountsPage.isAuditLogDisplayed(),
                "Audit Log should be displayed"
        );

        AssertionUtils.assertTrue(
                accountsPage.isAuditLogEntryDisplayed(),
                "Audit Log should contain account update entries"
        );
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}