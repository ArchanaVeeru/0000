package selenium;

import java.io.FileInputStream;





import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calculation {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		FileInputStream fis=new FileInputStream("C://Users//ArchanaVeeru//Documents//Populate_Data.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet3");
		int rowcount=sheet.getLastRowNum();
			driver.get("https://fd-calculator.in/result");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("amountInputField")).sendKeys(String.valueOf(2000));
		for(int i=0;i<=rowcount;i++) {
			
			XSSFRow currentrow=sheet.getRow(i);
			int fdamount=(int)currentrow.getCell(0).getNumericCellValue();
			int fdyear=(int)currentrow.getCell(1).getNumericCellValue();
			String year=currentrow.getCell(2).getStringCellValue();
			double intrest=currentrow.getCell(3).getNumericCellValue();
			String frequency=currentrow.getCell(4).getStringCellValue();
			//String result=currentrow.getCell(5).getStringCellValue();
		driver.findElement(By.id("amountInputField")).clear();
//			driver.findElement(By.id("periodInputField")).clear();
//			driver.findElement(By.id("amountSelectField")).clear();
//			driver.findElement(By.id("interestInputField")).clear();
//			driver.findElement(By.id("frequencySelectField")).clear();
			
			driver.findElement(By.id("amountInputField")).sendKeys(String.valueOf(fdamount));
			driver.findElement(By.id("periodInputField")).sendKeys(String.valueOf(fdyear));
			driver.findElement(By.id("amountSelectField")).sendKeys(year);
			driver.findElement(By.id("interestInputField")).sendKeys(String.valueOf(intrest));
			driver.findElement(By.id("frequencySelectField")).sendKeys(frequency);
			driver.findElement(By.id("calculateButton")).click();
			
			driver.findElement(By.id("amountInputField")).clear();
			driver.findElement(By.id("periodInputField")).clear();
//			driver.findElement(By.id("amountSelectField")).clear();
			driver.findElement(By.id("interestInputField")).clear();
//			driver.findElement(By.id("frequencySelectField")).clear();
			
			System.out.println(driver.findElement(By.xpath(".//*[@id='futureValue']")).getText());
			//*[@id="futureValue"]
		}
		workbook.close();
		
		
	}

}
