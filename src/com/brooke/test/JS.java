package com.brooke.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JS {
    public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver",
		"C:/Program Files (x86)/Google/Chrome/Application/chromedriver_x64.exe");
	WebDriver driver = new ChromeDriver();
	// ������������ڴ�С
	// driver.manage().window().setSize(new Dimension(700, 600));
	driver.get("http://www.baidu.com");
	driver.findElement(By.id("kw")).sendKeys("webdriver api");
	driver.findElement(By.id("su")).click();
	Thread.sleep(2000);
	// ��ҳ��������ϵ��ײ�
	((JavascriptExecutor) driver)
		.executeScript("window.scrollTo(200,450);");
	Thread.sleep(3000);
	System.out.println("end");
	// driver.quit();
    }
}