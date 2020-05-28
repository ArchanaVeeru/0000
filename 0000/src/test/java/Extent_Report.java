
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Extent_Report {
 public WebDriver driver;
public ExtentHtmlReporter htmlReporter;
 public ExtentReports extent;
 public ExtentTest test;
 public static String dateName=new SimpleDateFormat("yyyyMMddmmss").format(new Date());

  
@BeforeTest
public void setExtent() {
	//String dateNmae=new SimpleDateFormat("yyyyMMddmmss").format(new Date());
	htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Extent-Report"+".html");
	htmlReporter.config().setDocumentTitle("Extent-Report ");
	htmlReporter.config().setReportName("Testng Report");
	htmlReporter.config().setTheme(Theme.STANDARD);
	
	extent=new ExtentReports();
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("Hostname","Archana");
	extent.setSystemInfo("Username","Archana");
	extent.setSystemInfo("Environment","QA");
	
}
@AfterTest
public void endReport()
{
	extent.flush();
}

@BeforeMethod
public void setUp() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.nopcommerce.com/en/");
	
}

@Test
public void ecommerceTitleTest() {
	test=extent.createTest("ecommerceLogoTest");
	String title=driver.getTitle();
	System.out.println(title);
	Assert.assertEquals(title, "Fr and open-source eCommerce platform. ASP.NET based shopping cart. - nopCommerce");
	
}
@Test
public void ecommerceLogoTest() {
	test=extent.createTest("ecommerceLogoTest");
	test.createNode("new title");
	Assert.assertTrue(true);
	boolean status=driver.findElement(By.xpath("//*[@id=\"index-page\"]/body/div[6]/header/div/div[1]/a/img")).isDisplayed();
	Assert.assertTrue(status);
	
}

@AfterMethod
public void tearDown(ITestResult result) throws IOException {
	if(result.getStatus()==ITestResult.FAILURE) {
		test.log(Status.FAIL, "Testcase failed is"+result.getName());
		test.log(Status.FAIL,"Testcase failes is"+result.getThrowable());
		String screenshotPath=Extent_Report.getScreenshot(driver,result.getName());
		test.addScreenCaptureFromPath(screenshotPath);
		
	}
	if(result.getStatus()==ITestResult.SKIP) {
		test.log(Status.SKIP,"Testcase skipped is"+result.getName());
	}
	if(result.getStatus()==ITestResult.SUCCESS) {
		test.log(Status.PASS,"Testcase passed is"+result.getName());
	}
	extent.removeTest(test);
	driver.close();
		
}

public static  String getScreenshot(WebDriver driver,String screenShotName) throws IOException {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	String destination=System.getProperty("user.dir")+"/Screenshots"+"/FaileedReport"+dateName+".png";
	File finaldestination=new File(destination);
	FileUtils.copyFile(src,finaldestination);
	return destination;

}









 
 }
