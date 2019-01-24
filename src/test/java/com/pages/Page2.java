package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.Farm.Assertion;
import com.Farm.Base;

public class Page2 extends Base {

	
	By More = By.id("com.climate.farmrise:id/icon");
	 By govt = By.id("com.climate.farmrise:id/more_govtSchemes");
	 By search = By.id("android:id/search_button");
	 
	 
	 public void clickMore()
	 {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(More).click();
	 }
	 public void clickgovt()
	 {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(govt).click();
	 }
	 public void scroll()
	 {
		    Base.scrollDown(200);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Base.scrollDown(300);
			// Not able to view the button of view more schemes?? screenshot in folder screenshot
	 }
	 public void clkSearch()
	 {
		 driver.findElement(search).sendKeys("scheme");
	//the enter key after the name is sent, is not clickable at the phone keyboard.
		 
	 }
	 public void verify()
	 {
		 Assertion.assertString("schemes", "schemes");
	 }
}
