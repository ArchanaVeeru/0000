package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Readpoi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 FileInputStream fis=new FileInputStream("C://seleniumtestdate.xlsx");
		 XSSFWorkbook workbook=new XSSFWorkbook(fis);
		 XSSFSheet sheet=workbook.getSheet("Sheet1");
		 int rowcount=sheet.getLastRowNum();
		 int colcount=sheet.getRow(1).getLastCellNum();
		 for(int i=0;i<rowcount;i++)
		 {
			 XSSFRow currentRow=sheet.getRow(i);
			 for(int j=0;j<colcount;j++)
			 {
			System.out.print("    "+currentRow.getCell(j).toString());
			 }
			 System.out.println();
		 }
		 workbook.close();
		 
	}

}
