/**
 * 
 */
package selenium;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author ArchanaVeeru
 *
 */
public class Cookies_Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Set <Cookie> cookies=driver.manage().getCookies();
		System.out.println("total number of cookies are"+cookies.size());
		for(Cookie cookie:cookies)
		{
			System.out.println(cookie.getName()+"  "+cookie.getValue());
		}
		System.out.println(driver.manage().getCookieNamed("datr"));
		
		Cookie cobj=new Cookie("mycookie","1234");
		driver.manage().addCookie(cobj);
		cookies=driver.manage().getCookies();
		System.out.println("num of cookies are"+cookies.size());
		
	}

}
