package com.listeners;

	import java.io.File;
	import java.io.IOException;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.testng.ITestContext;
	import org.testng.ITestResult;

	public class Listener  {
		WebDriver driver=null;
		
		
	public static String captureScreenShot(WebDriver driver, String screenshot)
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest = "./screenshots/"+screenshot+System.currentTimeMillis()+".png";
		//Adding time stamp else it will replace the previous screenshots
		
			try 
		{
			FileUtils.copyFile(src, new File(dest));
		}
			catch (IOException e) {
			System.out.println("Failed to get screenshot"+e.getMessage());
			e.printStackTrace();
		}
		return dest;
	}
	    
	    /**
	     * Executes on finishing of suite
	     */
		public void onFinish(ITestContext context){}
	  
		 /**
	     * Executes on start of test
	     */
	    public void onTestStart(ITestResult result){}
	  
	    /**
	     * Executes on success of test
	     */
	    public void onTestSuccess(ITestResult result){}

	    /**
	     * Executes in skipping of test
	     */
	    public void onTestSkipped(ITestResult result){}

	    /**
	     * Executes on failing of test
	     */
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result){}
	    
	    /**
	     * Executes on start of suite
	     */
	    public void onStart(ITestContext context){}
	}

