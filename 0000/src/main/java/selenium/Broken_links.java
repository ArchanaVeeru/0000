package selenium;




import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Broken_links {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		List <WebElement> links=driver.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++)
		{
			WebElement link=links.get(i);
			String url=link.getAttribute("href");
			URL urllinks=new URL(url);
			HttpURLConnection connection=(HttpURLConnection)urllinks.openConnection();
			int rescode=connection.getResponseCode();
			if(rescode>400)
				System.out.println(url+" "+"links is broken");
			else
				System.out.println(url+" "+"this link is working fine");
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
//		List <WebElement> links=driver.findElements(By.tagName("a"));
//		for(int i=0;i<links.size();i++)
//		{
//			WebElement element=links.get(i);
//			String url=element.getAttribute("href");
//			URL urllink=new URL(url);
//			HttpURLConnection connection=(HttpURLConnection) urllink.openConnection();
//			connection.connect();
//			int rescode=connection.getResponseCode();
//			if(rescode>400)
//				System.out.println(url+" "+"link  is broken");
//			else
//				System.out.println(url+" "+ "link is working fine");
//			
//		}
	}

}
