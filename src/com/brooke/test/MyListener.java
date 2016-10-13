package com.brooke.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class MyListener extends AbstractWebDriverEventListener {

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
	System.out.println("afterClickOn: " + element.getAttribute("value"));
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
	System.out.println("afterNavigateTo: " + url);

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
	System.out.println("afterNavigateBack: " + driver.getCurrentUrl());
    }

}
