package com.brooke.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestwebListener {

    public static void main(String[] args) {
	MyListener myListener = new MyListener();
	System.setProperty("webdriver.chrome.driver",
		"C:/Program Files (x86)/Google/Chrome/Application/chromedriver_x64.exe");
	WebDriver driver = new ChromeDriver();
	// ×¢²á¼àÌýÀà
	EventFiringWebDriver event = new EventFiringWebDriver(driver);
	event.register(myListener);
	event.get("http://www.baidu.com");
	event.get("http://www.zhihu.com");
	event.navigate().to("http://www.baidu.com");
	event.findElement(By.id("su")).click();

    }

}
