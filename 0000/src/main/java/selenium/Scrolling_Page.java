package selenium;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scrolling_Page {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Logger log=Logger.getLogger("Scrolling_Page");
		PropertyConfigurator.configure("log4j.properties");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		//driver.findElement(By.name("note")).sendKeys("hello");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,1000)","");
		//js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("/html/body/section/footer/div/div/div[2]/a[1]/span")));
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		log.info("log successfull");
		
	}

}
