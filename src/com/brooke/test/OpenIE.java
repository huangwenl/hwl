package com.brooke.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OpenIE {
    public static void main(String[] args) {
	// �������Ĭ��·����װ����Ҫ�Ƚ�firefox.exe���õ�ϵͳ������ȥ
	System.setProperty("webdriver.ie.driver",
		"C:/Program Files (x86)/Internet Explorer/IEDriverServer.exe");
	WebDriver driver = new InternetExplorerDriver();
	driver.get("http://www.baidu.com");
	WebElement element = driver.findElement(By.name("wd"));
	element.sendKeys("������");
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
