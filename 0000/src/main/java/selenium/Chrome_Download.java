/**
 * 
 */
package selenium;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author ArchanaVeeru
 *
 */
public class Chrome_Download {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		HashMap<String,Object> chromeprefs= new HashMap<String,Object>();
		chromeprefs.put("profile.default_content_settings.popup",0);
		chromeprefs.put("download.prompt_for_download","false");
		chromeprefs.put("download.default_directory","C:\\Downloadfiles");
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs",chromeprefs);
		
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		cap.setCapability(ChromeOptions.CAPABILITY,options);
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(cap);
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
