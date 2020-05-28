package selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.internal.thread.ThreadTimeoutException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

//@Listeners(selenium.EcommerceListeners.class)
public class EcommerceTest {
	 public WebDriver driver;
	// public WebDriver driver;
		
		
//	  @BeforeMethod
//	  public void setUp() {
//		  WebDriverManager.chromedriver().setup();
//		  driver=new ChromeDriver();
//		  driver.get("https://www.nopcommerce.com/en/");
//		  driver.manage().window().maximize();
//		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//	  }
	  @Test(enabled=false)
	  public void titleTest() {
		  String title=driver.getTitle();
		  Assert.assertEquals(title,"Free and open-source eCommerce platform. ASP.NET based shopping cart. - nopCommerce");
	  }
	  @Test(invocationCount=10000,invocationTimeOut=1,expectedExceptions= ThreadTimeoutException.class)
	  public void logoTest() {
//		  boolean value=driver.findElement(By.xpath("//*[@id=\"index-page\"]/body/div[6]/header/div/div[1]/a/img")).isDisplayed();
//		  Assert.assertTrue(value);
		  int a=10,b=5,c;
		  
			 System.out.println(c=a+b);
			  
		 
	  }
//	  @AfterMethod
//	  public void tearDown()
//	  {
//		  driver.close();
//	  }
}
