package selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
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
		Object[][] data=new Object[rowcount][colcount];
		while(result.next()) {
		for(int i=0;i<rowcount;i++) {
			
			String firstname=result.getString("firstname");
			String lastname=result.getString("lastname");
			String mobilenum=result.getString("mobilenum");
			String password=result.getString("password");
			

		}
		}
		

	}
	public static void returnData() {
		
	}

}
