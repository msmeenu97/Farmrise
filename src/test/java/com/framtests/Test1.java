package com.framtests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.Farm.Base;
import com.pages.Page1;


public class Test1 extends Base{
		@Test()	
		public void TestCase01() throws Exception
		{
				
				Page1 log = new Page1();
				try {
				
					Thread.sleep(500);
					driver.findElement(By.name("English")).click();
					Thread.sleep(500);
					driver.findElement(By.name("Proceed")).click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(By.name("Agree and Continue")).click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					for(int i=0; i<6 ; i++)
					{
					driver.findElement(By.name("OK")).click();
					Thread.sleep(800);
					File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile2, new File("./screenshots//mirror"+timestamp()+"png"));
					System.out.println("verified the user is on the  mirror page");
					
				}}
				catch (Exception e) {
					e.printStackTrace();
				}}
	public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }}