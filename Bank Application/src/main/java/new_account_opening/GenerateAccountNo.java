package new_account_opening;

import java.util.Random;

public class GenerateAccountNo
{
        public String gernrateAccountNo()
        {
        	 String temp="0123456789";
    	     Random random=new Random();
    	     String accountNo="9420";
    	     for(int i=0;i<12;i++)
    	     {
    	  	    int num=random.nextInt(temp.length());
    	  	    accountNo=accountNo+temp.charAt(num);
    	  	 }
        	 return accountNo;
        }
}