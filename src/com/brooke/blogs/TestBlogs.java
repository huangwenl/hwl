package com.brooke.blogs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class TestBlogs {

    public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver",
		"C:/Program Files (x86)/Google/Chrome/Application/chromedriver_x64.exe");
	WebDriver driver = new ChromeDriver();
	// MainPage mainpage = new MainPage(driver);
	// MessagePage messagePage = new MessagePage(driver);
	MainPage mainpage = PageFactory.initElements(driver, MainPage.class);
	MessagePage messagePage = PageFactory.initElements(driver,
		MessagePage.class);
	mainpage.openMain("http://www.cnblogs.com/");
	mainpage.login("huanghuangwen", "woaini1314?");
	messagePage.newmessage("jiang1988jian", "test2", "test2");
	// messagePage.deleteMessage();
	mainpage.logout();
    }
}
