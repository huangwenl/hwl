package com.brooke.blogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    WebDriver driver;
    @FindBy(how = How.LINK_TEXT, linkText = "登录")
    WebElement loginLink;
    @FindBy(how = How.LINK_TEXT, linkText = "退出")
    WebElement logoutLink;

    public MainPage(WebDriver driver) {
	this.driver = driver;
    }

    // 打开登录界面
    public void openMain(String url) {
	driver.get(url);
	// loginLink = driver.findElement(By.linkText("登录"));
	// loginLink.click();
    }

    // 登录
    public void login(String userName, String Password) {
	loginLink.click();
	WebDriverWait wait = new WebDriverWait(driver, 300);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By
		.id("input1")));
	// LoginPage loginpage = new LoginPage(driver);
	// 使用PageFactory工厂创建对象
	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	loginpage.login(userName, Password);
    }

    // 退出
    public void logout() {
	// logoutLink = driver.findElement(By.linkText("退出"));
	logoutLink.click();
	LogoutPage logoutpage = PageFactory.initElements(driver,
		LogoutPage.class);
	logoutpage.logout();
    }
}
