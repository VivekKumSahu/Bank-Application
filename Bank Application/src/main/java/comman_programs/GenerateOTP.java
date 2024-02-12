package comman_programs;

import java.util.Random;

public class GenerateOTP
{
	    public String gernrateOTP()
        {
	         String temp="0123456789";
             Random random=new Random();
             String OTP="";
             for(int i=0;i<4;i++)
             {
 	              int num=random.nextInt(temp.length());
 	              OTP=OTP+temp.charAt(num);
 	         }
	         return OTP;
    }
}