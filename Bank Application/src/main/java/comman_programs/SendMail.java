package comman_programs;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail
{
      public void sendMail(String mailId,String message)
      {
          Properties pr=System.getProperties();
          pr.put("mail.smtp.host","smtp.gmail.com");
          pr.put("mail.smtp.port","465");
          pr.put("mail.smtp.ssl.enable","true");
          pr.put("mail.smtp.auth","true");
          Session s=Session.getInstance(pr,new Authenticator()
          {
			  @Override
			  protected PasswordAuthentication getPasswordAuthentication()
			  {
				   return new PasswordAuthentication("Mail Id","Password(16 Digit No)");
			  }        	  
          });
          s.setDebug(true);
          MimeMessage m=new MimeMessage(s);
          try
          {
        	  m.setFrom("Mail Id");        	  
        	  m.addRecipient(Message.RecipientType.TO,new InternetAddress(mailId));
        	  m.setSubject("Message From My Application");        	  
        	  m.setText(message);
        	  Transport.send(m);
          }
          catch(Exception e)
          {
        	  e.printStackTrace();
          }
      }
}