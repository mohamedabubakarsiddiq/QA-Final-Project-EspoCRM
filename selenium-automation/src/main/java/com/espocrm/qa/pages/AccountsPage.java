package com.espocrm.qa.pages;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
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

	private By validationMessage =
	        By.xpath("//div[@class='message' and normalize-space()='Not valid']");

	private By cancelAccountButton =
			By.xpath("//button[@data-name='cancel' and @data-action='cancel']");

	private By websiteField =
			By.xpath("//input[@data-name='website']");

	private By phoneNumberField =
			By.xpath("//input[contains(@class,'phone-number')]");

	private By emailField =
			By.xpath("//input[contains(@class,'email-address')]");

	private By descriptionField =
			By.xpath("//textarea[@data-name='description']");

	private By accountDuplicateOption =
			By.xpath("//a[@data-name='duplicate' and @data-action='duplicate']");

	private By duplicateWarning =
			By.xpath("//div[contains(@class,'modal-body') and contains(@class,'body')]"
		               + "//h4[normalize-space()='The record you are creating might already exist']");

	private By duplicateModal =
	        By.xpath("//div[contains(@class,'modal-body') and contains(@class,'body')]");

	private By duplicateCancelButton =
			By.xpath("//button[@data-name='cancel' and normalize-space()='Cancel']");

	private By duplicateWarningCancelButton =
	        By.xpath("//div[contains(@class,'dialog') and contains(@class,'modal') and @role='dialog'"
	               + "][.//h4[normalize-space()='The record you are creating might already exist']]"
	               + "//button[@data-name='cancel']");

	private By duplicateWarningDialog =
	        By.xpath("//div[contains(@class,'dialog') and contains(@class,'modal') and @role='dialog'"
	               + "][.//h4[normalize-space()='The record you are creating might already exist']]");

	private By deleteConfirmationMessage =
			By.xpath("//span[contains(@class,'confirm-message')]"
               + "//p[normalize-space()='Are you sure you want to remove the record?']");

	private By deleteConfirmationCancelButton =
	        By.xpath("//span[contains(@class,'confirm-message')]" +
	                 "/ancestor::div[contains(@class,'dialog') or contains(@class,'modal')]" +
	                 "//button[@data-name='cancel']");

	private By viewPersonalDataOption =
			By.xpath("//a[normalize-space()='View Personal Data']");

	private By personalDataDialog(String accountName) {
	    return By.xpath(
	        "//*[contains(normalize-space(), 'Personal Data:')"
	        + " and contains(normalize-space(), '" + accountName + "')]"
	    );
	}

	private By personalDataCloseButton(String accountName) {
	    return By.xpath(
	        "//*[contains(normalize-space(), 'Personal Data:')"
	        + " and contains(normalize-space(), '" + accountName + "')]"
	        + "/ancestor::div[contains(@class,'dialog') or contains(@class,'modal')]"
	        + "//button[normalize-space()='Close']"
	    );
	}

	private By followButton =
	        By.xpath("//button[@data-name='follow' and @data-action='follow']");

	private By followedButton =
	        By.xpath("//button[@data-name='unfollow' and @data-action='unfollow']");

	private By filterButton =
	        By.xpath("//button[@title='Filter']");

	private By allFilter =
	        By.xpath("//a[@class='preset' and @data-action='selectPreset'"
	                + " and .//div[normalize-space()='All']]");

	private By starredFilter =
	        By.xpath("//a[@class='preset' and @data-name='starred'"
	                + " and @data-action='selectPreset']");

	private By recentlyCreatedFilter =
	        By.xpath("//a[@class='preset' and @data-name='recentlyCreated'"
	                + " and @data-action='selectPreset']");

	private By onlyMyFilter =
	        By.xpath("//input[@data-role='boolFilterCheckbox'"
	                + " and @data-name='onlyMy']");

	private By followedFilter =
	        By.xpath("//input[@data-role='boolFilterCheckbox'"
	                + " and @data-name='followed']");

	private By filterMenu =
	        By.cssSelector("ul.filter-menu");

	private By starButton =
			By.xpath("//button[@data-name='star' and @data-action='star']");

	private By starredButton =
			By.xpath("//button[@data-name='unstar' and @data-action='unstar']");


	private By viewUserAccessOption =
	        By.xpath("//a[@data-name='viewUserAccess' and @data-action='viewUserAccess']");

	private By userAccessList =
	        By.xpath("//div[contains(@class,'list') and @data-scope='User']");

	private By userAccessReadHeader =
	        By.xpath("//div[@data-scope='User']//th[@data-name='recordAccessLevelread']");

	private By userAccessEditHeader =
	        By.xpath("//div[@data-scope='User']//th[@data-name='recordAccessLeveledit']");

	private By userAccessDeleteHeader =
	        By.xpath("//div[@data-scope='User']//th[@data-name='recordAccessLeveldelete']");

	private By userAccessStreamHeader =
	        By.xpath("//div[@data-scope='User']//th[@data-name='recordAccessLevelstream']");

	private By viewAuditLogOption =
	        By.xpath("//a[@data-name='viewAuditLog' and @data-action='viewAuditLog']");

	private By auditLogList =
	        By.xpath("//div[contains(@class,'modal-body')]"
	                + "//div[contains(@class,'record') and contains(@class,'list-container')]"
	                + "//div[contains(@class,'list-expanded')]");

	private By auditLogEntry =
	        By.xpath("//div[contains(@class,'modal-body')]"
	                + "//span[contains(@class,'message') and contains(normalize-space(), 'updated this account')]");

	private By lockAccountOption =
	        By.xpath("//a[@data-name='lock' and @data-action='lock']");

	private By unlockAccountOption =
	        By.xpath("//a[@data-name='unlock' and @data-action='unlock']");

	private By recordLockedMessage =
	        By.xpath("//*[contains(normalize-space(), 'Record is locked')]");

	public void clickLockAccount() {
	    wait.until(
	            ExpectedConditions.elementToBeClickable(lockAccountOption)
	    ).click();
	}

	public void clickUnlockAccount() {
	    wait.until(
	            ExpectedConditions.elementToBeClickable(unlockAccountOption)
	    ).click();
	}

	public boolean deleteAccountIfPresent(String accountName) {

	    try {

	        // First try deleting directly from the current account details page
	        if (isCurrentAccountDetailsPage(accountName)) {

	            clickAccountMoreActions();
	            clickAccountDeleteOption();
	            confirmRemoveAccount();

	            return true;
	        }

	        // Fallback: navigate to Accounts and search
	        clickAccounts();

	        WebDriverWait cleanupWait =
	                new WebDriverWait(driver, Duration.ofSeconds(30));

	        WebElement searchField = cleanupWait.until(
	                ExpectedConditions.visibilityOfElementLocated(accountSearchField)
	        );

	        searchField.clear();
	        searchField.sendKeys(accountName);

	        if (!isAccountSearchResultDisplayed(accountName)) {
	            return false;
	        }

	        openAccount(accountName);
	        clickAccountMoreActions();
	        clickAccountDeleteOption();
	        confirmRemoveAccount();

	        return isAccountDeleted(accountName);

	    } catch (TimeoutException |
	             NoSuchElementException |
	             StaleElementReferenceException |
	             ElementClickInterceptedException e) {

	        System.out.println(
	                "Cleanup failed for account '" +
	                accountName + "'."
	        );

	        System.out.println(
	                "Exception: " + e.getClass().getSimpleName()
	                        + " - " + e.getMessage()
	        );

	        return false;
	    }
	}

	public boolean isLockOptionDisplayed() {

	    return wait.until(driver -> {

	        try {
	            var elements = driver.findElements(lockAccountOption);

	            return !elements.isEmpty()
	                    && elements.get(0).isDisplayed();

	        } catch (StaleElementReferenceException e) {
	            return false;
	        }
	    });
	}

	public boolean isUnlockOptionDisplayed() {
	    return !driver.findElements(unlockAccountOption).isEmpty()
	            && driver.findElements(unlockAccountOption).get(0).isDisplayed();
	}

	public boolean isRecordLockedMessageDisplayed() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                    recordLockedMessage
	            )
	    ).isDisplayed();
	}



	public void clickViewAuditLog() {
	    wait.until(
	            ExpectedConditions.elementToBeClickable(viewAuditLogOption)
	    ).click();
	}

	public boolean isAuditLogDisplayed() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(auditLogList)
	    ).isDisplayed();
	}

	public boolean isAuditLogEntryDisplayed() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(auditLogEntry)
	    ).isDisplayed();
	}



	public void clickViewUserAccess() {
	    wait.until(
	            ExpectedConditions.elementToBeClickable(viewUserAccessOption)
	    ).click();
	}

	public boolean isUserAccessListDisplayed() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(userAccessList)
	    ).isDisplayed();
	}

	public boolean areUserAccessLevelsDisplayed() {

	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(userAccessReadHeader)
	    ).isDisplayed()
	    &&
	    wait.until(
	            ExpectedConditions.visibilityOfElementLocated(userAccessEditHeader)
	    ).isDisplayed()
	    &&
	    wait.until(
	            ExpectedConditions.visibilityOfElementLocated(userAccessDeleteHeader)
	    ).isDisplayed()
	    &&
	    wait.until(
	            ExpectedConditions.visibilityOfElementLocated(userAccessStreamHeader)
	    ).isDisplayed();
	}


	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public void clickAccounts() {

	    wait.until(
	            ExpectedConditions.elementToBeClickable(accountsNavigation)
	    ).click();

	    // Wait only for the Accounts page itself
	    wait.until(
	            ExpectedConditions.visibilityOfElementLocated(accountsPageHeader)
	    );
	}

	public boolean isCurrentAccountDetailsPage(String accountName) {

	    try {
	        WebDriverWait detailsWait =
	                new WebDriverWait(driver, Duration.ofSeconds(5));

	        return detailsWait.until(driver -> {

	            try {
	                WebElement title =
	                        driver.findElement(accountNameOnDetailsPage);

	                return title.isDisplayed()
	                        && title.getText().trim().equals(accountName);

	            } catch (NoSuchElementException |
	                     StaleElementReferenceException e) {

	                return false;
	            }
	        });

	    } catch (TimeoutException e) {
	        return false;
	    }
	}

	public boolean isAccountsPageDisplayed() {
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(accountsPageHeader)
				).isDisplayed();
	}

	public boolean isValidationMessageDisplayed() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(validationMessage)
	    ).isDisplayed();
	}

	public boolean isAccountListDisplayed() {

	    return wait.until(driver -> {

	        try {

	            var elements = driver.findElements(accountsList);

	            if (elements.isEmpty()) {
	                return false;
	            }

	            return elements.get(0).isDisplayed();

	        } catch (org.openqa.selenium.StaleElementReferenceException e) {

	            // EspoCRM may replace the list DOM during filter refresh.
	            return false;
	        }
	    });
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

	public void openAccount(String accountName) {

	    By accountLink = By.xpath(
	            "//a[@class='link' and @title='" + accountName + "']"
	    );

	    wait.until(driver -> {

	        try {

	            WebElement link = driver.findElement(accountLink);

	            if (!link.isDisplayed() || !link.isEnabled()) {
	                return false;
	            }

	            link.click();
	            return true;

	        } catch (org.openqa.selenium.StaleElementReferenceException e) {
	            return false;

	        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
	            return false;
	        }
	    });
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

	public boolean waitForAccountPresent(String accountName) {

	    By accountLink = By.xpath(
	            "//a[@class='link' and @title='" + accountName + "']"
	    );

	    return wait.until(driver -> {
	        var elements = driver.findElements(accountLink);

	        return !elements.isEmpty() && elements.get(0).isDisplayed();
	    });
	}

	public boolean waitForAccountAbsent(String accountName) {

	    By accountLink = By.xpath(
	            "//a[@class='link' and @title='" + accountName + "']"
	    );

	    return wait.until(driver ->
	            driver.findElements(accountLink).isEmpty()
	    );
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

	public boolean isAccountnameValidationDisplayed() {
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated
				(validationMessage)).isDisplayed();
	}

	public void clickCancelAccount() {

		wait.until(
				ExpectedConditions.elementToBeClickable(cancelAccountButton)
				).click();
	}

	public void enterWebsite(String website) {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(websiteField)
				).sendKeys(website);
	}

	public void enterPhoneNumber (String phoneNumber) {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(phoneNumberField)
				).sendKeys(phoneNumber);
	}

	public void enterEmail(String email) {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(emailField)
				).sendKeys(email);
	}

	public void enterDescription(String description) {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(descriptionField)
				).sendKeys(description);
	}

	public String getWebsiteValue() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(websiteField)
	    ).getAttribute("value");
	}

	public String getPhoneNumberValue() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(phoneNumberField)
	    ).getAttribute("value");
	}

	public String getEmailValue() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(emailField)
	    ).getAttribute("value");
	}

	public String getDescriptionValue() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(descriptionField)
	    ).getAttribute("value");
	}

	public void clickAccountDuplicate() {
		wait.until(
				ExpectedConditions.elementToBeClickable(accountDuplicateOption)
				).click();
	}

	public boolean isDuplicateWarningDisplayed() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(duplicateWarningDialog)
	    ).isDisplayed();
	}

	public void clickDuplicateCancel() {
		wait.until(
				ExpectedConditions.elementToBeClickable(duplicateCancelButton)
				).click();
	}

	public void clickDuplicateWarningCancel() {
	    wait.until(
	            ExpectedConditions.elementToBeClickable(duplicateWarningCancelButton)
	    ).click();
	}

	public boolean isDeleteConfirmationDisplayed() {
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(deleteConfirmationMessage)
				).isDisplayed();
	}

	public void cancelDeleteConfirmation() {
	    wait.until(
	            ExpectedConditions.elementToBeClickable(deleteConfirmationCancelButton)
	    ).click();
	}

	public void clickViewPersonalData() {
	    wait.until(
	            ExpectedConditions.elementToBeClickable(viewPersonalDataOption)
	    ).click();
	}

	public boolean isPersonalDataDisplayed(String accountName) {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                    personalDataDialog(accountName)
	            )
	    ).isDisplayed();
	}

	public void closePersonalData(String accountName) {
	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    personalDataCloseButton(accountName)
	            )
	    ).click();
	}

	public boolean isFollowButtonDisplayed() {
	    return !driver.findElements(followButton).isEmpty()
	            && driver.findElements(followButton).get(0).isDisplayed();
	}

	public boolean isFollowedButtonDisplayed() {
	    return !driver.findElements(followedButton).isEmpty()
	            && driver.findElements(followedButton).get(0).isDisplayed();
	}

	public boolean waitForFollowButtonDisplayed() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(followButton)
	    ).isDisplayed();
	}

	public boolean waitForFollowedButtonDisplayed() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(followedButton)
	    ).isDisplayed();
	}

	public void clickFollow() {
	    wait.until(
	            ExpectedConditions.elementToBeClickable(followButton)
	    ).click();
	}

	public void clickFollowed() {
	    wait.until(
	            ExpectedConditions.elementToBeClickable(followedButton)
	    ).click();
	}

	public void printFollowStateDebug() {

	    System.out.println("=== FOLLOW STATE DEBUG ===");

	    var elements = driver.findElements(
	            By.xpath("//button[@data-name='follow' or @data-name='unfollow']")
	    );

	    System.out.println("Buttons found: " + elements.size());

	    for (WebElement element : elements) {
	        System.out.println(
	                "data-name=" + element.getAttribute("data-name")
	                + ", data-action=" + element.getAttribute("data-action")
	                + ", text=" + element.getText()
	                + ", displayed=" + element.isDisplayed()
	                + ", enabled=" + element.isEnabled()
	        );
	    }

	    System.out.println("=== END FOLLOW STATE DEBUG ===");
	}

	public void clickFilter() {
	    wait.until(
	            ExpectedConditions.elementToBeClickable(filterButton)
	    ).click();
	}

	public void selectAllFilter() {
	    wait.until(
	            ExpectedConditions.elementToBeClickable(allFilter)
	    ).click();
	}

	public void selectStarredFilter() {
	    wait.until(
	            ExpectedConditions.elementToBeClickable(starredFilter)
	    ).click();
	}

	public void selectRecentlyCreatedFilter() {
	    wait.until(
	            ExpectedConditions.elementToBeClickable(recentlyCreatedFilter)
	    ).click();
	}

	public void selectOnlyMyFilter() {

	    WebElement checkbox = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(onlyMyFilter)
	    );

	    if (!checkbox.isSelected()) {
	        checkbox.click();
	    }

	    wait.until(driver -> {
	        try {
	            WebElement currentCheckbox =
	                    driver.findElement(onlyMyFilter);

	            return currentCheckbox.isSelected();

	        } catch (org.openqa.selenium.StaleElementReferenceException e) {
	            return false;
	        }
	    });
	}

	public void selectFollowedFilter() {

	    WebElement checkbox = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(followedFilter)
	    );

	    if (!checkbox.isSelected()) {
	        checkbox.click();
	    }

	    wait.until(driver -> {
	        try {
	            WebElement currentCheckbox =
	                    driver.findElement(followedFilter);

	            return currentCheckbox.isSelected();

	        } catch (org.openqa.selenium.StaleElementReferenceException e) {
	            return false;
	        }
	    });
	}

	public boolean isOnlyMyFilterSelected() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(onlyMyFilter)
	    ).isSelected();
	}

	public boolean isFollowedFilterSelected() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(followedFilter)
	    ).isSelected();
	}

	public void closeFilterMenu() {

	    try {
	        WebElement menu = driver.findElement(filterMenu);

	        // Menu is already closed
	        if (!menu.isDisplayed()) {
	            return;
	        }

	        // Menu is open, so close it
	        wait.until(
	                ExpectedConditions.elementToBeClickable(filterButton)
	        ).click();

	        wait.until(driver -> {

	            try {
	                var menus = driver.findElements(filterMenu);

	                return menus.isEmpty()
	                        || !menus.get(0).isDisplayed();

	            } catch (org.openqa.selenium.StaleElementReferenceException e) {
	                return true;
	            }
	        });

	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        // Menu is not present; nothing to close
	    }
	}

	public void reapplyFollowedFilter() {

	    WebElement checkbox = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(followedFilter)
	    );

	    // If already selected, turn it off first.
	    if (checkbox.isSelected()) {

	        checkbox.click();

	        wait.until(driver -> {
	            try {
	                return !driver.findElement(followedFilter).isSelected();
	            } catch (org.openqa.selenium.StaleElementReferenceException e) {
	                return false;
	            }
	        });
	    }

	    // Select Followed again.
	    wait.until(
	            ExpectedConditions.elementToBeClickable(followedFilter)
	    ).click();

	    wait.until(driver -> {
	        try {
	            return driver.findElement(followedFilter).isSelected();
	        } catch (org.openqa.selenium.StaleElementReferenceException e) {
	            return false;
	        }
	    });
	}

	public boolean isStarButtonDisplayed() {
	    return !driver.findElements(starButton).isEmpty()
	            && driver.findElements(starButton).get(0).isDisplayed();
	}

	public boolean isStarredButtonDisplayed() {
	    return !driver.findElements(starredButton).isEmpty()
	            && driver.findElements(starredButton).get(0).isDisplayed();
	}

	public boolean waitForStarButtonDisplayed() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(starButton)
	    ).isDisplayed();
	}

	public boolean waitForStarredButtonDisplayed() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(starredButton)
	    ).isDisplayed();
	}

	public void clickStar() {
	    wait.until(
	            ExpectedConditions.elementToBeClickable(starButton)
	    ).click();
	}

	public void clickStarred() {
	    wait.until(
	            ExpectedConditions.elementToBeClickable(starredButton)
	    ).click();
	}






}
