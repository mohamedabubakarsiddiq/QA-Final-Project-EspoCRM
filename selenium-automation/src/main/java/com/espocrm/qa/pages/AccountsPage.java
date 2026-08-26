package com.espocrm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By accountsNavigation =
			By.xpath("//span[@class='full-label' and text()='Accounts']");
	
	private By accountsPageHeader =
			By.xpath("//div[@class='breadcrumb-item']/span");
	
	private By accountsList =
			By.xpath("//div[@class='list  ']");
	
	private By createAcccountButton = 
			By.xpath("//a[@data-name='create']");
	
	private By accountNameField =
			By.xpath("//input[@data-name='name']");
	
	private By saveAccountButton =
			By.xpath("//button[@data-name='save']");
	
	private By accountNameOnDetailsPage =
			By.xpath("//span[@data-action='fullRefresh' and contains(@class,'title')]");
	
	private By savingMessage =
	        By.xpath("//div[contains(@class,'message') and normalize-space()='Saving...']");
	
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(15));	
	}
	
	public void clickAccounts() {
		wait.until(ExpectedConditions.elementToBeClickable(accountsNavigation)
				).click();
	}
	
	public boolean isAccountsPageDisplayed() {
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(accountsPageHeader)
				).isDisplayed();
	}
	
	public boolean isAccountListDisplayed() {
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(accountsList)
				).isDisplayed();
	}
	
	public void clickCreateAccount() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(createAcccountButton)
				).click();
	}
	
	public void enterAccountName(String accountName) {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(accountNameField)
				).sendKeys(accountName);
	}
	
	public void clickSaveAccount() {

	    WebElement saveButton = wait.until(
	        ExpectedConditions.elementToBeClickable(saveAccountButton)
	    );

	    new Actions(driver)
	        .moveToElement(saveButton)
	        .click()
	        .perform();

	    wait.until(
	        ExpectedConditions.invisibilityOfElementLocated(savingMessage)
	    );
	}
	
	public String getCreatedAccountName() {
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(accountNameOnDetailsPage)
				).getText().trim();
	}

}
