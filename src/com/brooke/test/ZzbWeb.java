package com.brooke.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ZzbWeb {

    public boolean ElementExist(WebDriver driver) {
	boolean flag = false;
	String xpath = "//*[@id='loadss']/div[2]/div/div[2]/div[2]/div[1]/div";
	try {
	    driver.findElement(By.xpath(xpath));
	    flag = true;
	    return flag;
	} catch (org.openqa.selenium.NoSuchElementException ex) {
	    return flag;
	}
    }

    public boolean ElementExistValue(WebDriver driver) {
	boolean flag = true;
	// �������복���������ڡ�����ʶ����š��������š�Ʒ���ͺŵ���Ϣ
	WebElement element = driver
		.findElement(By
			.xpath("//*[@id='ng-app']/body/div[1]/div[1]/div[1]/div/form/section[1]/input"));
	if (element.getText() != null) {
	    return flag;
	} else {
	    flag = false;
	    return flag;
	}
    }
}
