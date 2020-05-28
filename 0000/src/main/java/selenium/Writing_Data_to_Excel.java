package selenium;


import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class Writing_Data_to_Excel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fos=new FileOutputStream("C://Users//ArchanaVeeru//Documents//Populate_Data.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Sheet4");
		
		for (int i=0;i<5;i++) {
			XSSFRow row=sheet.createRow(i);
			XSSFCell cell=row.createCell(i);
			cell.setCellValue("abc");
		}
		workbook.write(fos);
		fos.flush();
		workbook.close();
		System.out.println("updated");

	}

}
