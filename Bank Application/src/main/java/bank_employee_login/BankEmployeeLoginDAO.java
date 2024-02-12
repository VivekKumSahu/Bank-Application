package bank_employee_login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import comman_programs.DBConnection;

public class BankEmployeeLoginDAO
{
	public int employeeLogin(HttpServletRequest req,HttpServletResponse res)
    {
       int k=0;
       try
       {
    	   Connection con=DBConnection.getcon();
    	   PreparedStatement ps=con.prepareStatement("select * from BankEmployee where UserName=? and Password=?");
    	   ps.setString(1,req.getParameter("username"));
    	   ps.setString(2,req.getParameter("password"));
    	   ResultSet rs=ps.executeQuery();
    	   if(rs.next())
    	   {
    		   k=1;
    	   }   
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
       return k;
    }
}