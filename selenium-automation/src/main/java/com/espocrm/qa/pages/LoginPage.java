package com.espocrm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	 private WebDriver driver;
	 
	 //Login Page locators
	 
	 private By usernameField = By.xpath("//input[@id='field-userName']");
	 private By passwordField = By.xpath("//input[@id='field-password']");
	 private By loginButton = By.xpath("//button[@id='btn-login']");
	 private By loginErrorMessage = By.xpath("//div[@class='message']");

	 private WebDriverWait wait;
	 
	 
	 //Element visible after successful login
	 private By dashboardNavigation = By.xpath("//span[@class='full-label']");
	 
	 //Constructor
	 
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	//Page actions
	
	// Enter username
	
	public void enterUsername (String username) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)
				).sendKeys(username);
	}
	
	// Enter password
	
	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)
				).sendKeys(password);
	}
	
	// Click Login
	
	public void clickLogin() {
		wait.until(
				ExpectedConditions.elementToBeClickable(loginButton)).click();
	}
	
	//Perform login
	
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}
	
	// verify successful login
	public boolean isLoggedIn() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
				dashboardNavigation)).isDisplayed();
	}
	
	public boolean isLoginErrorDisplayed() {
	    return wait.until(driver -> {
	    	try {
				return driver.findElement(loginErrorMessage).isDisplayed();
			} catch (org.openqa.selenium.StaleElementReferenceException e) {
				return false;
			}
	    });
	}
	

}
