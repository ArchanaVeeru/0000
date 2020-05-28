package selenium;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Disable_Images {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		
		
		FirefoxOptions options=new FirefoxOptions();
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("permissions.default.image",2);
		options.setProfile(profile);
		options.setCapability(FirefoxDriver.PROFILE,profile);
		WebDriver driver=new FirefoxDriver(options);
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options=new ChromeOptions();
//		HashMap<String,Object> images=new HashMap<String,Object>();
//		images.put("images",2);
//		HashMap<String,Object> prefs=new HashMap<String,Object>();
//		prefs.put("profile.default_content_setting_values",images);
//		options.setExperimentalOption("prefs",prefs);
//		WebDriver driver=new ChromeDriver(options);
//		driver.get("https://www.amazon.com/");
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}

}
