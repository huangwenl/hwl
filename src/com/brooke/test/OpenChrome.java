package com.brooke.test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenChrome {
    public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver",
		"C:/Program Files (x86)/Google/Chrome/Application/chromedriver_x64.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://m.52zzb.com/zhangzb/#/login");
	// �������
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, 300);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By
		.xpath("//input[@type='text']")));
	// �����û�����������е�¼
	driver.findElement(By.xpath("//input[@type='text']")).clear();
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(
		"10001381");// 10001381
	driver.findElement(By.xpath("//input[@type='password']")).clear();
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(
		"123456");
	driver.findElement(
		By.xpath("//html[@id='ng-app']/body/div/div/form/button"))
		.click();

	// �ȴ����������
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	// ���Ͷ������Ͷ������
	driver.findElement(
		By.xpath("//*[@id='ng-app']/body/div[1]/nav[2]/ul/li[1]"))
		.click();
	// �ȴ����������
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	// ���복�ơ�����
	driver.findElement(
		By.xpath("//html[@id='ng-app']/body/div/div/div/dl[2]/dd/input"))
		.clear();
	driver.findElement(
		By.xpath("//html[@id='ng-app']/body/div/div/div/dl[2]/dd/input"))
		.sendKeys("��A65445");
	driver.findElement(
		By.xpath("//html[@id='ng-app']/body/div/div/div/dl[3]/dd/input"))
		.sendKeys("����");
	driver.findElement(
		By.xpath("//html[@id='ng-app']/body/div/div[2]/button"))
		.click();

	// �����������֤����˶Ե���������ѯ
	/*
	 * ��1���Ը�������������� JavascriptExecutor j= (JavascriptExecutor)driver;
	 * j.executeScript
	 * ("document.findElementById('123').style.display='block'; ");
	 * Ȼ����WebElement.sendKeys ("The words you want to type");
	 * 
	 * (2)ִ�и����ϵĲ������絥�� JavascriptExecutor j= (JavascriptExecutor)driver;
	 * j.executeScript("document.findElementById('123').click() ");
	 */
	// JavascriptExecutor j = (JavascriptExecutor) driver;
	// j.executeScript("document.findElementByXpath('//*[@id='loadss']/div[2]/div/div[2]/div[2]/div[1]/div').click() ");

	ZzbWeb zzbWeb = new ZzbWeb();
	boolean flag = zzbWeb.ElementExist(driver);
	if (flag) {
	    try {
		Thread.sleep(3000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    // �������복���������ڡ�����ʶ����š��������š�Ʒ���ͺŵ���Ϣ

	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[1]/div[1]/div/form/section[1]/input"))
		    .sendKeys("2015-04-01");
	    driver.findElement(By.xpath("//*[@id='carCode']")).sendKeys(
		    "LVB56456464645612");
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[1]/div[1]/div/form/section[3]/input"))
		    .sendKeys("3453534");

	    driver.findElement(By.xpath("//*[@id='carinfomodel']/input"))
		    .click();

	    // ����ѡ����ҳ��
	    WebElement element = driver
		    .findElement(By
			    .xpath("//*[@id='ng-app']/body/div[1]/div[3]/div/div[3]/input"));
	    element.sendKeys("�µ�");
	    element.sendKeys(Keys.ENTER);
	    // �������еĳ���ѡ���һ̨
	    // List<WebElement> elementList = (List<WebElement>) driver
	    // .findElements(By
	    // .xpath("//*[@id='ng-app']/body/div[1]/div[3]/div/div[4]/div[1]/section"));
	    // System.out.println(elementList.size());
	    // for (WebElement e : elementList) {
	    // System.out.println(e.findElement(By.tagName("h3")).getText());
	    // }
	    // �ȴ����������
	    // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    try {
		Thread.sleep(3000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[3]/div/div[4]/div[1]/section[1]"))
		    .click();
	    // ���복��ȷ�Ͻ��棺ѡ����������:�����ó��Լ���������:��ͥ��������
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[3]/div[2]/div/form/div[2]/div[3]/section[5]/select/option[2]"))
		    .click();
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[3]/div[2]/div/form/div[2]/div[3]/section[6]/select/option[2]"))
		    .click();
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[3]/div[2]/div/form/div[2]/div[4]/div[2]/button"))
		    .click();
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[1]/div[2]/div[2]/button"))
		    .click();
	    // �ȴ����ֱ��չ�˾����
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By
		    .xpath("//*[@id='ng-app']/body/div[1]/zb-top-panel/div/span[2]")));
	    // ���б��չ�˾ѡ��
	    try {
		Thread.sleep(3000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div/div[1]/ul/li/div/div/label"))
		    .click();
	    List<WebElement> elements = (List<WebElement>) driver
		    .findElements(By
			    .xpath("//*[@id='ng-app']/body/div[1]/div/div[1]/ul/li"));
	    // System.out.println(elements.size());
	    for (WebElement e : elements) {
		// driver.findElement(
		// By.xpath("//*[@id='ng-app']/body/div[1]/div/div[1]/ul/li/div/div/label"))
		// .click();
		e.findElement(By.xpath("div/div/label")).click();
	    }
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div/div[3]/div[2]/button"))
		    .click();
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[1]/div[1]/div[1]/div[5]/section[1]/h3/select/option[2]"))
		    .click();
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[1]/div[1]/div[1]/div[5]/section[1]/div[1]/input[1]"))
		    .sendKeys("360428198911250614");
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[1]/div[1]/div[2]/div[2]/button"))
		    .click();
	    try {
		Thread.sleep(20000);
		// ��ͼ���۳ɹ�����
		File srcFile = ((TakesScreenshot) driver)
			.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("screenshot.jpg"));
	    } catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	    // ��ȡ����ų���
	    String url = driver.getCurrentUrl();
	    String num = url.substring(url.lastIndexOf("/") + 1);
	    System.out.println(num);
	    // ת��cm��̨����

	} else {
	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[1]/div[1]/div/form/section[4]/div[2]/div/section[1]"))
		    .click();
	    // ���복��ȷ�Ͻ��棺ѡ����������:�����ó��Լ���������:��ͥ��������
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[3]/div[2]/div/form/div[2]/div[3]/section[5]/select/option[2]"))
		    .click();
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[3]/div[2]/div/form/div[2]/div[3]/section[6]/select/option[2]"))
		    .click();
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[3]/div[2]/div/form/div[2]/div[4]/div[2]/button"))
		    .click();
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[1]/div[2]/div[2]/button"))
		    .click();
	    // �ȴ����ֱ��չ�˾����
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By
		    .xpath("//*[@id='ng-app']/body/div[1]/zb-top-panel/div/span[2]")));
	    // ���б��չ�˾ѡ��
	    List<WebElement> elements = (List<WebElement>) driver
		    .findElements(By
			    .xpath("//*[@id='ng-app']/body/div[1]/div/div[1]/ul/li"));
	    // System.out.println(elements.size());
	    for (WebElement e : elements) {
		// driver.findElement(
		// By.xpath("//*[@id='ng-app']/body/div[1]/div/div[1]/ul/li/div/div/label"))
		// .click();
		e.findElement(By.xpath("div/div/label")).click();
	    }
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div/div[3]/div[2]/button"))
		    .click();
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[1]/div[1]/div[1]/div[5]/section[1]/h3/select/option[2]"))
		    .click();
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[1]/div[1]/div[1]/div[5]/section[1]/div[1]/input[1]"))
		    .sendKeys("360428198911250614");
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[1]/div[1]/div[2]/div[2]/button"))
		    .click();
	    try {
		Thread.sleep(20000);
		// ��ͼ���۳ɹ�����
		File srcFile = ((TakesScreenshot) driver)
			.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("screenshot.jpg"));
	    } catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    // ��ȡ����ų���
	    String url = driver.getCurrentUrl();
	    String num = url.substring(url.lastIndexOf("/") + 1);
	    System.out.println(num);
	    // ת��cm��̨����
	}

    }
}
