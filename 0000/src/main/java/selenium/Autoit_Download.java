package selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Autoit_Download {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		//driver.findElement(By.name("note")).sendKeys("hello");
		Thread.sleep(4000);
		driver.findElement(By.id("textbox")).sendKeys("Hello ");
		Thread.sleep(4000);
		driver.findElement(By.id("createTxt")).click();
		driver.findElement(By.id("link-to-download")).click();
		Runtime.getRuntime().exec("C://Users/ArchanaVeeru/autoit_download.exe");
		
	}

}
