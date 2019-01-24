package com.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.Farm.Assertion;
import com.Farm.Base;

import io.appium.java_client.TouchAction;

public class Page1 extends Base{

	
	TouchAction touch = new TouchAction(driver);
	 Actions act;
	 By Accesswaether = By.id("com.climate.farmrise:id/agr_manageCrops");
	 By control = By.id("android:id/switch_widget");
	 
	 
	 
	 public void clickAccess()
	 {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(Accesswaether).click();
	 }
	 public void verify(Boolean result)
	 {
		 Base.scrollRight(100);
		 driver.findElement(By.id("com.climate.farmrise:id/hourlyWeatherForecastLayout")).isDisplayed();
		 Assertion.assertTrue(result);
		 
	 }
	
}
