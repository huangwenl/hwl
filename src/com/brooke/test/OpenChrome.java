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
	// 窗口最大化
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, 300);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By
		.xpath("//input[@type='text']")));
	// 输入用户名、密码进行登录
	driver.findElement(By.xpath("//input[@type='text']")).clear();
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(
		"10001381");// 10001381
	driver.findElement(By.xpath("//input[@type='password']")).clear();
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(
		"123456");
	driver.findElement(
		By.xpath("//html[@id='ng-app']/body/div/div/form/button"))
		.click();

	// 等待界面加载完
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	// 点击投保进入投保界面
	driver.findElement(
		By.xpath("//*[@id='ng-app']/body/div[1]/nav[2]/ul/li[1]"))
		.click();
	// 等待界面加载完
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	// 输入车牌、车主
	driver.findElement(
		By.xpath("//html[@id='ng-app']/body/div/div/div/dl[2]/dd/input"))
		.clear();
	driver.findElement(
		By.xpath("//html[@id='ng-app']/body/div/div/div/dl[2]/dd/input"))
		.sendKeys("粤A65445");
	driver.findElement(
		By.xpath("//html[@id='ng-app']/body/div/div/div/dl[3]/dd/input"))
		.sendKeys("测试");
	driver.findElement(
		By.xpath("//html[@id='ng-app']/body/div/div[2]/button"))
		.click();

	// 进入输入身份证号码核对弹框，跳过查询
	/*
	 * （1）对浮层进行输入文字 JavascriptExecutor j= (JavascriptExecutor)driver;
	 * j.executeScript
	 * ("document.findElementById('123').style.display='block'; ");
	 * 然后再WebElement.sendKeys ("The words you want to type");
	 * 
	 * (2)执行浮层上的操作，如单击 JavascriptExecutor j= (JavascriptExecutor)driver;
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
	    // 进入输入车辆初登日期、车辆识别代号、发动机号、品牌型号等信息

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

	    // 进入选择车型页面
	    WebElement element = driver
		    .findElement(By
			    .xpath("//*[@id='ng-app']/body/div[1]/div[3]/div/div[3]/input"));
	    element.sendKeys("奥迪");
	    element.sendKeys(Keys.ENTER);
	    // 从搜索中的车型选择第一台
	    // List<WebElement> elementList = (List<WebElement>) driver
	    // .findElements(By
	    // .xpath("//*[@id='ng-app']/body/div[1]/div[3]/div/div[4]/div[1]/section"));
	    // System.out.println(elementList.size());
	    // for (WebElement e : elementList) {
	    // System.out.println(e.findElement(By.tagName("h3")).getText());
	    // }
	    // 等待界面加载完
	    // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    try {
		Thread.sleep(3000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[3]/div/div[4]/div[1]/section[1]"))
		    .click();
	    // 进入车型确认界面：选择所属性质:个人用车以及车辆性质:家庭自用汽车
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
	    // 等待出现保险公司界面
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By
		    .xpath("//*[@id='ng-app']/body/div[1]/zb-top-panel/div/span[2]")));
	    // 进行保险公司选择
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
		// 截图报价成功界面
		File srcFile = ((TakesScreenshot) driver)
			.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("screenshot.jpg"));
	    } catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	    // 截取任务号出来
	    String url = driver.getCurrentUrl();
	    String num = url.substring(url.lastIndexOf("/") + 1);
	    System.out.println(num);
	    // 转到cm后台操作

	} else {
	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    driver.findElement(
		    By.xpath("//*[@id='ng-app']/body/div[1]/div[1]/div[1]/div/form/section[4]/div[2]/div/section[1]"))
		    .click();
	    // 进入车型确认界面：选择所属性质:个人用车以及车辆性质:家庭自用汽车
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
	    // 等待出现保险公司界面
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By
		    .xpath("//*[@id='ng-app']/body/div[1]/zb-top-panel/div/span[2]")));
	    // 进行保险公司选择
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
		// 截图报价成功界面
		File srcFile = ((TakesScreenshot) driver)
			.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("screenshot.jpg"));
	    } catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    // 截取任务号出来
	    String url = driver.getCurrentUrl();
	    String num = url.substring(url.lastIndexOf("/") + 1);
	    System.out.println(num);
	    // 转到cm后台操作
	}

    }
}
