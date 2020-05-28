package selenium;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;




public class EcommerceListeners extends TestListenerAdapter {
		public ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Extent-Report"+".html");
		
		public ExtentReports extent=new ExtentReports();
		public ExtentTest test;
		public WebDriver driver;
	
		
	 
	  public void onTestStart(ITestResult tr) {
		  
		  System.out.println("Test started  "+tr.getName());
	  }
	  public void onTestFailure(ITestResult result) {
		  if(result.getStatus()==ITestResult.FAILURE) {
			  
				test=extent.createTest("onTestFailure");
			  test.log(Status.FAIL,"Test casefailed is"+result.getName());
			  test.log(Status.FAIL,"Tese case failed is"+result.getThrowable());
				System.out.println("Test case failed is  "+result.getThrowable());
			  try {
				//String path=EcommerceListeners.getScreenshot(driver,result.getName());
				TakesScreenshot ts=(TakesScreenshot) driver;
				File src=ts.getScreenshotAs(OutputType.FILE);
				String destination=System.getProperty("user.dir")+"/Screenshots"+"/FailedReport"+".png";
				File finaldestination=new File(destination);
				FileUtils.copyFile(src,finaldestination);
				 test.addScreenCaptureFromPath(destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		  }
	  }
	  public void onTestSkipped(ITestResult tr) {
		  System.out.println("testcase skipped"+tr.getName());
	  }
	  public void onTestSuccess(ITestResult tr) {
		  System.out.println("Testcase passed "+tr.getName());
	  }
//	  public static  String getScreenshot(WebDriver driver,String screenShotName) throws IOException {
//			TakesScreenshot ts=(TakesScreenshot) driver;
//			File src=ts.getScreenshotAs(OutputType.FILE);
//			String destination=System.getProperty("user.dir")+"/Screenshots"+"/FailedReport"+".png";
//			File finaldestination=new File(destination);
//			FileUtils.copyFile(src,finaldestination);
//			return destination;
//	}
	}


