package com.brooke.junit4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class testCSDNbyLinkText {
    static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
	System.setProperty("webdriver.chrome.driver",
		"C:/Program Files (x86)/Google/Chrome/Application/chromedriver_x64.exe");
	// 由于每次启动chrome的端口号不一样，所以设置端口号为5452
	ChromeDriverService.Builder builder = new ChromeDriverService.Builder();
	ChromeDriverService service = builder
		.usingDriverExecutable(
			new File(
				"C:/Program Files (x86)/Google/Chrome/Application/chromedriver_x64.exe"))
		.usingPort(5452).build();
	service.start();
	driver = new ChromeDriver(service);
    }

    @Test
    public void test() {
	driver.get("http://www.baidu.com");
	// 窗口最大化
	driver.manage().window().maximize();
	// WebElement elementLink = driver.findElement(By.linkText("联系方式"));
	List<WebElement> elementLink = driver.findElements(By
		.partialLinkText("程序"));
	int size = elementLink.size();
	System.out.println(size);
	for (WebElement e : elementLink) {
	    System.out.println(e.getText());
	}

	// 按住shift键输入值使用keys
	// WebElement element = driver.findElement(By.id("kw"));
	// element.sendKeys(Keys.chord(Keys.SHIFT, "webdriver"));
    }

    @Test
    public void test2() {
	driver.get("http://www.baidu.com");
	WebElement element = driver.findElement(By.id("su"));
	System.out.println(element.getTagName());// input
	System.out.println(element.getText());
	System.out.println(element.getAttribute("value"));// 百度一下
	System.out.println(element.getLocation());// 按钮坐标(624, 286)

    }

    @Test
    public void test3() {
	// 将FirefoxProfile导出成Json格式
	String profileJson = "";
	FirefoxProfile profile = new FirefoxProfile();
	try {
	    profileJson = profile.toJson();
	    System.out.println(profileJson);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	WebDriver firedrive = new FirefoxDriver(profile);
	firedrive.get("http://www.baidu.com");

    }

    @Test
    public void testgetCookies() {
	// 窗口最大化
	driver.manage().window().maximize();
	driver.get("http://www.zhihu.com/#signin");
	driver.findElement(By.name("account")).clear();
	driver.findElement(By.name("account")).sendKeys("13926175077");
	driver.findElement(By.xpath("//input[@type='password']")).clear();
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(
		"123456");
	// if (driver.findElement(By.name("remember-me")).isSelected()) {
	// driver.findElement(By.name("remember-me")).click();
	// }
	try {
	    Thread.sleep(8000);
	} catch (InterruptedException e1) {
	    e1.printStackTrace();
	}
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	// cookie文件
	File cookie = new File("zhihucookie.txt");
	try {
	    cookie.delete();
	    cookie.createNewFile();
	    FileWriter fw = new FileWriter(cookie);
	    BufferedWriter bw = new BufferedWriter(fw);
	    Set<Cookie> cookies = driver.manage().getCookies();
	    for (Cookie c : cookies) {
		bw.write(c.getName() + "@" + c.getValue() + "@" + c.getDomain()
			+ "@" + c.getPath() + "@" + c.getExpiry() + "@"
			+ c.isSecure());
		bw.newLine();
	    }
	    bw.flush();
	    bw.close();
	    fw.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testgetCookieslogin() {
	// testgetCookies();
	driver.get("http://www.zhihu.com/#signin");
	File cookie = new File("zhihucookie.txt");
	try {
	    BufferedReader bf = new BufferedReader(new FileReader(cookie));
	    String line = null;
	    while ((line = bf.readLine()) != null) {
		StringTokenizer token = new StringTokenizer(line, "@");
		while (token.hasMoreTokens()) {
		    String name = token.nextToken();
		    String value = token.nextToken();
		    String domain = token.nextToken();
		    String path = token.nextToken();
		    Date expiry = null;
		    String temp;
		    // System.out.println(name + value);
		    if (!((temp = token.nextToken()).equals("null"))) {
			expiry = new Date(temp);
		    }
		    boolean isSecure = new Boolean(token.nextToken())
			    .booleanValue();
		    Cookie cookie2 = new Cookie(name, value, domain, path,
			    expiry, isSecure);
		    // System.out.println(cookie2.getName());
		    // System.out.println(cookie2.getValue());
		    // System.out.println(cookie2.getDomain());
		    // System.out.println(cookie2.getPath());
		    // System.out.println(cookie2.getExpiry());
		    // System.out.println(cookie2.isSecure());
		    driver.manage().addCookie(cookie2);

		}
	    }
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	driver.get("http://www.zhihu.com");
    }

    @Test
    public void test4() {
	try {
	    driver.get("http://www.baidu.com");
	    // 截图,TakesScreenshot此接口提供截图功能
	    File srcFile = ((TakesScreenshot) driver)
		    .getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(srcFile, new File("screenshot.jpg"));
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Test
    public void test5() {
	driver.get("http://literallycanvas.com/");
	WebElement element = driver.findElement(By
		.xpath("//*[@id='literally-canvas']/div[1]/div[1]/canvas[2]"));
	Actions actions = new Actions(driver);
	actions.clickAndHold(element).moveByOffset(10, 50).moveByOffset(50, 10)
		.moveByOffset(-10, -50).moveByOffset(-50, -10).release()
		.perform();

    }

    @Test
    public void test6() {
	String url = "http://m.52zzb.com/zhangzb/#/moreOffer/1453040";
	String num = url.substring(url.lastIndexOf("/") + 1);

	System.out.println(num);
    }

}
