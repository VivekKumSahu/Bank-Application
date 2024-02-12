package withdraw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import comman_programs.DBConnection;

public class AmountWithdrawDAO
{
	public double amountWithdraw(HttpServletRequest req,HttpServletResponse res)
    {
		double currentBalance=0;
	    try
	    {
	    	Connection con=DBConnection.getcon();
	    	PreparedStatement ps=con.prepareStatement("select * from BankMainTable where AccountNo=? and Password=?");
	    	ps.setLong(1,Long.parseLong(req.getParameter("accountno")));
		    ps.setString(2,req.getParameter("password"));
		    ResultSet rs=ps.executeQuery();
		    if(rs.next())
		    {
		    	rs.getString(17);
            	if(rs.getString(17).equals("True"))
            	{
            		if(rs.getDouble(16)>=Double.parseDouble(req.getParameter("amount")))
    		    	{
    		        	 PreparedStatement ps1=con.prepareStatement("insert into AmountTransaction(AccountNo,Description,TransactionAmount,Time) values(?,?,?,?)");
    		             ps1.setLong(1,Long.parseLong(req.getParameter("accountno")));			   
    		             ps1.setString(2,req.getParameter("Withdraw"));
    		        	 ps1.setDouble(3,Double.parseDouble(req.getParameter("amount")));
    		        	 ps1.setString(4,new Date().toString().substring(11,19));
    		        	 if(ps1.executeUpdate()>0)
    					 {
    					    currentBalance=rs.getDouble(16)-Double.parseDouble(req.getParameter("amount"));
    					    PreparedStatement ps2=con.prepareStatement("update BankMainTable set AccountBalance=? where AccountNo=?");
    					    ps2.setDouble(1,currentBalance);
    					    ps2.setLong(2,Long.parseLong(req.getParameter("accountno")));
    					    ps2.executeUpdate();
    					 }
    		        }
    		    	else
    		    	{
    		    		  currentBalance=-1;
    		    	}
            	}
            	else
            	{
            	    RequestDispatcher rd=req.getRequestDispatcher("InvalidPasswordThreeTime.jsp");
          	        rd.forward(req,res);
            	}		        
		    }
		    else
		    {
		    	 currentBalance=-2;
		    }
	    }
	    catch(Exception e)
	    {
	    	 e.printStackTrace();
	    }
	    return currentBalance;
    }
}