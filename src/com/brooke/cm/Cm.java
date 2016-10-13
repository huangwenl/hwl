package com.brooke.cm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cm {
    public static void main(String[] args) {
	// System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
	// "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
	// 如果不是默认路径安装，需要先将firefox.exe配置到系统变量中去
	// System.setProperty("webdriver.ie.driver",
	// "C:/Program Files (x86)/Internet Explorer/IEDriverServer.exe");
	System.setProperty("webdriver.chrome.driver",
		"C:/Program Files (x86)/Google/Chrome/Application/chromedriver_x64.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://cm.52zzb.com/cm");
	try {
	    Thread.sleep(2000);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	WebElement element = driver.findElement(By.id("username"));
	element.sendKeys("huangwl_cs");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.id("loginBtn")).submit();
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	JavascriptExecutor j = (JavascriptExecutor) driver;
	// j.findElement(By.xpath("//*[@id='sub-8']/ul/li[1]/a")).click();
	j.executeScript("document.findElementById('123').click() ");

    }

}
