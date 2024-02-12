package comman_programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InvalidPasswordCheckingDAO
{	         
	public boolean invalidPasswordChecking(HttpServletRequest req,HttpServletResponse res)
    {
		boolean k=true;
	    try
	    {
	        Connection con=DBConnection.getcon();
	        PreparedStatement ps=con.prepareStatement("select * from BankCountInvalid where AccountNo=?");
	        ps.setLong(1,Long.parseLong(req.getParameter("accountno")));
	        ResultSet rs=ps.executeQuery();
	        if(rs.next())
	        {
	        	if(rs.getInt(2)==3)
	        	{
	        		k=false;
	        	}
	        }	        	        
	    }
	    catch(Exception e)
	    {
	    	  e.printStackTrace();
	    }
	    return k;
    }
	public void deletecCount(HttpServletRequest req,HttpServletResponse res)
	{
	    try
	    {
	    	Connection con=DBConnection.getcon();
	    	PreparedStatement ps=con.prepareStatement("delete from BankCountInvalid where AccountNo=?");
	    	ps.setLong(1,Long.parseLong(req.getParameter("accountno")));
            ps.executeUpdate();	        	        
	    }
	    catch(Exception e)
	    {
	    	  e.printStackTrace();
	    }
    }
}