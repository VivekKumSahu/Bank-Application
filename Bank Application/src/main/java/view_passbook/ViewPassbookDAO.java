package view_passbook;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import comman_programs.BeanClass;
import comman_programs.DBConnection;

public class ViewPassbookDAO
{
	public BeanClass viewPassbook(HttpServletRequest req,HttpServletResponse res)
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
           		     bc=new BeanClass();
     		         bc.setAccountNo(rs.getLong(1));
     		         bc.setName(rs.getString(2));
     		         bc.setFatherName(rs.getString(4));
     		         bc.setAadhaarNo(rs.getLong(5));
     		         bc.setDateOfBirth(rs.getString(6));
     		         bc.setContactNo(rs.getLong(7));
     		         bc.setEmailId(rs.getString(8));
     		         bc.setGender(rs.getString(9));
     		         bc.setOccupation(rs.getString(10));
     		         bc.setAccountType(rs.getString(11));
     		         bc.setNominee(rs.getString(12));
     		         bc.setAddress(rs.getString(13));
     		         Date od=rs.getDate(14);
     		         String openingDate=od.toString().substring(8,10)+"-"+od.toString().substring(5,7)+"-"+od.toString().substring(0,4);
     		         bc.setOpeningDate(openingDate);
     		         byte[] imageData=rs.getBytes(15);
     		         bc.setAccountBalance(rs.getDouble(16));
     		         String photo="Project Image//"+rs.getString(1)+".png";
     		         File f=new File("S://GitHub//Bank Application//Bank Application//src//main//webapp//"+photo);
     		         @SuppressWarnings("resource")
 			         FileOutputStream fos=new FileOutputStream(f);
     		         fos.write(imageData);
     		         bc.setDbPhoto(photo);
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