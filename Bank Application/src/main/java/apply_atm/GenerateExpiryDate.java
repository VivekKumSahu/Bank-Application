package apply_atm;

import java.util.Calendar;

public class GenerateExpiryDate
{
	 public String generateExpiryDate()
     {
		   Calendar calendar=Calendar.getInstance();
	       calendar.add(Calendar.YEAR,3);
	       String month=calendar.getTime().toString().substring(4,7);
	       String year=calendar.getTime().toString().substring(26,28);
	       String monthInNumber="";
	       switch(month)
	       {
	           case "Jan": monthInNumber="01"; break;
	           case "Feb": monthInNumber="02"; break;
	           case "Mar": monthInNumber="03"; break;
	           case "Apr": monthInNumber="04"; break;
	           case "May": monthInNumber="05"; break;
	           case "Jun": monthInNumber="06"; break;
	           case "Jul": monthInNumber="07"; break;
	           case "Aug": monthInNumber="08"; break;
	           case "Sep": monthInNumber="09"; break;
	           case "Oct": monthInNumber="10"; break;
	           case "Nov": monthInNumber="11"; break;
	           case "Dec": monthInNumber="12"; break;
	       }
	       String expiryDate=monthInNumber+"/"+year;
    	   return expiryDate;
     }
}