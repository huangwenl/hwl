package com.brooke.blogs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    // ��¼���棺�û��������롢��¼��ť,��װloginҳ��Ԫ��
    WebDriver driver;
    @FindBy(how = How.ID, id = "input1")
    WebElement username;
    @FindBy(how = How.ID, id = "input2")
    WebElement password;
    @FindBy(how = How.ID, id = "signin")
    WebElement longinbtn;

    public LoginPage(WebDriver driver) {
	this.driver = driver;
	// username = driver.findElement(By.id("input1"));
	// password = driver.findElement(By.id("input2"));
	// longinbtn = driver.findElement(By.id("signin"));
    }

    public void login(String userName, String Password) {
	username.sendKeys(userName);
	password.sendKeys(Password);
	longinbtn.click();
	// ��ʽ�ĵȴ�3��
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
