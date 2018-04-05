package com.ganimet.simpletest.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public abstract class BasePage<E>{
	protected AppiumDriver<MobileElement> driver;
	public static final int DEFAULT_WAIT = 15;
	protected WebDriverWait wait;
	protected static final Logger logger = Logger.getLogger(BasePage.class);
	
	public BasePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, DEFAULT_WAIT, 1000);
	}

	public void waitSeconds(int seconds){
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
