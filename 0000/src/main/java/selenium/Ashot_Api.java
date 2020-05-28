package selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class Ashot_Api {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement element=driver.findElement(By.xpath("//*[@id=\"blueBarDOMInspector\"]/div/div/div/div[1]/h1/a/i"));
		wait.until(ExpectedConditions.visibilityOf(element));
		Screenshot imagepath=new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,element);
		ImageIO.write(imagepath.getImage(),"png",new File("C://Users/ArchanaVeeru/Downloads/Facebooklogo.png"));
		File f=new File("C://Users/ArchanaVeeru/Downloads/Facebooklogo.png");
		
		if(f.exists())
			System.out.println("file existed");
		else
			System.out.println("File not existed");
		//*[@id="blueBarDOMInspector"]/div/div/div/div[1]/h1/a/i
	}

}
