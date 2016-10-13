package com.brooke.blogs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MessagePage {
    WebDriver driver;
    @FindBy(how = How.LINK_TEXT, linkText = "������")
    WebElement fanjianBox;// ������
    @FindBy(how = How.LINK_TEXT, linkText = "׫д�¶���Ϣ")
    WebElement newMessage;// ׫д�¶���Ϣ
    @FindBy(how = How.LINK_TEXT, linkText = "����Ϣ")
    WebElement messageBox;// ��Ϣ

    public MessagePage(WebDriver driver) {
	this.driver = driver;
    }

    public void enterMessageBox() {
	// messageBox = driver.findElement(By.linkText("����Ϣ"));
	messageBox.click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void newmessage(String to, String title, String text) {
	enterMessageBox();
	// newMessage = driver.findElement(By.linkText("׫д�¶���Ϣ"));
	newMessage.click();
	// SendMessagePage sendMessagePage = new SendMessagePage(driver);
	SendMessagePage sendMessagePage = PageFactory.initElements(driver,
		SendMessagePage.class);
	sendMessagePage.sendNewMessage(to, title, text);
    }

    public void deleteMessage() {
	enterMessageBox();
	// fanjianBox = driver.findElement(By.linkText("������"));
	fanjianBox.click();
	// FajianMessagePage fajianMessagePage = new FajianMessagePage(driver);
	FajianMessagePage fajianMessagePage = PageFactory.initElements(driver,
		FajianMessagePage.class);
	fajianMessagePage.deleteAllMessage();
    }
}
