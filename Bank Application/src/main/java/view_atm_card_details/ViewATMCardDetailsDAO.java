package view_atm_card_details;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import comman_programs.BeanClass;
import comman_programs.DBConnection;

public class ViewATMCardDetailsDAO
{
	public BeanClass viewATMCardDetails(HttpServletRequest req,HttpServletResponse res)
    {
       BeanClass bc=null;
       try
       {
    	   Connection con=DBConnection.getcon();
    	   PreparedStatement ps=con.prepareStatement("select * from BankMainTable where AccountNo=? and Password=?");
    	   ps.setString(1,req.getParameter("accountno"));
    	   ps.setString(2,req.getParameter("password"));
    	   ResultSet rs=ps.executeQuery();
    	   if(rs.next())
    	   {
    		   rs.getString(17);
           	   if(rs.getString(17).equals("True"))
           	   {
           		    PreparedStatement ps1=con.prepareStatement("select * from BankATMcardDetails where AccountNo=?");
                    ps1.setString(1,req.getParameter("accountno"));
                    ResultSet rs1=ps1.executeQuery();
                    if(rs1.next())
                    {
                             bc=new BeanClass();
                             bc.setAccountNo(rs1.getLong(1));
                             bc.setName(rs1.getString(2));
                             bc.setATMcardNo(rs1.getLong(3));        		     
                             bc.setExpiryDate(rs1.getString(4));
                             bc.setCvv(rs1.getInt(5));
                    } 
           	   }
           	   else
        	   {
        	        RequestDispatcher rd=req.getRequestDispatcher("InvalidPasswordThreeTime.jsp");
      	            rd.forward(req,res);
        	   }        	    
    	   }
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
       return bc;
    }
}