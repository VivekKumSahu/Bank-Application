package new_account_opening;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import comman_programs.BeanClass;
import comman_programs.DBConnection;

public class NewAccountDAO
{
	   public int newAccount(BeanClass bc)
       {
            int k=0;
            try
            {
    	           Connection con=DBConnection.getcon();
    	           PreparedStatement ps=con.prepareStatement("insert into BankMainTable(AccountNo,Name,Password,FatherName,AadhaarNo,DateOfBirth,ContactNo,EmailId,Gender,Occupation,AccountType,Nominee,Address,Photo,AccountBalance) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    	           ps.setLong(1,bc.getAccountNo());
    	           ps.setString(2,bc.getName());
    	           ps.setString(3,bc.getPassword());
    	           ps.setString(4,bc.getFatherName());
    	           ps.setLong(5,bc.getAadhaarNo());    	           
    	           String dob=bc.getDateOfBirth();
    	           String getdob=dob.substring(8,10)+"-"+dob.substring(5,7)+"-"+dob.substring(0,4);
    	           ps.setString(6,getdob);
    	           ps.setLong(7,bc.getContactNo());
    	           ps.setString(8,bc.getEmailId());
    	           ps.setString(9,bc.getGender());
    	           ps.setString(10,bc.getOccupation());
    	           ps.setString(11,bc.getAccountType());
    	           ps.setString(12,bc.getNominee());
    	           ps.setString(13,bc.getAddress());
    	           ps.setBinaryStream(14,bc.getPhoto());
    	           ps.setDouble(15,0);
    	           k=ps.executeUpdate();
    	           if(k>0)
    	           {
    	        	   PreparedStatement ps1=con.prepareStatement("insert into AmountTransaction(AccountNo,Description,TransactionAmount,Time) values(?,?,?,?)");
    	        	   ps1.setLong(1,bc.getAccountNo());			   
    	        	   ps1.setString(2,"Opening Account");
    	        	   ps1.setDouble(3,0);
    	        	   ps1.setString(4,new Date().toString().substring(11,19));
    	        	   ps1.executeUpdate();
    	           }
            }
            catch(Exception e)
            {
    	           e.printStackTrace();
            }
            return k;
       }
}