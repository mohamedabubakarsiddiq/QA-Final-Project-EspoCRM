package com.espocrm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	

}
