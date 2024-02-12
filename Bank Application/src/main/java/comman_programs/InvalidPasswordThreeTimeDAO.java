package comman_programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InvalidPasswordThreeTimeDAO
{
	public int invalidPasswordThreeTime(HttpServletRequest req,HttpServletResponse res)
    {
		int k=0;
	    try
	    {
	        Connection con=DBConnection.getcon();
	        PreparedStatement ps=con.prepareStatement("update BankMainTable set ThreeTime=? where AccountNo=?");
	        ps.setString(1,"False");
	        ps.setLong(2,Long.parseLong(req.getParameter("accountno")));
	        k=ps.executeUpdate();	        
	    }
	    catch(Exception e)
	    {
	    	  e.printStackTrace();
	    }
	    return k;
    }
}