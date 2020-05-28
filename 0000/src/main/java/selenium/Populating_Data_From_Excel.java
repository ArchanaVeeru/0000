package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Populating_Data_From_Excel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			FileInputStream fis=new FileInputStream("C://Users//ArchanaVeeru//Documents//Populate_Data.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			int rowcount=sheet.getLastRowNum();
			//int colcount=sheet.getRow(0).getLastCellNum();
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver=new FirefoxDriver();
			driver.get("http://newtours.demoaut.com/");
			for (int i=1;i<=rowcount;i++)
			{
				XSSFRow currentrow=sheet.getRow(i);
				
					String FirstName=currentrow.getCell(0).getStringCellValue();
					String LastName=currentrow.getCell(1).getStringCellValue();
					String Phone=currentrow.getCell(2).toString();
					String Email=currentrow.getCell(3).getStringCellValue();
					String Address=currentrow.getCell(4).getStringCellValue();
					String City=currentrow.getCell(5).getStringCellValue();
					String State=currentrow.getCell(6).getStringCellValue();
					String PostalCode=currentrow.getCell(7).toString();
					String country=currentrow.getCell(8).getStringCellValue();
					String Username=currentrow.getCell(9).getStringCellValue();
					String password=currentrow.getCell(10).getStringCellValue();
					String confirmpwd=currentrow.getCell(11).getStringCellValue();
					
					driver.findElement(By.linkText("REGISTER")).click();
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					
					driver.findElement(By.name("firstName")).sendKeys(FirstName);
					driver.findElement(By.name("lastName")).sendKeys(LastName);
					driver.findElement(By.name("phone")).sendKeys(Phone);
					driver.findElement(By.name("userName")).sendKeys(Email);
					driver.findElement(By.name("address1")).sendKeys(Address);
					driver.findElement(By.name("city")).sendKeys(City);
					driver.findElement(By.name("state")).sendKeys(State);
					driver.findElement(By.name("postalCode")).sendKeys(PostalCode);
					driver.findElement(By.name("country")).sendKeys(country);
					driver.findElement(By.name("email")).sendKeys(Username);
					driver.findElement(By.name("password")).sendKeys(password);
					driver.findElement(By.name("confirmPassword")).sendKeys(confirmpwd);
				driver.findElement(By.name("register")).click();
				System.out.println("printed");
			}
			workbook.close();
	}

}
