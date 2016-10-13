package com.brooke.blogs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FajianMessagePage {
    WebDriver driver;
    @FindBy(how = How.ID, id = "chkSelAll")
    WebElement chkSelAll;
    @FindBy(how = How.ID, id = "btnBatDel")
    WebElement btnBatDelAll;

    public FajianMessagePage(WebDriver driver) {
	this.driver = driver;
	// chkSelAll = driver.findElement(By.id("chkSelAll"));
	// btnBatDelAll = driver.findElement(By.id("btnBatDel"));
    }

    public void deleteAllMessage() {
	// check box
	if (!chkSelAll.isSelected()) {
	    chkSelAll.click();
	}
	// delete all Message
	btnBatDelAll.click();
	WebDriverWait wait = new WebDriverWait(driver, 300);
	wait.until(ExpectedConditions.alertIsPresent());
	driver.switchTo().alert().accept();
    }

}
