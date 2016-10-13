package com.brooke.blogs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SendMessagePage {
    WebDriver driver;
    @FindBy(how = How.ID, id = "txtIncept")
    WebElement toUser;
    @FindBy(how = How.ID, id = "txtTitle")
    WebElement titleContent;
    @FindBy(how = How.ID, id = "txtContent")
    WebElement textContent;
    @FindBy(how = How.ID, id = "btnSend")
    WebElement sendBotton;

    public SendMessagePage(WebDriver driver) {
	this.driver = driver;
	// toUser = driver.findElement(By.id("txtIncept"));
	// titleContent = driver.findElement(By.id("txtTitle"));
	// textContent = driver.findElement(By.id("txtContent"));
	// sendBotton = driver.findElement(By.id("btnSend"));
    }

    public void sendNewMessage(String to, String title, String text) {
	toUser.sendKeys(to);
	titleContent.sendKeys(title);
	textContent.sendKeys(text);
	sendBotton.click();
    }
}
