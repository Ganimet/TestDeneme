package com.ganimet.simpletest.test;

import org.junit.Test;
import org.openqa.selenium.By;

import com.ganimet.simpletest.base.BaseTest;

public class FirstDeneme extends BaseTest{
	
	@Test
	public void deneme() throws InterruptedException {
		Thread.sleep(3000);
		getDriver().findElement(By.id("com.turkcell.gncplay:id/rvSectionWeeklyExplore")).click();
	}

}
