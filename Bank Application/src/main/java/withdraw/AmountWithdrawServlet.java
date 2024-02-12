package withdraw;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import comman_programs.InsertIntoBankCountInvalidDAO;
import comman_programs.InvalidPasswordCheckingDAO;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/AmountWithdrawServlet")
public class AmountWithdrawServlet extends HttpServlet
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
		  InvalidPasswordCheckingDAO ipc=new InvalidPasswordCheckingDAO();
		  if(ipc.invalidPasswordChecking(req,res))
	      {
			  double currentBalance=new AmountWithdrawDAO().amountWithdraw(req,res);
			  PrintWriter pw=res.getWriter();
			  res.setContentType("text/html");
			  if(currentBalance==-2) 
			  {
				  new InsertIntoBankCountInvalidDAO().insertIntoBankCountInvalid(req,res);
				  pw.println("<h1><strong style='color:#ff0f0f;'>Invalid AccountNo Or Password</strong></h1>");
				  RequestDispatcher rd=req.getRequestDispatcher("AmountWithdraw.html");
				  rd.include(req,res);
			  }
			  else if(currentBalance==-1)
			  {
				  ipc.deletecCount(req,res);
				  hs.invalidate();
				  pw.println("<h1><strong style='color:#ff0f0f;'>Insufficent Funds...</strong></h1>");
				  RequestDispatcher rd=req.getRequestDispatcher("Main.html");
				  rd.include(req,res);
			  }
			  else 
			  {
				  ipc.deletecCount(req,res);
				  hs.invalidate();
				  pw.println("<h1><strong>Amount Withdraw Successfull...</strong></h1>");
				  pw.println("<h1><strong style='color:#ff0f0f;'>Account Balance="+currentBalance+"</strong></h1>");
				  RequestDispatcher rd=req.getRequestDispatcher("Main.html");
				  rd.include(req,res);
			  }			  
	      }
		  else
	      {
	    	  RequestDispatcher rd=req.getRequestDispatcher("InvalidPasswordThreeTimeServlet");
		      rd.forward(req,res);
	      }		  
	  }	  
  }
}