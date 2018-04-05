package com.ganimet.simpletest.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class BaseTest {

		protected AndroidDriver<MobileElement> driver;
		public static String currentPhone = "LOCAL_PHONE";

		
		@Before
		public void setUp() throws MalformedURLException {	
//			Reporter.log(System.getProperty("deviceName"));
			System.out.println("Appium Server Ports**********" + System.getProperty("environment"));
			System.out.println("device ID**********" + System.getProperty("deviceId"));
			System.out.println("http://127.0.0.1:" + System.getProperty("environment") + "/wd/hub");

				DesiredCapabilities capabilities = DesiredCapabilities.android();
				capabilities.setCapability("deviceName", "LGM250758PINNFDA59");
				capabilities.setCapability("platformName", "android");
				capabilities.setCapability("platformVersion", "7.0");
			    capabilities.setCapability("browserName","");
			    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, currentPhone);
				capabilities.setCapability("appPackage", "com.turkcell.gncplay");
				capabilities.setCapability("automationName", "uiautomator2");
//				capabilities.setCapability("app", System.getProperty("user.dir") + "/build/AndroidCalculator.apk");
//				capabilities.setCapability("package", "com.android2.calculator3");
				capabilities.setCapability("appActivity", "com.turkcell.gncplay.view.activity.SplashActivity");
				driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		}

		@After
		public void kill() {
			driver.quit();
		}

		public void waitForElement(By id, int time) {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable((id)));
		}

		public AppiumDriver<MobileElement> getDriver(){
			return driver;
		}

	}

