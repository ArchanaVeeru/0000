package selenium;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EcommerceLogin {
	public WebDriver driver;
  @BeforeMethod
  public void setUp() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");  
  }
  @DataProvider
  public Object[][] excelData() throws IOException {
	  FileInputStream fis=new FileInputStream("C://Users/ArchanaVeeru/ecommercelogin.xlsx");
	  XSSFWorkbook workbook=new XSSFWorkbook(fis);
	  XSSFSheet sheet=workbook.getSheet("Sheet1");
	  int rowcount=sheet.getLastRowNum();
	  int colcount=sheet.getRow(0).getLastCellNum();
	  Object[][] data=new Object[rowcount][colcount];
	  for (int i=1;i<=rowcount;i++)
	  {

		  for(int j=0;j<colcount;j++) {
			  
		  XSSFRow currentrow=sheet.getRow(i);
		 
			  data[i-1][j]=currentrow.getCell(j).toString();
				
		  
	  }
	  }
	  return data;
	  
  }
  @Test(dataProvider="excelData")
  public void loginTest(String username,String password) throws InterruptedException {
	  driver.findElement(By.id("email")).sendKeys(username);
	  driver.findElement(By.id("pass")).sendKeys(password);
	  Thread.sleep(1000);
	  driver.findElement(By.id("u_0_b")).click();
	  
	  driver.close();
  }
}
