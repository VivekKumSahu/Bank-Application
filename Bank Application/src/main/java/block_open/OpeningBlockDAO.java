package block_open;

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import comman_programs.DBConnection;

public class OpeningBlockDAO
{
	   public int openingBlock(HttpServletRequest req,HttpServletResponse res)
       {
             int k=0;
             try
             {
            	  Connection con=DBConnection.getcon();
            	  PreparedStatement ps=con.prepareStatement("update BankMainTable set ThreeTime=? where AccountNo=?");
                  ps.setString(1,"True");
                  ServletContext sc=req.getServletContext();
           	      ps.setString(2,(String)sc.getAttribute("accountno"));
                  int x=ps.executeUpdate();
                  PreparedStatement ps1=con.prepareStatement("delete from BankCountInvalid where AccountNo=?");
                  ps1.setString(1,(String)sc.getAttribute("accountno"));
                  int y=ps1.executeUpdate();
                  if(x==1&&y==1) k=1;
             }
             catch(Exception e)
             {
    	           e.printStackTrace();
             }
             return k;
       }
}