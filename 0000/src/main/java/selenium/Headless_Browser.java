/**
 * 
 */
package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author ArchanaVeeru
 *
 */
public class Headless_Browser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options=new ChromeOptions();
//		//options.setHeadless(true);
//		options.addArguments("--headless");
//		WebDriver driver=new ChromeDriver(options);
//		driver.get("https://www.google.com");
//		System.out.println(driver.getTitle());
		
		
//		WebDriverManager.firefoxdriver().setup();
//		FirefoxOptions options=new FirefoxOptions();
//		options.setHeadless(true);
//		WebDriver driver=new FirefoxDriver(options);
//		driver.get("https://www.google.com");
//		System.out.println(driver.getTitle());

		HtmlUnitDriver driver=new HtmlUnitDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
		
	}

}
