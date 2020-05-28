/**
 * 
 */
package selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author ArchanaVeeru
 *
 */
public class Firefox_Download {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/plain,application/pdf");
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		
		//profile.setPreference("browser.download.dir","C:\\Downloadfiles");//saves in a specified location other than downloads
		//profile.setPreference("browser.download.folderList",2);
		profile.setPreference("pdfjs.disabled",true);
		
		FirefoxOptions options=new FirefoxOptions();
		options.setProfile(profile);
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver(options);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		driver.findElement(By.id("textbox")).sendKeys("Hello World");
		driver.findElement(By.id("createTxt")).click();
		driver.findElement(By.id("link-to-download")).click();
		String path="C://Users/ArchanaVeeru/Downloads/info.txt";
		Thread.sleep(3000);
		if(isFileExist(path))
		{
			System.out.println("file existed");
			
		}
		else
			System.out.println("file does not exist");
		driver.findElement(By.id("pdfbox")).sendKeys("Hello");
		driver.findElement(By.id("createPdf")).click();
		driver.findElement(By.id("pdf-link-to-download")).click();
		String path1="C://Users/ArchanaVeeru/Downloads/info.txt";
		Thread.sleep(3000);
		if(isFileExist(path1))
		{
			System.out.println("file existed");
			
		}
		else
			System.out.println("file does not exist");
		
	}

	static boolean isFileExist(String path) {
		File f=new File(path);
		if(f.exists())
			return true;
		else
			return false;
	}
}
