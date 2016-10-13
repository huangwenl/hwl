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
    @FindBy(how = How.LINK_TEXT, linkText = "��¼")
    WebElement loginLink;
    @FindBy(how = How.LINK_TEXT, linkText = "�˳�")
    WebElement logoutLink;

    public MainPage(WebDriver driver) {
	this.driver = driver;
    }

    // �򿪵�¼����
    public void openMain(String url) {
	driver.get(url);
	// loginLink = driver.findElement(By.linkText("��¼"));
	// loginLink.click();
    }

    // ��¼
    public void login(String userName, String Password) {
	loginLink.click();
	WebDriverWait wait = new WebDriverWait(driver, 300);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By
		.id("input1")));
	// LoginPage loginpage = new LoginPage(driver);
	// ʹ��PageFactory������������
	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	loginpage.login(userName, Password);
    }

    // �˳�
    public void logout() {
	// logoutLink = driver.findElement(By.linkText("�˳�"));
	logoutLink.click();
	LogoutPage logoutpage = PageFactory.initElements(driver,
		LogoutPage.class);
	logoutpage.logout();
    }
}
