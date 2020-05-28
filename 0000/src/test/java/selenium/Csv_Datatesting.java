package selenium;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Csv_Datatesting {
	public WebDriver driver1,driver2;
	@BeforeMethod
	public void setUp()
	{
		
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
  @Test(dataProvider="getData")
  public void loginTest(String Firstname,String lastname,String phonenum,String country) throws InterruptedException {
//	  System.out.println("hello");
//	  WebElement element=driver.findElement(By.name("RESULT_TextField-1"));
//	  System.out.println("hello1");
//	  WebDriverWait wait=new WebDriverWait(driver,10);
//	  wait.until(ExpectedConditions.visibilityOf(element));
//	  System.out.println("hello2");
//	  driver.findElement(By.name("RESULT_TextField-1")).sendKeys(Firstname);
//	  System.out.println("hello3");
//	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  WebDriverManager.chromedriver().setup();
	  driver1=new ChromeDriver();
		driver1.get("https://www.facebook.com/r.php");
//	  js.executeScript("arguments[0].value='Firstname';", element);
	  driver1.findElement(By.name("firstname")).sendKeys(Firstname);
	  driver1.findElement(By.name("lastname")).sendKeys(lastname);
	  driver1.findElement(By.name("reg_email__")).sendKeys(phonenum);
	  driver1.findElement(By.name("reg_passwd__")).sendKeys(country);
	  
	  Thread.sleep(2000);
	  driver1.close();
	  
	  
  }
  @DataProvider
  public Object[] getData() throws IOException, CsvException {
	 String file_path=System.getProperty("user.dir")+"/Additional_Files/Data.csv";
	 
	  CSVReader reader=new CSVReader(new FileReader(file_path));
	  List<String[]> data=reader.readAll();
	 Object[][] csvDataObject=new Object[data.size()][4];
	 for(int i=0;i<data.size();i++) {
		 csvDataObject[i]=data.get(i);
  }
  return csvDataObject;
  
  }
  
  
  
  @Test
  public void fireFox() {
	  WebDriverManager.firefoxdriver().setup();
	  driver2=new FirefoxDriver();
	  driver2.get("https://www.facebook.com/r.php");
  }
  
  
  
  
}
