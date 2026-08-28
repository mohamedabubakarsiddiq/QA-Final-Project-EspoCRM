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
			By.cssSelector("div.list");
	
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
	
	private By editAccountButton =
			By.xpath("//button[@data-name='edit']");
	
	private By accountSearchField =
			By.xpath("//input[@data-name='textFilter']");
	
	private By clickRemoveAccount =
			By.xpath("//a[@data-action='quickRemove']");
	
	private By accountRowDropdown(String accountName) {
		return By.xpath("//tr[@class='list-row' and .//a[@title='" + accountName + "']]"
		        + "//span[@class='caret']");
	}
	
	private By removeAccountOption(String accountName) {
	    return By.xpath(
	        "//tr[@class='list-row' and .//a[@title='" + accountName + "']]"
	        + "//a[@data-action='quickRemove']"
	    );
	}
	
	private By confirmRemoveButton =
			By.xpath("//button[@data-name='confirm']");
	
	private By accountMoreActionsButton =
			By.xpath("//button[@data-toggle='dropdown' and contains(@class,'dropdown-item-list-button')]");
	
	private By accountDeleteOption =
			By.xpath("//a[@data-name='delete' and @data-action='delete']");
	
	
			
	
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(15));	
	}
	
	public void clickAccounts() {
		wait.until(ExpectedConditions.elementToBeClickable(accountsNavigation)
				).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountsList));
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
	
	public void clickEditAccount() {
		wait.until(
				ExpectedConditions.elementToBeClickable(editAccountButton)
				).click();
	}
	
	public void  openAccount(String accountName) {
		
		By accountlink = By.xpath("//a[@class='link' and @title='" + accountName + "']");
		
		wait.until(ExpectedConditions.elementToBeClickable(accountlink)).click();
	}
	
	public void editAccountName(String newAccountName) {
		WebElement nameField = wait.until(
				ExpectedConditions.visibilityOfElementLocated(accountNameField));
		
		nameField.clear();
		nameField.sendKeys(newAccountName);
		
	}
	
	public String getAccountNameOnDetailsPage() {
		
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(accountNameOnDetailsPage)
				).getText().trim();
		
	}
	
	public void createAccount(String accountName) {
		clickAccounts();
		clickCreateAccount();
		enterAccountName(accountName);
		clickSaveAccount();
	}
	
	public void searchAccount(String accountName) {

	    wait.until(
	            ExpectedConditions.visibilityOfElementLocated(accountsList)
	    );

	    WebElement searchField = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(accountSearchField)
	    );

	    searchField.clear();
	    searchField.sendKeys(accountName);
	}
	
	public boolean isAccountSearchResultDisplayed(String accountName) {
		
		By accountresult = By.xpath("//a[@class='link' and @title='" + accountName + "']"
				);
		
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(accountresult)
				).isDisplayed();
		
	}
	
	public void clickAccountRowDropdown(String accountName) {

	    By accountLink = By.xpath(
	        "//tr[contains(@class,'list-row')]//a[@title='" + accountName + "']"
	    );

	    By dropdownButton = By.xpath(
	        "//tr[contains(@class,'list-row') and .//a[@title='" + accountName + "']]"
	        + "//button[contains(@class,'dropdown-toggle')]"
	    );

	    wait.until(
	        ExpectedConditions.visibilityOfElementLocated(accountLink)
	    );

	    wait.until(
	        ExpectedConditions.elementToBeClickable(dropdownButton)
	    ).click();
	}
	
	public void clickRemoveAccount(String accountName) {

	    By removeOption = By.xpath(
	        "//tr[contains(@class,'list-row') and .//a[@title='" + accountName + "']]"
	        + "//a[@data-action='quickRemove']"
	    );

	    wait.until(
	        ExpectedConditions.elementToBeClickable(removeOption)
	    ).click();
	}

	public void confirmRemoveAccount() {
	    wait.until(
	        ExpectedConditions.elementToBeClickable(confirmRemoveButton)
	    ).click();
	}
	
	public boolean isAccountDeleted(String accountName) {
		By accountLink = By.xpath("//tr[contains(@class,'list-row')]//a[@title='" + accountName + "']");
		
		return wait.until(
				ExpectedConditions.invisibilityOfElementLocated(accountLink));
	}
	
	public boolean isAccountPresent(String accountName) {
		
		By accountLink = By.xpath( "//a[@class='link' and @title='" + accountName + "']");
		
		return !driver.findElements(accountLink).isEmpty();
		
	}
	
	
	public void clickAccountMoreActions() {
		wait.until(
				ExpectedConditions.elementToBeClickable(accountMoreActionsButton)
				).click();
	}
	
	public void clickAccountDeleteOption() {
		wait.until(
				ExpectedConditions.elementToBeClickable(accountDeleteOption)
				).click();
	}
	
	
	
	
	
	
	
	

}
