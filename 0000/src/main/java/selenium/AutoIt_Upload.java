package selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoIt_Upload {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		driver.get("https://tus.io/demo.html");
		//driver.findElement(By.name("note")).sendKeys("hello");
		Thread.sleep(4000);
//		WebDriverWait wait=new WebDriverWait(driver,2000);
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("js-file-input"))));
//		driver.findElement(By.id("js-file-input")).click();;
		WebElement element=	driver.findElement(By.id("js-file-input"));
		JavascriptExecutor ja=(JavascriptExecutor)driver;
		ja.executeScript("arguments[0].click();",element);
		Thread.sleep(4000);
		Runtime.getRuntime().exec("C://Users/ArchanaVeeru/Autoit_file.exe");
		//driver.findElement(By.xpath("/html/body/form/input[3]")).click();
		
	}

}
