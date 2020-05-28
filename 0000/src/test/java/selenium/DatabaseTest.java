package selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatabaseTest {
  @Test
 public void database() throws SQLException {
	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCL","SCOTT","tiger");
		Statement stmt=con.createStatement();
		//String s="insert into emp values(1235,'hell','hell',5978,'','',1,10)";
		String s2="select * from facebook";
		
		
		ResultSet rs=stmt.executeQuery("select count(*) from facebook");
		rs.next();
		int rowcount=rs.getInt(1);
		
		ResultSet result=stmt.executeQuery(s2);
		ResultSetMetaData rs3=result.getMetaData();
		int colcount=rs3.getColumnCount();
		System.out.println("col count"+colcount);
		
		System.out.println("rowcount "+rowcount);
	  
		
		while(result.next()) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			
			driver.get("https://www.facebook.com/r.php");
				String firstname=result.getString("firstname");
				String lastname=result.getString("lastname");
				String mobilenum=result.getString("mobilenum");
				String password=result.getString("password");
				driver.findElement(By.name("firstname")).sendKeys(firstname);
				  driver.findElement(By.name("lastname")).sendKeys(lastname);
				  driver.findElement(By.name("reg_email__")).sendKeys(mobilenum);
				  driver.findElement(By.name("reg_passwd__")).sendKeys(password);
				  driver.close();

			}
		
  }
}
