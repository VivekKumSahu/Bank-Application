package forgot_password;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import comman_programs.DBConnection;

public class ForgotPasswordDAO
{
	public String forgotPassword(HttpServletRequest req,HttpServletResponse res)
    {
       String mailId="null";
       try
       {
    	   Connection con=DBConnection.getcon();
    	   PreparedStatement ps=con.prepareStatement("select * from BankMainTable where AccountNo=? and ContactNo=?");
    	   ps.setString(1,req.getParameter("accountno"));
    	   ps.setString(2,req.getParameter("phno"));
    	   ResultSet rs=ps.executeQuery();
    	   if(rs.next())
    	   {
    		   mailId=rs.getString(8);
    	   }   
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
       return mailId;
    }
}