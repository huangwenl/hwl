package com.brooke.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBlogWeb {

    /**
     * @param args
     */
    public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver",
		"C:/Program Files (x86)/Google/Chrome/Application/chromedriver_x64.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://www.cnblogs.com/");
	driver.findElement(By.linkText("��¼")).click();
	WebDriverWait wait = new WebDriverWait(driver, 300);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By
		.id("input1")));
	driver.findElement(By.id("input1")).sendKeys("huanghuangwen");
	driver.findElement(By.id("input2")).sendKeys("woaini1314?");
	driver.findElement(By.id("signin")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	// �������Ϣ����
	// driver.findElement(By.linkText("����Ϣ")).click();
	// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	// driver.findElement(By.linkText("׫д�¶���Ϣ")).click();
	// driver.findElement(By.id("txtIncept")).sendKeys("jiang1988jian");
	// driver.findElement(By.id("txtTitle")).sendKeys("����");
	// driver.findElement(By.id("txtContent"))
	// .sendKeys("ceshiceshi+test+ʲô����");
	// driver.findElement(By.id("btnSend")).click();

    }
}
