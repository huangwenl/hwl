package com.brooke.blogs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MessagePage {
    WebDriver driver;
    @FindBy(how = How.LINK_TEXT, linkText = "发件箱")
    WebElement fanjianBox;// 发件箱
    @FindBy(how = How.LINK_TEXT, linkText = "撰写新短消息")
    WebElement newMessage;// 撰写新短消息
    @FindBy(how = How.LINK_TEXT, linkText = "短消息")
    WebElement messageBox;// 消息

    public MessagePage(WebDriver driver) {
	this.driver = driver;
    }

    public void enterMessageBox() {
	// messageBox = driver.findElement(By.linkText("短消息"));
	messageBox.click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void newmessage(String to, String title, String text) {
	enterMessageBox();
	// newMessage = driver.findElement(By.linkText("撰写新短消息"));
	newMessage.click();
	// SendMessagePage sendMessagePage = new SendMessagePage(driver);
	SendMessagePage sendMessagePage = PageFactory.initElements(driver,
		SendMessagePage.class);
	sendMessagePage.sendNewMessage(to, title, text);
    }

    public void deleteMessage() {
	enterMessageBox();
	// fanjianBox = driver.findElement(By.linkText("发件箱"));
	fanjianBox.click();
	// FajianMessagePage fajianMessagePage = new FajianMessagePage(driver);
	FajianMessagePage fajianMessagePage = PageFactory.initElements(driver,
		FajianMessagePage.class);
	fajianMessagePage.deleteAllMessage();
    }
}
