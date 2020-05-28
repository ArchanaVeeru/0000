package selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser_Popups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Come & Go Test")).click();
		Set <String> handles=driver.getWindowHandles();
		Iterator <String> it=handles.iterator();
		String parentWindow=it.next();
		System.out.println("parent window id is"+parentWindow);
		String childWindow=it.next();
		driver.switchTo().window(childWindow);
		System.out.println("Present Window is child window"+childWindow);
		driver.quit();
		
	}

}
