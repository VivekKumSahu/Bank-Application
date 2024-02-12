package comman_programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertIntoBankCountInvalidDAO
{
	public void insertIntoBankCountInvalid(HttpServletRequest req,HttpServletResponse res)
    {
	    try
	    {
	        Connection con=DBConnection.getcon();
	        PreparedStatement ps=con.prepareStatement("select * from BankCountInvalid where AccountNo=?");
	        ps.setLong(1,Long.parseLong(req.getParameter("accountno")));
	        ResultSet rs=ps.executeQuery();
	        if(rs.next())
	        {
	        	PreparedStatement ps1=con.prepareStatement("update BankCountInvalid set count=count+1 where AccountNo=?");
                ps1.setLong(1,Long.parseLong(req.getParameter("accountno")));
                ps1.executeUpdate();
	        }
	        else
	        {
	        	PreparedStatement ps2=con.prepareStatement("insert into BankCountInvalid values(?,?)");
                ps2.setLong(1,Long.parseLong(req.getParameter("accountno")));
                ps2.setInt(2,1);
                ps2.executeUpdate();
	        }	        	        
	    }
	    catch(Exception e)
	    {
	    	  e.printStackTrace();
	    }
    }
}