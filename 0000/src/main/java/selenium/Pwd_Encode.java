package selenium;

import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pwd_Encode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("Hello");
		
		driver.findElement(By.id("pass")).sendKeys(decodeString("[B@60e53b93"));
		driver.findElement(By.id("u_0_b")).click();
		
		
	}
	static String decodeString(String password)
	{
		byte[] pwd=Base64.decodeBase64(password);
		return (new String(pwd));
	}

}
