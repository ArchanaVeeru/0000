/**
 * 
 */
package selenium;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author ArchanaVeeru
 *
 */
public class Barcode_QRcode {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NotFoundException 
	 */
	public static void main(String[] args) throws IOException, NotFoundException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//*[@id=\"HTML12\"]/div[1]/img[1]"));
		//*[@id="HTML12"]/div[1]/img[1]
		///html/body/div[4]/div[2]/div[2]/div[2]/footer/div/div[2]/div[2]/table/tbody/tr/td[2]/div/div[1]/div[1]/img[1]
		String barcodeurl=driver.findElement(By.xpath("//*[@id='HTML4']/div[1]/img")).getAttribute("src");
		URL url=new URL(barcodeurl);
		BufferedImage image=ImageIO.read(url);
		
		LuminanceSource source=new BufferedImageLuminanceSource(image);
		BinaryBitmap bitmap=new BinaryBitmap(new HybridBinarizer(source));
		Result result=new MultiFormatReader().decode(bitmap);
		System.out.println(result.getText());
	}

}
