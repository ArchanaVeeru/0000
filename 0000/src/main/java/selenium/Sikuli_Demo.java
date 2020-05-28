/**
 * 
 */
package selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author ArchanaVeeru
 *
 */
public class Sikuli_Demo {

	/**
	 * @param args
	 * @throws FindFailed 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws FindFailed, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.youtube.com/watch?v=JultKcPcKjk");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Screen s=new Screen();
		Pattern pauseimg=new Pattern("C://Users/ArchanaVeeru/Documents/Pause.png");
		Pattern maximizeimg=new Pattern("C://Users/ArchanaVeeru/Documents/Maximize.png");
		Pattern skipadimg=new Pattern("C://Users/ArchanaVeeru/Documents/SkipAd.png");
		s.wait(pauseimg,2000);
		s.click();
		Thread.sleep(3000);
		s.wait(maximizeimg,2000);
		s.click();
		Thread.sleep(3000);
		s.wait(skipadimg,2000);
		Thread.sleep(6000);
		s.click();
		s.click();
		System.out.println("success");
		
		

	}

}
