/**
 * 
 */
package selenium;

import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

/**
 * @author ArchanaVeeru
 *
 */
public class Ashot_comparision {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement element=driver.findElement(By.xpath("//*[@id=\"blueBarDOMInspector\"]/div/div/div/div[1]/h1/a/i"));
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
		Screenshot shot=new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,element);
		BufferedImage savedImage=ImageIO.read(new File("C://Users/ArchanaVeeru/Downloads/Facebooklogo.png"));
		BufferedImage expImg=shot.getImage();
		ImageDiffer differ=new ImageDiffer();
		ImageDiff diff=differ.makeDiff(expImg, savedImage);
		//File f=new File("C://Users/ArchanaVeeru/Downloads/Facebooklogo.png");
		//File f=new File();
		if(diff.hasDiff()==true)
			System.out.println("both images are not same");
		else
			System.out.println("both images are same");
		
				
	}

}
