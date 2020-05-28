package selenium;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Parameterized.class)
public class Junit_Parameters {
	

	public static WebDriver driver;
	private String username,password,country,phonenum;
	//private long phonenum;
	public Junit_Parameters(String username,String password,String phonenum,String country) {
		this.username=username;
		this.password=password;
		this.phonenum=phonenum;
		this.country=country;
	}
	@Parameterized.Parameters
	public static Object[][] getData() throws IOException, CsvException{
		CSVReader reader=new CSVReader(new FileReader(System.getProperty("user.dir")+"/Additional_Files/Data.csv"));
		List<String[]> read=reader.readAll();
		int count=read.size();
		Object[][] data=new Object[count][4];
		for(int i=0;i<count;i++) {
			data[i]=read.get(i);
		}
		return data;
	}
//	@BeforeClass
//	public static void startup() {
//		System.out.println("just to instantiate");
//	}

	@Before
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/r.php");
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}
	@Rule
	public ErrorCollector collector=new ErrorCollector();

	@Test
	public void facebook() throws InterruptedException {
		collector.addError(new Throwable("error expected"));
		 driver.findElement(By.name("firstname")).sendKeys(username);
		  driver.findElement(By.name("lastname")).sendKeys(password);
		  driver.findElement(By.name("reg_email__")).sendKeys(phonenum);
		  driver.findElement(By.name("reg_passwd__")).sendKeys(country);
		  
		  Thread.sleep(2000);
	}
	@Test
	public void printData() {
		System.out.println(username);
		System.out.println(password);
		System.out.println(phonenum);
		System.out.println(country);
	}

}
