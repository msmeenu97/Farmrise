package com.framtests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Farm.Base;
import com.pages.Page2;

public class Test2 extends Base{
	
	@Test()	
	public void TestCase02() throws Exception
	{
			
			Page2 page2 = new Page2();
			page2.clickMore();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			page2.clickgovt();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			page2.scroll();
			Thread.sleep(2000);
			page2.clkSearch();
			

}
}