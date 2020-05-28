package selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class AddedListener {
	
	 public WebDriver driver;
  @BeforeMethod
  public void setUp() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://www.nopcommerce.com/en/");
  }
  @Test
  public void titleTest() {
	  String title=driver.getTitle();
	  Assert.assertEquals(title,"Free and open-source eCommerce platform. ASP.NET based shopping cart. - nopCommerce");
  }
  @Test
  public void logoTest() {
	  boolean value=driver.findElement(By.xpath("//*[@id=\"index-page\"]/body/div[6]/header/div/div[1]/a/img")).isDisplayed();
	  Assert.assertTrue(value);
  }
  @AfterMethod
  public void tearDown()
  {
	  driver.close();
  }
}
