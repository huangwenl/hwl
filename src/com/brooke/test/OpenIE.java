package com.brooke.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OpenIE {
    public static void main(String[] args) {
	// 如果不是默认路径安装，需要先将firefox.exe配置到系统变量中去
	System.setProperty("webdriver.ie.driver",
		"C:/Program Files (x86)/Internet Explorer/IEDriverServer.exe");
	WebDriver driver = new InternetExplorerDriver();
	driver.get("http://www.baidu.com");
	WebElement element = driver.findElement(By.name("wd"));
	element.sendKeys("黄文亮");
	element.submit();
	try {
	    Thread.sleep(3000);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	driver.quit();
    }

}
