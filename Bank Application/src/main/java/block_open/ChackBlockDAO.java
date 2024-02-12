package block_open;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import comman_programs.DBConnection;

public class ChackBlockDAO
{
	public boolean chackBlock(HttpServletRequest req,HttpServletResponse res)
    {
       boolean k=true;
       try
       {
    	       Connection con=DBConnection.getcon();    	   
        	   PreparedStatement ps=con.prepareStatement("select * from BankMainTable where AccountNo=?");
        	   ps.setString(1,req.getParameter("accountno"));
        	   ResultSet rs=ps.executeQuery();
        	   if(rs.next())
        	   {
        		   rs.getString(17);
        		   if(rs.getString(17).equals("True")) k=false;
        	   }
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
       return k;
    }
}