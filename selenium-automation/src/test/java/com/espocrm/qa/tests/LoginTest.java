package com.espocrm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.espocrm.qa.base.BaseTest;
import com.espocrm.qa.pages.LoginPage;
import com.espocrm.qa.utilities.AssertionUtils;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        setUp();
        loginPage = new LoginPage(driver);
    }

    @Test(
    		dataProvider = "loginData",
    		dataProviderClass = LoginDataProvider.class
    		)
   public void verifyLogin(
		   String username,
		   String password,
		   boolean shouldLogin
		   ) {
    	
    	loginPage.login(username, password);
    	
    	if (shouldLogin) {
			
    		AssertionUtils.assertTrue(loginPage.isLoggedIn(), 
    				"User should be successfully logged in"); 	
    	
    } else {
    	
    	AssertionUtils.assertTrue(loginPage.isLoginErrorDisplayed(), 
    			"wrong username/password"
    			);
    }
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}