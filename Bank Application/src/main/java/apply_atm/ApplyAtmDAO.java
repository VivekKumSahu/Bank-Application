package apply_atm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import comman_programs.BeanClass;
import comman_programs.DBConnection;

public class ApplyAtmDAO
{
	public BeanClass applyAtm(HttpServletRequest req,HttpServletResponse res)
    {
       BeanClass bc=null;
       try
       {
    	   Connection con=DBConnection.getcon();
    	   PreparedStatement ps=con.prepareStatement("select * from BankMainTable where AccountNo=? and Password=? and Name=? and AadhaarNo=?");
    	   ps.setString(1,req.getParameter("accountno"));
    	   ps.setString(2,req.getParameter("password"));
    	   ps.setString(3,req.getParameter("name"));
    	   ps.setString(4,req.getParameter("aadhaarno"));
    	   ResultSet rs=ps.executeQuery();
    	   if(rs.next())
    	   {
    		   rs.getString(17);
           	   if(rs.getString(17).equals("True"))
           	   {
           		    long cardNo=Long.parseLong(new GenerateATMCardNo().generateATMCardNo());
     		        int cvv=Integer.parseInt(new GenerateCVVNo().generateCVVNo());
     		        String expiryDate=new GenerateExpiryDate().generateExpiryDate();
     		        bc=new BeanClass();
     		        bc.setAccountNo(Long.parseLong(req.getParameter("accountno")));
     		        bc.setName(req.getParameter("name"));
     		        bc.setAadhaarNo(Long.parseLong(req.getParameter("aadhaarno")));
     		        bc.setATMcardNo(cardNo);
     		        bc.setCvv(cvv);
     		        bc.setExpiryDate(expiryDate);
         	        PreparedStatement ps1=con.prepareStatement("insert into BankATMcardDetails(AccountNo,Name,ATMcardNo,ExpiryDate,CVV) values(?,?,?,?,?)");
         	        ps1.setLong(1,Long.parseLong(req.getParameter("accountno")));
         	        ps1.setString(2,(String)req.getParameter("name"));        	   
         	        ps1.setLong(3,cardNo);
         	        ps1.setString(4,expiryDate);
         	        ps1.setInt(5,cvv);
         	        ps1.executeUpdate();
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