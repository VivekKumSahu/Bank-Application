package forgot_password;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import comman_programs.DBConnection;

public class PasswordChangeDAO
{
	public int passwordChange(HttpServletRequest req,HttpServletResponse res)
    {
       int k=0;
       try
       {
    	   Connection con=DBConnection.getcon();
    	   PreparedStatement ps=con.prepareStatement("update BankMainTable set Password=? where AccountNo=?");
    	   ps.setString(1,req.getParameter("newpassword"));
    	   ServletContext sc=req.getServletContext();
    	   ps.setString(2,(String)sc.getAttribute("accountno"));
    	   k=ps.executeUpdate();
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
       return k;
    }
}