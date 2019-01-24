package com.Farm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.base.Function;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Base {

	public static MobileDriver driver;
	static String filePath= "../tests/config.properties";
	public static WebDriverWait wait;
	static SoftAssert sAssert = new SoftAssert();
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;	
	
	WebDriver driver(){
		return driver;
	}
	
	
	@BeforeSuite
	public void setUp() throws InterruptedException, MalformedURLException {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability(MobileCapabilityType.DEVICE_NAME,"device");
		File file = new File("./app_APK/farmrise.apk");
		capability.setCapability("app_APK", file.getAbsolutePath());
		capability.setCapability("appPackage", "com.climate.farmrise");
		capability.setCapability("appActivity", "ccom.climate.farmrise/.language.view.LanguageActivity t161");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capability);
	}
	
		
	public static void webElementToBeVisibleByID(String locator){
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(locator))));
	}
	
	
	public static void webElementToBeVisibleByPartialLink(String locator){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
	}
	
	
	public static void webElementToBeVisibleByXpath(String locator){
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
	}
	
	public static void webElementToBeVisibleBycssSelector(String locator){
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(locator))));
	}
	
	public static void visibliltyOfElementToBeInDomById(String locator){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
	}
	
	
	public static void visibliltyOfElementToBeInDomByName(String locator){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
	}
	
	
	public static void visibliltyOfElementToBeInDomByCss(String locator){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
	}
	
	
	public static void scrollDown(int pixels){
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+pixels+")", "");	
	}
	
	
	public static void scrollRight(int pixels){
		((JavascriptExecutor)driver).executeScript("window.scrollBy("+pixels+",0)", "");
	}

	public static void fluentWait(final String locator){
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(500, TimeUnit.SECONDS);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver){
				return driver.findElement(By.xpath(locator));
			}
		});
		System.out.println("Element is Displayed: " + element.isDisplayed() );
	}
	

}
