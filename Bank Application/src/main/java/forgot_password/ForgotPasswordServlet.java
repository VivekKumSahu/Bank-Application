package forgot_password;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import comman_programs.GenerateOTP;
import comman_programs.SendMail;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet
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
		  String mailId=new ForgotPasswordDAO().forgotPassword(req,res);
		  if(mailId.equals("null")) 
		  {
			  PrintWriter pw=res.getWriter();
			  res.setContentType("text/html");
			  pw.println("<h1><strong>Invalid AccountNo Or Phone No</strong></h1>");
			  RequestDispatcher rd=req.getRequestDispatcher("ForgotPassword.html");
			  rd.include(req,res);
		  }
		  else 
		  {
			  ServletContext sc=req.getServletContext();
			  sc.setAttribute("accountno",req.getParameter("accountno"));
			  String OTP=new GenerateOTP().gernrateOTP();
			  sc.setAttribute("otp",OTP);
			  String message="Your OPT to change account password from Bank is "+OTP+" enter it to change password.";
		      new SendMail().sendMail(mailId,message);
			  RequestDispatcher rd=req.getRequestDispatcher("ChangePassword.jsp");
			  rd.forward(req,res);
		  }
	  }	  
  }
}