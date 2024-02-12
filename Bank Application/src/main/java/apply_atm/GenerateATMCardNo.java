package apply_atm;

import java.util.Random;

public class GenerateATMCardNo
{
        public String generateATMCardNo()
        {
        	 String temp="0123456789";
    	     Random random=new Random();
    	     String atmNo="9845";
    	     for(int i=0;i<12;i++)
    	     {
    	  	    int num=random.nextInt(temp.length());
    	  	    atmNo=atmNo+temp.charAt(num);
    	  	 }
        	 return atmNo;
        }
}