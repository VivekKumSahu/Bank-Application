package comman_programs;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection
{
              private static Connection con;
     
     private DBConnection()
     {
    	 
     }
     
     public static Connection getcon()
     {
    	 try
    	 {
    		Class.forName("oracle.jdbc.driver.OracleDriver");
 		    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","UserName","Password"); 
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
    	 return con;
     }
}