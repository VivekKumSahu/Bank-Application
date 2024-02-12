package block_open;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import comman_programs.GenerateOTP;
import comman_programs.SendMail;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/BlockOpenServlet")
public class BlockOpenServlet extends HttpServlet
{
  protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
  { 
	  HttpSession hs=req.getSession(false);
	  if(hs==null)
	  {
		  RequestDispatcher rd=req.getRequestDispatcher("SessionTimeOut.jsp");
		  rd.forward(req,res);		  
	  }
	  else
	  {
		   PrintWriter pw=res.getWriter();
		   res.setContentType("text/html");
		   if(new ChackBlockDAO().chackBlock(req,res))
		   {
				String mailId=new BlockOpenDAO().blockOpen(req,res);
				if(mailId==null)
				{
					  pw.println("<h1><strong style='color:#ff0f0f;'>Invalid Details Process</strong></h1>");
                      RequestDispatcher rd=req.getRequestDispatcher("BlockOpen.html");
                      rd.include(req,res);					  
				}
				else
				{   
					  ServletContext sc=req.getServletContext();
					  sc.setAttribute("accountno",req.getParameter("accountno"));
					  String OTP=new GenerateOTP().gernrateOTP(); 
				      sc.setAttribute("otp",OTP);
				      String message="Your OPT from Bank Of India is "+OTP+" enter it to unlock your account.";
				      new SendMail().sendMail(mailId,message);
					  RequestDispatcher rd=req.getRequestDispatcher("OpeningBlock.jsp");
					  rd.include(req,res);  
				}
	       }
		   else
		   {			  
				pw.println("<h1><strong style='color:#ff0f0f;'>You Account has Not Blocked</strong></h1>");
				RequestDispatcher rd=req.getRequestDispatcher("Main.html");
				rd.include(req,res);
		   }	      		  
	  }	  
  }
}