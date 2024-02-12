package employee_options;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import comman_programs.BeanClass;
import comman_programs.DBConnection;

public class ViewAllCustomerDAO
{
	public ArrayList<BeanClass> viewAll(HttpServletRequest req,HttpServletResponse res)
    {
		ArrayList<BeanClass> al=new ArrayList<BeanClass>();
	    try
	    {
	        Connection con=DBConnection.getcon();
	        PreparedStatement ps=con.prepareStatement("select AccountNo,Name,AadhaarNo,ContactNo,Photo,AccountBalance from BankMainTable");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				BeanClass bc=new BeanClass();
			    bc.setAccountNo(rs.getLong(1));
			    bc.setName(rs.getString(2));
			    bc.setAadhaarNo(rs.getLong(3));
			    bc.setContactNo(rs.getLong(4));			    
			    byte[] imageData=rs.getBytes(5);
			    bc.setAccountBalance(rs.getDouble(6));
			    String photo="Project Image//"+rs.getString(1)+".png";
			    File f=new File("S://GitHub//Bank Application//Bank Application//src//main//webapp//"+photo);
			    @SuppressWarnings("resource")
			    FileOutputStream fos=new FileOutputStream(f);
			    fos.write(imageData);
			    bc.setDbPhoto(photo);
			    al.add(bc);
			}
	    }
	    catch(Exception e)
	    {
	    	  e.printStackTrace();
	    }
	    return al;
    }
}