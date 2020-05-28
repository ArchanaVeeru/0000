package selenium;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PDF_Doc {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		URL url=new URL("https://www.betterteam.com/downloads/employee-information-form-download-20170810.pdf");
		InputStream is=url.openStream();
		BufferedInputStream bis=new BufferedInputStream(is);
		PDDocument document=null;
		document=PDDocument.load(bis);
		String pdfcontent=new PDFTextStripper().getText(document);
		System.out.println(pdfcontent);
		
	}

}
