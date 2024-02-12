package apply_atm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import comman_programs.DBConnection;

public class ChakingCardDAO
{
	public boolean chakingCard(HttpServletRequest req,HttpServletResponse res)
    {
       boolean k=true;
       try
       {
    	       Connection con=DBConnection.getcon();    	   
        	   PreparedStatement ps=con.prepareStatement("select * from BankATMcardDetails where AccountNo=?");
        	   ps.setString(1,req.getParameter("accountno"));
        	   ResultSet rs=ps.executeQuery();
        	   if(rs.next())
        	   {
        		   k=false;
        	   }
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
       return k;
    }
}