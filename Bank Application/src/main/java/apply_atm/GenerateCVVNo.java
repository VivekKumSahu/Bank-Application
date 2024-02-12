package apply_atm;

import java.util.Random;

public class GenerateCVVNo
{
	  public String generateCVVNo()
      {
    	    String temp="0123456789";
	        Random random=new Random();
	        String cvvNo="";
	        for(int i=0;i<3;i++)
	        {
	  	        int num=random.nextInt(temp.length());
	  	        cvvNo=cvvNo+temp.charAt(num);
	  	    }
    	    return cvvNo;
      }
}