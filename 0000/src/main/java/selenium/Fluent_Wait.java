package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fluent_Wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.phptravels.net/home");
		
		//driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id=\"search\"]/div/div/div/div/div/nav/ul/li[2]/a")).click();
//		boolean flag=element.isEnabled();
//		System.out.println("elemnt is enabled "+flag);
	List<WebElement> list=driver.findElements(By.xpath("//input[@name='triptype' and @type='radio']"));
		WebDriverWait wait=new WebDriverWait(driver,20);
//		
//		wait.until(ExpectedConditions.);
//		wait.pollingEvery(3,TimeUnit.SECONDS);
//		
		
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			WebElement element=list.get(i);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			String text=element.getAttribute("Value");
			System.out.println(text);
			if(text.equalsIgnoreCase("oneway"))
			{
				System.out.println("select this "+text);
				element.click();
			}
			
		}
		//*[@id="search"]/div/div/div/div/div/nav/ul/li[2]/a
		//driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[1]/div[1]/div/div[1]/label")).click();
	}

}
